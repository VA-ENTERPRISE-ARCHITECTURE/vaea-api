package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemSecurity;

@Repository("SystemSecurityDAO.Vear")
public class SystemSecurityDAO extends BaseDAO {

    public List<SystemSecurity> getSystemSecurity() {
	return jdbcTemplate.query(system_security_query, new SystemSecurityMapper());
    }

    private static final class SystemSecurityMapper implements RowMapper<SystemSecurity> {
	public SystemSecurity mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemSecurity sysSec = new SystemSecurity();
	    sysSec.setSystemId(rs.getBigDecimal("system_id"));
	    sysSec.setSystemAcronym(rs.getString("system_acronym"));
	    sysSec.setSystemName(rs.getString("system_name"));
	    sysSec.setSystemDescription(rs.getString("system_description"));
	    sysSec.setSystemStatus(rs.getString("system_status"));
	    sysSec.setSecurityId(rs.getString("security_id"));
	    sysSec.setAto(rs.getString("name"));
	    sysSec.setAtoStatus(rs.getString("ato_status"));
	    sysSec.setAtoDate(rs.getString("ato_date"));
	    sysSec.setFismaClassification(rs.getString("fisma_classification"));
	    sysSec.setScConfidentiality(rs.getString("sc_confidentiality"));
	    sysSec.setScAvailability(rs.getString("sc_availability"));
	    sysSec.setScIntegrity(rs.getString("sc_integrity"));
	    sysSec.setSecurityDescription(rs.getString("security_description"));
	    sysSec.setEnvironment(rs.getString("environment"));
	    return sysSec;
	}
    }

    String system_security_query = "select  sys.system_id, sys.system_acronym, sys.system_name, sys.system_description\r\n"
	    + "    , lo2.description \"system_status\", sec.security_id, sec.name, lo1.description \"ato_status\"\r\n"
	    + "    , sec.ato_date, sec.fisma_classification, sec.sc_confidentiality\r\n"
	    + "    , sec.sc_availability, sec.sc_integrity, sec.description \"security_description\"\r\n"
	    + "    , sec.environment\r\n"
	    + "from  ee.element_attr_c56 sys, ee.element_attr_c68 sysSec, ee.element_attr_c55 sec\r\n"
	    + "    	,ee.list_option lo1, ee.list_option lo2\r\n"
	    + "where sysSec.system_id=sys.system_id and sysSec.security_id=sec.element_id\r\n"
	    + "    and sys.system_status_pick_list <> 1019 and lo1.option_id(+) = sec.ato_status\r\n"
	    + "    and lo2.option_id(+) = Sys.system_status_pick_list order by Sys.system_id";

}
