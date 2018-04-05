package gov.va.ea.api.data;

import gov.va.ea.api.model.Stakeholder;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StakeholderDAO
  extends BaseDAO
{
  public List<Stakeholder> getStakeholders(String vasiId)
  {
    return jdbcTemplate.query(STAKEHOLDER_QUERY, new Object[] { new BigDecimal(vasiId) }, new StakeholderDAO.StakeholderMapper(null));
  }
  
  private static String STAKEHOLDER_QUERY = "SELECT (last_name||', '||first_name) name, title, phone, lower(email) email, org.organization_name , pl.description type FROM ee.element_attr_c403 system_stakeholder  LEFT outer JOIN ee.element_attr_c402 stakeholder on stakeholder.stakeholder_id = system_stakeholder.stakeholder_id  LEFT outer JOIN ee.element_attr_c53 org on stakeholder.organization_id = org.organization_id  LEFT OUTER JOIN ee.list_option pl on pl.option_id = system_stakeholder.stakeholder_type_id WHERE system_stakeholder.system_id =  ?";
}