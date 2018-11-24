package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.BusinessFunction;

@Repository("BusinessFunctionDAO.Vear")
public class BusinessFunctionDAO extends BaseDAO {
    private static String BF_DETAIL_URL_1 = "https://vaausdarapp41.aac.dva.va.gov/ee/request/folder/e/";
    private static String BF_DETAIL_URL_2 = "/c/46/nt/-1?name-lookup=BUS_HOME";

    public List<BusinessFunction> getBfs() {
	return jdbcTemplate.query(BFF_LIST_QUERY, new BfMapper());
    }

    private static final class BfMapper implements RowMapper<BusinessFunction> {
	public BusinessFunction mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    BusinessFunction bf = new BusinessFunction();

	    bf.setSystemId(rs.getBigDecimal("system_id"));
	    bf.setSystemAcronym(rs.getString("system_acronym"));
	    bf.setSystemName(rs.getString("system_name"));
	    bf.setSystemStatus(rs.getString("system_status"));

	    bf.setHierarchyNumber(rs.getString("HIERARCHY_NUMBER"));
	    bf.setBusinessFunction(rs.getString("business_function_name"));
	    bf.setBusinessDescription(rs.getString("business_description"));
	    bf.setOrganizationName(rs.getString("organization_acronym"));
	    return bf;
	}
    }

    private static String BFF_LIST_QUERY = "SELECT sys.system_id, sys.system_acronym, sys.system_name, lo2.description \"system_status\",\r\n"
	    + "    TopLevel.hierarchy_number, TopLevel.business_function_name \r\n"
	    + "      ,TopLevel.description \"business_description\", org.organization_acronym \r\n"
	    + "FROM ee.element_attr_c56 sys, ee.element_attr_c57 sysBizFunc, ee.element_attr_c53 org, ee.list_option lo2\r\n"
	    + "    ,(select connect_by_root business_function_id business_function_id, PARENT_BUSINESS_FUNCTION,  \r\n"
	    + "        HIERARCHY_NUMBER, business_function_name, description,ORGANIZATION_ID, level as lvl \r\n"
	    + "        from  EE.ELEMENT_ATTR_C46 where HIERARCHY_NUMBER <> '0'\r\n"
	    + "         CONNECT BY PRIOR PARENT_BUSINESS_FUNCTION= business_function_id) TopLevel\r\n"
	    + "WHERE Toplevel.business_function_id = sysBizFunc.business_function_id\r\n"
	    + "  AND sys.system_id = sysBizFunc.system_id AND org.ORGANIZATION_ID(+) = TopLevel.ORGANIZATION_ID\r\n"
	    + "  AND sys.SYSTEM_STATUS_PICK_LIST <> 1019 AND sys.SYSTEM_STATUS_PICK_LIST = lo2.option_id(+)\r\n"
	    + "ORDER BY sys.system_id, TopLevel.business_function_id, TopLevel.lvl DESC";

}