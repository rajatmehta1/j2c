package j2c.daos;

import j2c.pojos.ClickVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ClickStreamDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClickStreamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean recordClick(ClickVO clickVO) {
        String sql = "insert into CLICK_STREAM(page_type,updated_by) " +
                "values(?,?)";
        return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setInt(1, clickVO.getPageType());
                ps.setString(2, clickVO.getUpdatedBy());

                return ps.execute();

            }

        });
    }

}
