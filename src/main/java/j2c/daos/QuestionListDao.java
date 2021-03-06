package j2c.daos;

import j2c.pojos.Answer;
import j2c.pojos.Question;
import j2c.pojos.Topic;
import j2c.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class QuestionListDao {

    public static int PAGE_SIZE = 10;
    public static int SEARCH_SIZE = 20;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;


    @Autowired
    public QuestionListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Question> findQuestions(boolean pullAnswers,String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;
        String sql = "SELECT * FROM " + tblName + " WHERE is_active='Y' order by update_time";
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
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
                if(pullAnswers)
                    q.setFirstAnswer(
                            (this.findAnswers(q.getId(),lang) != null && this.findAnswers(q.getId(),lang).size() > 0)
                                    ? this.findAnswers(q.getId(),lang).get(0): null );
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

    public List<Question> findQuestions(int topicId, boolean pullAnswers,String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;
        String sql = "SELECT * FROM " + tblName + " WHERE topic_id = ? and is_active='Y' order by update_time";
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,topicId);
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

                if(pullAnswers)
                    q.setFirstAnswer(
                            (this.findAnswers(q.getId(),lang) != null && this.findAnswers(q.getId(),lang).size() > 0)
                                    ? this.findAnswers(q.getId(),lang).get(0): null );
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


    public List<Answer> findAnswers(int qid,String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "a_all" : "a_all_" + lang;
        String sql = "SELECT * FROM " + tblName+ " WHERE qid = ? and is_active='Y'";
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


    //fix the bug for answer in a particular language
    public List<Question> findQuestionsByUser(int userId, boolean pullAnswers,String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "a_all" : "a_all_" + lang;
        String sql = "SELECT * FROM " +  tblName + " WHERE created_by = ? and is_active='Y' order by update_time";
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,userId);
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

                if(pullAnswers)
                    q.setFirstAnswer(
                            (this.findAnswers(q.getId(),lang) != null && this.findAnswers(q.getId(),lang).size() > 0)
                                    ? this.findAnswers(q.getId(),lang).get(0): null );
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



    public List<Question> findQuestionsByRange(int qidStart, boolean pullAnswers, String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;
        String sql = "SELECT * FROM " +  tblName + " WHERE qid > ? and is_active = 'Y'";
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,qidStart);
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

                if(pullAnswers)
                    q.setFirstAnswer(
                            (this.findAnswers(q.getId(),lang) != null && this.findAnswers(q.getId(),lang).size() > 0)
                                    ? this.findAnswers(q.getId(),lang).get(0): null );
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



    @Cacheable("questions")
    public HashMap<String, String> getAllQuestions() {

        String sql = "SELECT * FROM " + "q_all" + " WHERE is_active='Y' order by update_time";
        Connection conn = null;
        HashMap<String, String> hmap = new HashMap<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hmap.put(rs.getString("q_text"), "PRESENT");
            }

            rs.close();
            ps.close();
            return hmap;
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


    public List<Topic> findTopics(String lang){
        String sql = "SELECT * FROM topics where topic_lang = '" + lang + "'";
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
                        rs.getString("topic_name"),
                        rs.getString("topic_lang")
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

    public String getName() {
        return "qlist dao";
    }


    public List<Question> searchQuestions(String srchTxt, boolean pullAnswers,String lang){
        String tblName = (null == lang || "en".equalsIgnoreCase(lang)) ? "q_all" : "q_all_" + lang;
        String sql = "SELECT * FROM " + tblName + " WHERE q_text like '%" + srchTxt + "%' and is_active='Y' order by update_time limit " + SEARCH_SIZE;
        Connection conn = null;
        List<Question> questions = new ArrayList<>();
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setString(1,srchTxt);
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
                if(pullAnswers)
                    q.setFirstAnswer(
                            (this.findAnswers(q.getId(), lang) != null && this.findAnswers(q.getId(), lang).size() > 0)
                                    ? this.findAnswers(q.getId(), lang).get(0): null );
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


    public void populateQuestionsMap(HashMap<String, String> eqMap) {
        String sql = "SELECT qid, q_text FROM q_all";
        Connection conn = null;
        try {
            conn = this.jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setString(1,srchTxt);
            Question q = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                eqMap.put(rs.getString("q_text").toLowerCase().trim(),"PRESENT");
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

    }
}
