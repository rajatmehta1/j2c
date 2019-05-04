package j2c.daos;

import j2c.pojos.Topic;
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
public class TopicsDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public TopicsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Topic> findTopics(){
        String sql = "SELECT * FROM topics";
        Connection conn = null;
        List<Topic> tp = new ArrayList<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Topic q = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                q = new Topic(
                        rs.getInt("topic_id"),
                        rs.getString("topic_name")
                );

                tp.add(q);

            }

            rs.close();
            ps.close();
            return tp;
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
