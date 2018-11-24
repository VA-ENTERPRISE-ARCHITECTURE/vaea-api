package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.Project;

@Repository("ProjectDAO.Vear")
public class ProjectDAO extends BaseDAO {
    public List<Project> getProjects() {
	return jdbcTemplate.query(PROJECT_QUERY, new ProjectMapper());
    }

    private static final class ProjectMapper implements RowMapper<Project> {
	public Project mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    Project proj = new Project();
	    proj.setSystemId(rs.getBigDecimal("system_id"));
	    proj.setSystemName(rs.getString("system_name"));
	    proj.setSystemStatus(rs.getString("system_status"));
	    proj.setSystemAcronym(rs.getString("system_acronym"));
	    proj.setEpmdPortfolio(rs.getString("epmd_portfolio"));
	    proj.setVipProjectId(rs.getBigDecimal("project_id"));
	    proj.setProjectName(rs.getString("project_name"));
	    proj.setProjectStatus(rs.getString("project_status"));
	    proj.setEpsCode(rs.getString("eps_code"));
	    proj.setProjectInvestmentCode(rs.getString("unique_investment_identifier"));
	    return proj;
	}
    }

    private static String PROJECT_QUERY = "select sys.system_id, sys.system_acronym, sys.system_name, lo2.description \"system_status\"\r\n"
	    + "    , port.name \"epmd_portfolio\", proj.project_id, proj.project_name\r\n"
	    + "    , lo1.description \"project_status\", proj.eps_code, proj.unique_investment_identifier\r\n"
	    + "from ee.element_attr_c67 sp, ee.element_attr_c56 sys, ee.element_attr_c54 proj, \r\n"
	    + "    ee.element_attr_c1416 port, ee.list_option lo1, ee.list_option lo2\r\n"
	    + "where sp.system_id = sys.system_id and sp.proj_id = proj.element_id\r\n"
	    + "and lo1.option_id (+) = proj.project_status_pick_list and port.element_id = proj.portfolio\r\n"
	    + "and sys.system_status_pick_list <> 1019 and sys.system_status_pick_list = lo2.option_id(+)\r\n"
	    + "order by sys.system_id";
}
