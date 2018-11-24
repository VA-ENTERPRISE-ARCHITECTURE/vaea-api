package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemOfSystem;

@Repository("SystemOfSystemDAO.Vear")
public class SystemOfSystemDAO extends BaseDAO {
    public List<SystemOfSystem> getSoSs() {
	return jdbcTemplate.query(SOS_QUERY, new SoSMapper());
    }

    private static final class SoSMapper implements RowMapper<SystemOfSystem> {
	public SystemOfSystem mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemOfSystem sos = new SystemOfSystem();
	    sos.setSystemId(rs.getBigDecimal("system_id"));
	    sos.setSystemName(rs.getString("system_name"));
	    sos.setSystemAcronym(rs.getString("system_acronym"));
	    sos.setSystemStatus(rs.getString("system_status"));
	    sos.setParentSystemId(rs.getString("parent_system"));
	    sos.setParentSystemName(rs.getString("parent_system_name"));
	    sos.setParentSystemAcronym(rs.getString("parent_system_acronym"));
	    sos.setParentSystemStatus(rs.getString("parent_status"));
	    return sos;
	}
    }

    private static String SOS_QUERY = "select system_id, system_name, system_acronym, description \"system_status\"\r\n"
	    + "	, parent_system, parent_system_name, parent_system_acronym, parent_status \r\n"
	    + "  from ( select csys.system_id, csys.system_name, csys.system_acronym, lo.description, \r\n"
	    + "        sos.parent_system, psys.system_name as parent_system_name, \r\n"
	    + "        psys.system_acronym as parent_system_acronym, lo1.description as parent_status\r\n"
	    + "        from ee.element_attr_c66 sos, ee.element_attr_c56 csys, ee.element_attr_c56 psys\r\n"
	    + "         ,ee.list_option lo, ee.list_option lo1 where csys.system_id = sos.child_system\r\n"
	    + "        AND psys.system_id = sos.PARENT_SYSTEM AND csys.system_status_pick_list = lo.option_id\r\n"
	    + "        AND csys.system_status_pick_list <> 1019 AND psys.system_status_pick_list = lo1.option_id\r\n"
	    + "       ) sos order by system_id";
}