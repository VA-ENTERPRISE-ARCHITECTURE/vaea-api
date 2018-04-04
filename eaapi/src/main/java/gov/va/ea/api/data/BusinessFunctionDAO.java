package gov.va.ea.api.data;

import gov.va.ea.api.model.BusinessFunction;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BusinessFunctionDAO extends BaseDAO
{
  public List<BusinessFunction> getBfs(String hierarchyNumber)
  {
    return jdbcTemplate.query(BRM_QUERY, new Object[] { hierarchyNumber }, new BusinessFunctionDAO.BfMapper(null));
  }
  
  private static String BRM_QUERY = "select master.ELEMENT_ID, master.BUSINESS_FUNCTION_ID, master.BUSINESS_FUNCTION_NAME,master.HIERARCHY_NUMBER, master.PARENT_BUSINESS_FUNCTION, master.BRM_LEVEL, org.ORGANIZATION_ACRONYM, org.ORGANIZATION_NAME, org.PARENT_0_ORGANIZATION from ( select ELEMENT_ID, BUSINESS_FUNCTION_ID, BUSINESS_FUNCTION_NAME,HIERARCHY_NUMBER, ORGANIZATION_ID, LEVEL as BRM_LEVEL, PARENT_BUSINESS_FUNCTION from  ee.element_attr_c46 START WITH HIERARCHY_NUMBER = ?  connect by prior BUSINESS_FUNCTION_ID = PARENT_BUSINESS_FUNCTION ORDER SIBLINGS BY HIERARCHY_NUMBER) master left join ee.ELEMENT_ATTR_C53 org on master.ORGANIZATION_ID = org.ORGANIZATION_ID";
}