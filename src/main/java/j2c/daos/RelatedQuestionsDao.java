package j2c.daos;

import j2c.pojos.Question;
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

/*
 * Simple DAO pull related questions based on
 *
 * 1. Based on same category
 * 2. Presence of similar words
 */
@Component
public class RelatedQuestionsDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    public RelatedQuestionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getRelatedQuestions(int question_id,int topic_id, String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;
        String sql = "SELECT * FROM " + tblName + " WHERE is_active='Y' and qid != " + question_id + " and topic_id = " + topic_id + " order by update_time limit 10";
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
            System.out.println(" related questions query ==> " + sql);
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Question q = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                q = new Question(
                        rs.getInt("qid"),
                        rs.getString("q_text"),
                        rs.getInt("topic_id"),
                        rs.getInt("created_by")
                );

                q.setCreateDate(Util.getFormattedDate(rs.getString("update_time")));
                q.setDisplayName(userDao.getUser(rs.getInt("created_by")).getDisplayName());
                questions.add(q);

            }

            rs.close();
            ps.close();
            return questions;
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
