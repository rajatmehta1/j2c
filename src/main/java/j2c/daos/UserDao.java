package j2c.daos;

import j2c.pojos.User;
import j2c.utils.Util;
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
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers(){

        String sql = "select * from users where is_active = 'Y'";
        Connection conn = null;
        List<User> users = new ArrayList<>();

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User u = new User(rs.getInt("user_id"), rs.getString("email"));
                    users.add(u);
            }
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
        return users;
    }

    public User getUser(int usrId){

        String sql = "select * from users where is_active = 'Y' and user_id = '" + usrId + "'";
        Connection conn = null;
        List<User> users = new ArrayList<>();

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User u = new User(rs.getInt("user_id"), rs.getString("email"));
                users.add(u);
            }
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
        if(users.size() == 0) return new User(1,"admin@j2c.com");
        return users.get(0);
    }

    public int getRandomUserId() {
        List<User> users = this.getAllUsers();
        int rid = Util.getRandomNumberInRange(users.get(0).getId(), users.get(users.size() - 1).getId());
        return rid;
    }


}
