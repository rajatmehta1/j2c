package j2c.daos;

import j2c.pojos.LastKnown;
import j2c.pojos.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BatchDao {

//    public LastKnown getLastKnown(){
//        String sql = "SELECT * FROM q_all WHERE qid = ? and is_active='Y'";
//        Connection conn = null;
//        try {
//            conn = this.jdbcTemplate.getDataSource().getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setInt(1, qid);
//            Question q = null;
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//
//                q = new Question(
//                        rs.getInt("qid"),
//                        rs.getString("q_text"),
//                        rs.getInt("topic_id"),
//                        rs.getInt("created_by")
//                );
//
//            }
//            if(pullAnswers) q.setAnsList(this.findAnswers(qid));
//            rs.close();
//            ps.close();
//            return q;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {}
//            }
//        }
//    }

}
