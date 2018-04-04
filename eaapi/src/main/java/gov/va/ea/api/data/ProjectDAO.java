package gov.va.ea.api.data;

import gov.va.ea.api.model.Project;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAO
  extends BaseDAO
{
  public List<Project> getProjects(String vasiId)
  {
    return jdbcTemplate.query(PROJECT_QUERY, new Object[] { new BigDecimal(vasiId) }, new ProjectDAO.ProjectMapper(null));
  }
  
  private static String PROJECT_QUERY = "SELECT system_project.proj_id, project_name, office_of_responsibility, eps_code ,pl.description status FROM ee.element_attr_c67 system_project LEFT outer JOIN ee.element_attr_c54 project on system_project.proj_id = project.element_id LEFT OUTER JOIN ee.list_option pl on pl.option_id = project.project_status_pick_list WHERE system_project.system_id = ?";
}

