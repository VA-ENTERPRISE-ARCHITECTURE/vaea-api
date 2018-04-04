package gov.va.ea.api.data;

import gov.va.ea.api.model.SystemOfSystem;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SystemOfSystemDAO
  extends BaseDAO
{
  public List<SystemOfSystem> getSoSs(String vasiId)
  {
    BigDecimal id = new BigDecimal(vasiId);
    return jdbcTemplate.query(SOS_QUERY, new Object[] { id, id }, new SystemOfSystemDAO.SoSMapper(null));
  }
  
  private static String SOS_QUERY = "SELECT DISTINCT sos.child_system, cs.system_name child_name, cs.system_acronym child_acronym, sos.parent_system, ps.system_name parent_name, ps.system_acronym parent_acronym FROM ee.element_attr_c66 sos LEFT OUTER JOIN ee.element_attr_c56 ps on sos.parent_system = ps.system_id LEFT OUTER JOIN ee.element_attr_c56 cs on sos.child_system = cs.system_id CONNECT BY PRIOR sos.child_system = sos.parent_system START WITH sos.parent_system IN ( SELECT parent_system FROM ee.element_attr_c66 START WITH child_system = ? CONNECT BY PRIOR parent_system = child_system UNION SELECT system_id FROM ee.element_attr_c56 WHERE system_id = ?)";
}