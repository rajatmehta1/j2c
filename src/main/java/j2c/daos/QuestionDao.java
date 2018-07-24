package j2c.daos;

import j2c.pojos.Answer;
import j2c.pojos.Question;
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
public class QuestionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Question q){

        String sql = "INSERT INTO q_all " +
                "(q_text, topic_id, created_by, is_active ) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, q.getQsTxt());
            ps.setInt(2, q.getTopicId());
            ps.setInt(3, q.getCreatedBy());
            ps.setString(4, "Y");
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


    public Question findQuestion(int qid,boolean pullAnswers){
        String sql = "SELECT * FROM q_all WHERE qid = ? and is_active='Y'";
        Connection conn = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, qid);
            Question q = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                q = new Question(
                        rs.getInt("qid"),
                        rs.getString("q_text"),
                        rs.getInt("topic_id"),
                        rs.getInt("created_by")
                );

            }
            if(pullAnswers) q.setAnsList(this.findAnswers(qid));
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


    public List<Answer> findAnswers(int qid){
        String sql = "SELECT * FROM a_all WHERE qid = ? and is_active='Y'";
        Connection conn = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, qid);
            List<Answer> ansList = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            Answer a = null;
            while (rs.next()) {

                a = new Answer(
                        rs.getInt("aid"),
                        rs.getString("a_text"),
                        rs.getInt("created_by")
                );
                ansList.add(a);
            }
            rs.close();
            ps.close();
            return ansList;
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



    public void insertAnswer(Answer a){

        String sql = "INSERT INTO a_all " +
                "(a_text, qid, created_by, is_active ) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getAnsTxt());
            ps.setInt(2, a.getQuestionId());
            ps.setInt(3, a.getCreatedBy());
            ps.setString(4, "Y");
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

}

