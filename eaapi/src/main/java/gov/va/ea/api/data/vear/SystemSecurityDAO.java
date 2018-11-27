package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemSecurity;

public class SystemSecurityDAO extends BaseDAO {

    public List<SystemSecurity> getSystemSecurity() {
	return jdbcTemplate.query(system_location_qurey, new SystemSecurityMapper());
    }

    private static final class SystemSecurityMapper implements RowMapper<SystemSecurity> {
	public SystemSecurity mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemSecurity sysSec = new SystemSecurity();
	    sysSec.setSystemId(rs.getBigDecimal("system_id"));
	    sysSec.setSystemAcronym(rs.getString("system_acronym"));
	    sysSec.setSystemName(rs.getString("system_name"));
	    sysSec.setSystemDescription(rs.getString("system_description"));
	    sysSec.setSystemStatus(rs.getString("system_status"));

	    return sysSec;
	}
    }

    String system_location_qurey = "";

}
