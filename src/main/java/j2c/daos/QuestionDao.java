package j2c.daos;

import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class QuestionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    public QuestionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Question q, String lang){

        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;

        String sql = "INSERT INTO " + tblName + " " +
                "(q_text, topic_id, created_by, is_active,q_link ) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, q.getQsTxt());
            ps.setInt(2, q.getTopicId());
            ps.setInt(3, q.getCreatedBy());
            ps.setString(4, "Y");
            ps.setString(5, q.getQlink());
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


    public Question findQuestion(int qid,boolean pullAnswers, String lang){

        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;

        String sql = "SELECT * FROM " + tblName + " WHERE qid = ? and is_active='Y'";
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

                q.setCreateDate(Util.getFormattedDate(rs.getString("update_time")));
                q.setDisplayName(userDao.getUser(rs.getInt("created_by")).getDisplayName());

            }
            if(pullAnswers) q.setAnsList(this.findAnswers(qid, lang));
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


    public List<Answer> findAnswers(int qid, String lang){

        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "a_all" : "a_all_" + lang;

        String sql = "SELECT * FROM " + tblName + " WHERE qid = ? and is_active='Y'";
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



    public void insertAnswer(Answer a, String lang){

        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "a_all" : "a_all_" + lang;

        String sql = "INSERT INTO " + tblName + " " +
                "(a_text, qid, created_by, is_active ) VALUES (?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getAnsTxt());
            ps.setInt(2, a.getQuestionId());

            if(null == a.getCreatedBy()) {
                ps.setInt(3, Util.getCreatedBy());
            } else {
                ps.setInt(3, a.getCreatedBy());
            }
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

    public int insertWithKey(Question q, String lang) {
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;

        String sql = "INSERT INTO " + tblName + " " +
                "(q_text, topic_id, created_by, is_active ) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        int key = -1;

        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, q.getQsTxt());
            ps.setInt(2, q.getTopicId());
            if(null == q.getCreatedBy()) {
                ps.setInt(3, Util.getCreatedBy());
            } else {
                ps.setInt(3, q.getCreatedBy());
            }
            ps.setString(4, "Y");
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                key = rs.getInt(1);
            }
            rs.close();
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
        return key;
    }
}

