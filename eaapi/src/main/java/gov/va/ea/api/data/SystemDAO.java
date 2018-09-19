package gov.va.ea.api.data;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.model.SystemBusinessFunction;
import gov.va.ea.api.model.VASystem;

@Repository
public class SystemDAO extends BaseDAO {
    private static String VASI_DETAIL_URL_1 = "https://vaausdarapp41.aac.dva.va.gov/ee/request/folder/e/";
    private static String VASI_DETAIL_URL_2 = "/c/56/nt/-1?name-lookup=vasi_home";

    public VASystem getSystem(String vasiId) {
	VASystem system = null;
	system = (VASystem) jdbcTemplate.queryForObject(SYSTEM_DETAIL_QUERY, new Object[] { new BigDecimal(vasiId) },
		new SystemMapper());

	return system;
    }

    public List<VASystem> getActiveSystems() {
	return jdbcTemplate.query(ACTIVE_SYSTYEM_LIST_QUERY, new SystemMapper());
    }

    public List<SystemBusinessFunction> getSystemBusinessFunctions() {
	return jdbcTemplate.query(SYSTEM_BUSINESSFUNCTION_QUERY, new SystemBusinessFunctionMapper());
    }

    private static final class SystemBusinessFunctionMapper implements RowMapper<SystemBusinessFunction> {
	public SystemBusinessFunction mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemBusinessFunction sbf = new SystemBusinessFunction();

	    sbf.setSystemID(rs.getBigDecimal("system_id"));
	    sbf.setHierarchy_number(rs.getString("hierarchy_number"));
	    sbf.setBfName(rs.getString("business_function_name"));

	    return sbf;
	}
    }

    private static final class SystemMapper implements RowMapper<VASystem> {
	public VASystem mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    VASystem system = new VASystem();
	    system.setSystemID(rs.getBigDecimal("system_id"));
	    system.setAcronym(rs.getString("system_acronym"));
	    system.setName(rs.getString("system_name"));
	    system.setDescription(rs.getString("system_description"));
	    system.setStatus(rs.getString("system_status"));
	    system.setParentOrganization(rs.getString("parent_organization"));
	    system.setPortfolio(rs.getString("it_portfolio"));
	    system.setVasiURL(VASI_DETAIL_URL_1 + rs.getString("element_id") + VASI_DETAIL_URL_2);

	    if (isColumnFound(rs, "system_criticality")) {
		system.setSystemCriticality(rs.getString("system_criticality"));
	    }
	    if (isColumnFound(rs, "system_type")) {
		system.setSystemCriticality(rs.getString("system_type"));
	    }
	    if (isColumnFound(rs, "product_type")) {
		system.setSystemCriticality(rs.getString("product_type"));
	    }
	    if (isColumnFound(rs, "sponsor_organization")) {
		system.setSystemCriticality(rs.getString("sponsor_organization"));
	    }
	    if (isColumnFound(rs, "responsible_org")) {
		system.setSystemCriticality(rs.getString("responsible_org"));
	    }
	    if (isColumnFound(rs, "external_facing")) {
		system.setSystemCriticality(rs.getString("external_facing"));
	    }

	    return system;
	}
    }

    public boolean isVASIDBAccessible() {
	int i = 0;
	try {
	    i = ((Integer) jdbcTemplate.queryForObject("SELECT 1 FROM DUAL", Integer.class)).intValue();
	} catch (Exception e) {
	    System.out.println("Not able to establish connection to VASI Database.");
	    return false;
	}
	if (i == 1) {
	    System.out.println("Successfully connected to VASI Database.");
	    return true;
	}
	return false;
    }

    private static boolean isColumnFound(ResultSet rs, String coulmnName) {
	try {
	    if (rs.findColumn(coulmnName) > -1) {
		return true;
	    }
	} catch (SQLException e) {
	    return false;
	}
	return false;
    }

    private static String ACTIVE_SYSTYEM_LIST_QUERY = "select element_id, system_id, system_acronym, system_name, parent_organization, system_description, lo0.description as system_status, lo1.description as it_portfolio "
	    + "from (select element_id,system_id, system_acronym, system_name, parent_organization,system_description, system_status_pick_list, amo_itam_portfolio "
	    + "from ee.element_attr_c56 system left outer join (select org.organization_id, porg.organization_acronym parent_organization "
	    + "from ee.element_attr_c53 org, ee.element_attr_c53 porg where org.parent_0_organization = porg.organization_id) o on system.organization_id = o.organization_id) master, ee.list_option lo0, ee.list_option lo1 "
	    + "where system_status_pick_list in (715, 716) " + "and lo0.option_id(+) = system_status_pick_list "
	    + "and lo1.option_id(+) = amo_itam_portfolio " + "order by system_id";

    private static String SYSTEM_DETAIL_QUERY = "SELECT system.element_id, system_id, system_acronym, system_name, port.name it_portfolio ,DECODE(external_facing_check,0,'No',1,'Yes', '') external_facing ,CASE WHEN org_level < 2 THEN organization_acronym ELSE nvl(parent_org, organization_acronym) END parent_organization ,organization_name sponsor_organization ,pl_status.description system_status ,pl_oitoo.description responsible_org ,SUBSTR(pl_criticality.description,4) system_criticality ,pl_type.description system_type ,pl_cots.description product_type ,system_description  FROM ee.element_attr_c56 system  LEFT OUTER JOIN (SELECT org.organization_id, org.organization_name, org.organization_acronym, org.org_level, porg.organization_acronym parent_org FROM ee.element_attr_c53 org,  ee.element_attr_c53 porg WHERE org.parent_0_organization = porg.organization_id) o ON system.organization_id = o.organization_id  LEFT OUTER JOIN ee.ELEMENT_ATTR_C1416 port on port.PORTFOLIO_ID = system.EPMO_PORTFOLIO  LEFT OUTER JOIN ee.list_option pl_status on pl_status.option_id = system.SYSTEM_STATUS_PICK_LIST  LEFT OUTER JOIN ee.list_option pl_oitoo on pl_oitoo.option_id = system.oit_office_of_responsibility  LEFT OUTER JOIN ee.list_option pl_criticality on pl_criticality.option_id = system.system_criticality_pick_list  LEFT OUTER JOIN ee.list_option pl_type on pl_type.option_id = system.system_type_pick_list  LEFT OUTER JOIN ee.list_option pl_cots on pl_cots.option_id = system.product_type_pick_list WHERE system_id = ?";

    private static String SYSTEM_BUSINESSFUNCTION_QUERY = "select sbf.system_Id, bf.hierarchy_number, bf.business_function_name "
	    + "from ee.element_Attr_c57 sbf, ee.element_Attr_C46 bf "
	    + "where bf.Business_Function_Id = sbf.Business_Function_Id " + "order by system_id, hierarchy_number";

}
