package gov.va.ea.api.data;

import gov.va.ea.api.model.Organization;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationDAO
  extends BaseDAO
{
  public List<Organization> getOrgs(String orgId)
  {
    return jdbcTemplate.query(ORG_QUERY, new Object[] { new BigDecimal(orgId) }, new OrganizationDAO.OrgMapper(null));
  }
  
  public int getNumberOfSystems(String orgId)
  {
    return ((Integer)jdbcTemplate.queryForObject(SYS_QUERY, new Object[] { orgId }, Integer.class)).intValue();
  }
  
  private static String ORG_QUERY = "SELECT org.element_id, org.organization_id, org.organization_name, org.organization_acronym, org.mail_stop, org.parent_organization, LEVEL as ORG_LEVEL, org.PARENT_0_ORGANIZATION FROM ee.element_attr_c53 org  START WITH org.organization_id = ?  CONNECT BY PRIOR org.organization_id = org.parent_organization  ORDER SIBLINGS BY org.organization_id";
  private static String SYS_QUERY = "select count(*)from ee.element_attr_c56 system where system.organization_id in ( SELECT org.organization_id FROM ee.element_attr_c53 org START WITH org.organization_id = ?  CONNECT BY PRIOR org.organization_id = org.parent_organization) and SYSTEM_STATUS_PICK_LIST in (715, 716)";
}