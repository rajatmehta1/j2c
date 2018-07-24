package j2c.daos;

import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User u){

        String sql = "INSERT INTO users " +
                "(email, pwd, is_active ) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getPwd());
            ps.setString(3, "Y");
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public boolean userExists(User u){
        String sql = "SELECT count(*) FROM users WHERE email = ? ";
        Connection conn = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ResultSet rs = ps.executeQuery();
            int size = rs.getInt(0);
            rs.close();
            ps.close();
            if(size == 0) return false;
            else return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }


    public User authenticate(String email, String pwd){
        String sql = "SELECT email FROM users WHERE email = ? and pwd = ? and is_active='Y'";
        Connection conn = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pwd);
            User q = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                q = new User(
                        rs.getString("email")
                );

            }
            rs.close();
            ps.close();
            return q;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }


}
