package gov.va.ea.api.data;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.model.Project;

@Repository
public class ProjectDAO extends BaseDAO {
    public List<Project> getProjects() {
	return jdbcTemplate.query(PROJECT_QUERY, new ProjectMapper());
    }

    public List<Project> getProjects(String vasiId) {
	return jdbcTemplate.query(SYSTEM_PROJ_QUERY, new Object[] { new BigDecimal(vasiId) }, new SysProjMapper());
    }

    private static final class SysProjMapper implements RowMapper<Project> {
	public Project mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    Project proj = new Project();
	    proj.setName(rs.getString("project_name"));
	    proj.setStatus(rs.getString("status"));
	    proj.setEPSCode(rs.getString("eps_code"));
	    proj.setEpmdPortfolio(rs.getString("EPMD_PORTFOLIO"));
	    proj.setProjectInvestmentCode(rs.getString("PROJECT_INVESTMENT_CODE"));
	    proj.setProjectId(rs.getBigDecimal("proj_id"));
	    return proj;
	}
    }

    private static final class ProjectMapper implements RowMapper<Project> {
	public Project mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    Project proj = new Project();
	    proj.setName(rs.getString("project_name"));
	    proj.setStatus(rs.getString("status"));
	    proj.setEPSCode(rs.getString("eps_code"));
	    proj.setEpmdPortfolio(rs.getString("EPMD_PORTFOLIO"));
	    proj.setProjectInvestmentCode(rs.getString("PROJECT_INVESTMENT_CODE"));
	    proj.setProjectId(rs.getBigDecimal("project_id"));
	    return proj;
	}
    }

    private static String PROJECT_QUERY = "SELECT project.project_id, project_name, pl.description status, port.NAME EPMD_PORTFOLIO, project.UNIQUE_INVESTMENT_IDENTIFIER PROJECT_INVESTMENT_CODE, eps_code FROM ee.element_attr_c54 project, \r\n"
	    + "ee.list_option pl, ee.element_attr_c1416 port WHERE pl.option_id(+) = project.project_status_pick_list and port.ELEMENT_ID = project.PORTFOLIO";

    private static String SYSTEM_PROJ_QUERY = "SELECT system_project.proj_id, project_name, pl.description status, port.NAME EPMD_PORTFOLIO, project.UNIQUE_INVESTMENT_IDENTIFIER PROJECT_INVESTMENT_CODE, eps_code FROM ee.element_attr_c67 system_project, ee.element_attr_c54 project, ee.list_option pl, ee.element_attr_c1416 port WHERE system_project.proj_id = project.element_id (+) and pl.option_id(+) = project.project_status_pick_list and port.ELEMENT_ID = project.PORTFOLIO and system_project.system_id = ?";
    // "SELECT system_project.proj_id, project_name, office_of_responsibility,
    // eps_code ,pl.description status FROM ee.element_attr_c67 system_project LEFT
    // outer JOIN ee.element_attr_c54 project on system_project.proj_id =
    // project.element_id LEFT OUTER JOIN ee.list_option pl on pl.option_id =
    // project.project_status_pick_list WHERE system_project.system_id = ?";
}
