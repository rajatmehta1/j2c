package j2c.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import j2c.pojos.Answer;

@Component
public class AnswerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AnswerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Answer getAnswer(int answerId) {
        String sql =
                "SELECT * FROM a_all where aid = ? and is_active = 'Y";
        Connection conn = null;
        Answer a = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,answerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                a = new Answer(rs.getInt("aid"), rs.getString("a_text"), rs.getInt("created_by"));
            }
            rs.close();
            ps.close();
            return a;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch(SQLException e) {}
            }
        }

    }



}
