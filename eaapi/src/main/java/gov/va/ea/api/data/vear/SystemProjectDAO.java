package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemProject;

@Repository("SystemProjectDAO.Vear")
public class SystemProjectDAO extends BaseDAO {
    public List<SystemProject> getSystemProjects() {
	return jdbcTemplate.query(SYSTEM_PROJECT_QUERY, new SystemProjectMapper());
    }

    private static final class SystemProjectMapper implements RowMapper<SystemProject> {
	public SystemProject mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemProject sysProj = new SystemProject();
	    sysProj.setSystemId(rs.getBigDecimal("system_id"));
	    sysProj.setSystemAcronym(rs.getString("system_acronym"));
	    sysProj.setSystemName(rs.getString("system_name"));
	    sysProj.setSystemStatus(rs.getString("SYSTEM_STATUS"));
	    sysProj.setEpmdPortfolio(rs.getString("EPMD_PORTFOLIO"));
	    sysProj.setProjectId(rs.getBigDecimal("project_id"));
	    sysProj.setProjectName(rs.getString("project_name"));
	    sysProj.setProjectStatus(rs.getString("PROJECT_STATUS"));
	    sysProj.setEpsCode(rs.getString("eps_code"));
	    sysProj.setProjectInvestmentCode(rs.getString("PROJECT_INVESTMENT_CODE"));
	    return sysProj;
	}
    }

    private static String SYSTEM_PROJECT_QUERY = "select sys.system_id, sys.system_acronym, sys.system_name, lo1.description SYSTEM_STATUS, port.NAME EPMD_PORTFOLIO, proj.project_id, proj.project_name, lo2.description PROJECT_STATUS, proj.eps_code, proj.UNIQUE_INVESTMENT_IDENTIFIER PROJECT_INVESTMENT_CODE from  ee.element_attr_c67 sp,ee.ELEMENT_ATTR_C56 sys, ee.ELEMENT_ATTR_C54 proj, ee.element_attr_c1416 port, ee.list_option lo1, ee.list_option lo2 where sp.system_id = sys.system_id \r\n"
	    + "and lo1.option_id (+) = sys.SYSTEM_STATUS_PICK_LIST and sp.proj_id = proj.element_id and lo2.option_id (+) = proj.PROJECT_STATUS_PICK_LIST and port.ELEMENT_ID = proj.PORTFOLIO and SYSTEM_STATUS_PICK_LIST <> 1019 order by sys.system_name";

}
