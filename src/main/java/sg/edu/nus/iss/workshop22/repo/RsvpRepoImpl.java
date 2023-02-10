package sg.edu.nus.iss.workshop22.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop22.model.Rsvp;
import static sg.edu.nus.iss.workshop22.repo.Queries.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

@Repository
public class RsvpRepoImpl implements RsvpRepo {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Rsvp> getAllRsvp() {
        return jdbc.query(GET_ALL_RSVP, new ResultSetExtractor<List<Rsvp>>() {

            List<Rsvp> listOf = new LinkedList<>();

            @Override
            public List<Rsvp> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    BeanPropertyRowMapper<Rsvp> bprm = new BeanPropertyRowMapper<Rsvp>(Rsvp.class);
                    Rsvp rsvp = bprm.mapRow(rs, 0);
                    listOf.add(rsvp);
                }
                return listOf;
            }

        });
    }

    @Override
    public List<Rsvp> getRsvpByName(String name) {

        return jdbc.query(GET_RSVP_BY_NAME, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, name);
            }

        }, new ResultSetExtractor<List<Rsvp>>() {

            List<Rsvp> listOf = new LinkedList<>();

            @Override
            public List<Rsvp> extractData(ResultSet rs) throws SQLException, DataAccessException {
                while (rs.next()) {
                    BeanPropertyRowMapper<Rsvp> bprm = new BeanPropertyRowMapper<Rsvp>(Rsvp.class);
                    Rsvp rsvp = bprm.mapRow(rs, 0);
                    listOf.add(rsvp);
                }
                return listOf;
            }
        });
    }

    @Override
    public Integer updateRsvp(Rsvp rsvp) {
        return jdbc.update(UPDATE_RSVP, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, rsvp.fullName);
                ps.setString(2, rsvp.email);
                ps.setInt(3, rsvp.phone);
                ps.setDate(4, rsvp.confirmationDate);
                ps.setString(5, rsvp.comments);
            }
        });
    }

    @Override
    public Integer overwriteRsvp(Rsvp rsvp, int id) {

        Object[] args = new Object[] {
                rsvp.fullName,
                rsvp.email,
                rsvp.phone,
                rsvp.confirmationDate,
                rsvp.comments,
                id };
        int[] argsTypes = new int[] {
                Types.VARCHAR,
                Types.VARCHAR,
                Types.DECIMAL,
                Types.DATE,
                Types.VARCHAR,
                Types.INTEGER };
        return jdbc.update(OVERWRITE_RSVP, args, argsTypes);
    }

    @Override
    public Integer updateEmailRsvp(String email1, String email2) {
        Object[] args = new Object[] {
                email1,
                email2
        };
        int[] argsTypes = new int[] {
                Types.VARCHAR,
                Types.VARCHAR,
        };
        return jdbc.update(UPDATE_EMAIL_RSVP, args, argsTypes);
    }

    @Override
    public Integer getRsvpCount() {
        return jdbc.query(COUNT_RSVP, new ResultSetExtractor<Integer>() {

            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt("count");
            }

        });
    }

}
