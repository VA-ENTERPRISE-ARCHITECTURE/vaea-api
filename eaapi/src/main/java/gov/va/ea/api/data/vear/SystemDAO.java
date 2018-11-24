package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.VASystem;

@Repository("SystemDAO.Vear")
public class SystemDAO extends BaseDAO {
    private static String VASI_DETAIL_URL_1 = "https://vaausdarapp41.aac.dva.va.gov/ee/request/folder/e/";
    private static String VASI_DETAIL_URL_2 = "/c/56/nt/-1?name-lookup=vasi_home";

    public List<VASystem> getActiveSystems() {
	return jdbcTemplate.query(ACTIVE_SYSTYEM_LIST_QUERY, new SystemMapper());
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
	    system.setItamPortfolio(rs.getString("portfolio"));
	    system.setVasiURL(VASI_DETAIL_URL_1 + rs.getString("element_id") + VASI_DETAIL_URL_2);

	    if (isColumnFound(rs, "system_criticality")) {
		system.setSystemCriticality(rs.getString("system_criticality"));
	    }
	    if (isColumnFound(rs, "system_type")) {
		system.setType(rs.getString("system_type"));
	    }
	    if (isColumnFound(rs, "software_type")) {
		system.setSoftwareType(rs.getString("software_type"));
	    }
	    if (isColumnFound(rs, "organization_name")) {
		system.setSponsorOrganization(rs.getString("organization_name"));
	    }
	    if (isColumnFound(rs, "receiving_organization")) {
		system.setReceivingOrganization(rs.getString("receiving_organization"));
	    }
	    if (isColumnFound(rs, "external_facing")) {
		system.setExternalFacing(rs.getString("external_facing"));
	    }
	    system.setSustainmentCosts(rs.getString("sustainment_costs"));
	    system.setSystemInterfaceable(rs.getString("system_interface_flag"));
	    system.setTransformationStatus(rs.getString("transformation_status"));

	    system.setOsehraCategory(rs.getString("osehra_category"));
	    system.setProductLine(rs.getString("product_line"));
	    system.setHasInterfaces(rs.getString("has_interfaces"));

	    system.setNoDataStoreFlag(rs.getString("no_data_store_flag"));
	    system.setDatastoreStatus(rs.getString("datastore_status"));
	    system.setDisasterRecoveryMethod(rs.getString("disaster_recovery_method"));

	    system.setRecoveryTimeObjective(rs.getString("recovery_time_objective"));
	    system.setRecoveryPointObjective(rs.getString("recovery_point_objective"));
	    system.setStorageSize(rs.getString("storage_size"));

	    system.setSystemAvailability(rs.getString("system_availability"));
	    system.setSensitiveDataType(rs.getString("sensitive_data_type"));
	    system.setIamServiceType(rs.getString("iam_service_type"));

	    system.setSystemAvailability(rs.getString("system_availability"));
	    system.setSensitiveDataType(rs.getString("sensitive_data_type"));
	    system.setIamServiceType(rs.getString("iam_service_type"));

	    system.setMviComplianceStatus(rs.getString("mvi_compliance_status"));
	    system.setVirtualization(rs.getString("virtualization"));
	    system.setMonitoringService(rs.getString("monitoring_service"));

	    system.setEnterpriseBackup(rs.getString("enterprise_backup"));
	    system.setSharedStorage(rs.getString("shared_storage"));
	    system.setBusinessContinuity(rs.getString("business_continuity"));

	    system.setSensitiveData(rs.getString("sensitive_data"));
	    system.setPiiFlag(rs.getString("pii_flag"));
	    system.setPhiFlag(rs.getString("phi_flag"));

	    system.setPrivacyOFCValidationDate(rs.getString("privacy_ofc_validation_dt"));
	    system.setSystemAge(rs.getString("system_age"));
	    system.setActiveNumberOfUsers(rs.getString("active_number_of_users"));

	    system.setProjectedGrowth(rs.getString("projected_growth"));
	    system.setNumberOfAuthentications(rs.getString("number_of_authentications"));
	    system.setVulnerabilityScanningStatus(rs.getString("vulnerability_scanning_status"));

	    system.setTwoFactorAuthentication(rs.getString("two_factor_authentication"));
	    system.setSystemReplacementCost(rs.getString("system_replacement_cost"));
	    system.setSecurityLawComplianceLevel(rs.getString("security_law_compliance_level"));

	    system.setSoftwareHardwareSupport(rs.getString("software_hardware_support"));
	    system.setNumberOfRedundantSystems(rs.getString("number_of_redundant_systems"));
	    system.setLastMajorEnhancementDate(rs.getString("last_major_enhancement_date"));

	    system.setLastSystemFailureDate(rs.getString("last_system_failure_date"));
	    system.setNumberOfRedundantSystems(rs.getString("number_of_redundant_systems"));
	    system.setLastMajorEnhancementDate(rs.getString("last_major_enhancement_date"));

	    system.setOverallScoringCriteria(rs.getString("overall_scoring_criteria"));
	    system.setInitialDeploymentDate(rs.getString("initial_deployment_date"));
	    system.setDecommissionDate(rs.getString("decommission_date"));

	    system.setDecommissionStatus(rs.getString("decommission_status"));
	    system.setLsmAssesmentPoc(rs.getString("lsm_assesment_poc"));

	    system.setTechnicalDetailsComments(rs.getString("comments"));
	    system.setLastLSMStatusUpdate(rs.getString("last_lsm_status_update"));
	    system.setTwoFactorPattern(rs.getString("two_factor_pattern"));

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

    private static String ACTIVE_SYSTYEM_LIST_QUERY = "SELECT e.element_id, e.system_id, e.system_name, e.system_acronym, e.system_description, lo0.description \"system_type\"\r\n"
	    + "    , lo1.description \"software_type\", lo2.description \"system_status\", o.Parent_Org \"parent_organization\"\r\n"
	    + "    , spl0.organization_name, lo3.description \"receiving_organization\"\r\n"
	    + "    , DECODE(e.external_facing_check,0,'False',null,'null','True') \"external_facing\"\r\n"
	    + "    , lo4.description \"system_criticality\", lo5.description \"sustainment_costs\"\r\n"
	    + "    , DECODE(e.system_interface_flag,0,'False',null,'null','True') \"system_interface_flag\"\r\n"
	    + "    , lo6.description \"portfolio\", lo7.description \"transformation_status\", e.osehra_category\r\n"
	    + "    , spl2.NAME \"product_line\", DECODE(e.has_interfaces,0,'False',null,'null','True') \"has_interfaces\"\r\n"
	    + "    , DECODE(e.no_data_store_flag,0,'False',null,'null','True') \"no_data_store_flag\"\r\n"
	    + "    , lo10.description \"datastore_status\"\r\n"
	    + "    , spl4.disaster_recovery_method, spl4.recovery_time_objective, spl4.recovery_point_objective\r\n"
	    + "    , spl4.storage_size, spl4.system_availability, spl4.sensitive_data_type, spl4.iam_service_type\r\n"
	    + "    , lo13.description \"mvi_compliance_status\"\r\n"
	    + "    , DECODE(spl4.virtualization,0,'False',null,'null','True') \"virtualization\"\r\n"
	    + "    , DECODE(spl4.monitoring_service,0,'False',null,'null','True') \"monitoring_service\"\r\n"
	    + "    , DECODE(spl4.enterprise_backup,0,'False',null,'null','True') \"enterprise_backup\"\r\n"
	    + "    , DECODE(spl4.shared_storage,0,'False',null,'null','True') \"shared_storage\"\r\n"
	    + "	   , lo11.description \"business_continuity\", lo12.description \"sensitive_data\"\r\n"
	    + "	   , DECODE(spl4.pii_flag,0,'False',null,'null','True') \"pii_flag\"\r\n"
	    + "    , DECODE(spl4.phi_flag,0,'False',null,'null','True') \"phi_flag\"\r\n"
	    + "    , to_char(spl4.privacy_ofc_validation_dt,'dd-Mon-yyyy') \"privacy_ofc_validation_dt\"\r\n"
	    + "    , spl4.system_age, spl4.active_number_of_users, spl4.projected_growth, spl4.number_of_authentications\r\n"
	    + "    , lo14.description \"vulnerability_scanning_status\", lo15.description \"two_factor_authentication\"\r\n"
	    + "    , lo17.description \"system_replacement_cost\", lo18.description \"security_law_compliance_level\"\r\n"
	    + "    , lo19.description \"software_hardware_support\", spl4.number_of_redundant_systems\r\n"
	    + "    , spl4.last_major_enhancement_date, spl4.last_system_failure_date\r\n"
	    + "    , spl4.overall_scoring_criteria, spl4.initial_deployment_date, spl4.decommission_date\r\n"
	    + "    , spl4.decommission_status, spl4.lsm_assesment_poc, spl4.comments, spl4.last_lsm_status_update\r\n"
	    + "    , lo16.description \"two_factor_pattern\"\r\n"
	    + "    FROM ee.element_attr_c56 e, ee.list_option lo0, ee.list_option lo1, ee.list_option lo2\r\n"
	    + "    , ee.ELEMENT_ATTR_C53 spl0, ee.list_option lo3, ee.list_option lo4, ee.list_option lo5\r\n"
	    + "    , ee.ELEMENT_ATTR_C1416 spl1, ee.list_option lo6, ee.list_option lo7, ee.ELEMENT_ATTR_C2125 spl2\r\n"
	    + "    , ee.ELEMENT_ATTR_C1400 spl3, ee.list_option lo8, ee.list_option lo9, ee.list_option lo10\r\n"
	    + "    , ee.ELEMENT_ATTR_C70 spl4, ee.list_option lo11, ee.list_option lo12, ee.list_option lo13\r\n"
	    + "    , ee.list_option lo14, ee.list_option lo15, ee.list_option lo16, ee.list_option lo17\r\n"
	    + "    , ee.list_option lo18, ee.list_option lo19\r\n"
	    + "    , (Select Org.Organization_Id, Org.Organization_Name, Org.Organization_Acronym, Org.Org_Level, \r\n"
	    + "        Porg.Organization_Acronym Parent_Org From Ee.Element_Attr_C53 Org, Ee.Element_Attr_C53 Porg\r\n"
	    + "       Where Org.Parent_0_Organization = Porg.Organization_Id )o\r\n"
	    + "WHERE  lo0.option_id(+) = e.SYSTEM_TYPE_PICK_LIST AND lo1.option_id(+) = e.PRODUCT_TYPE_PICK_LIST\r\n"
	    + " AND e.SYSTEM_STATUS_PICK_LIST <> 1019 AND lo2.option_id(+) = e.SYSTEM_STATUS_PICK_LIST\r\n"
	    + " AND e.ORGANIZATION_ID = spl0.ORGANIZATION_ID (+) AND lo3.option_id(+) = e.OIT_OFFICE_OF_RESPONSIBILITY\r\n"
	    + " AND lo4.option_id(+) = e.SYSTEM_CRITICALITY_PICK_LIST AND lo5.option_id(+) = e.SUSTAINMENT_COSTS\r\n"
	    + " AND e.EPMO_PORTFOLIO = spl1.PORTFOLIO_ID (+) AND lo6.option_id(+) = e.AMO_ITAM_PORTFOLIO\r\n"
	    + " AND lo7.option_id(+) = e.TRANSFORMATION_STATUS AND e.PRODUCT_LINE = spl2.ELEMENT_ID (+)\r\n"
	    + " AND e.MVI_COMPLIANCE_CD = spl3.ELEMENT_ID (+) AND lo8.option_id(+) = e.SSN\r\n"
	    + " AND lo9.option_id(+) = e.SSN_REMOVAL AND lo10.option_id(+) = e.DATASTORE_STATUS\r\n"
	    + " AND spl4.SYSTEM_ID(+)=e.SYSTEM_ID AND spl4.BUSINESS_CONTINUITY__PICK_LIST = lo11.option_id(+)\r\n"
	    + " AND spl4.SENSITIVE_DATA_PICK_LIST = lo12.option_id(+) AND spl4.MVI_FLAG_PICK_LIST = lo13.option_id(+)\r\n"
	    + " AND spl4.VULNERABILITY_SCANNING_STATUS = lo14.option_id(+) \r\n"
	    + " AND spl4.TWO_FACTOR_AUTHENTICATION = lo15.OPTION_ID(+) AND spl4.TWO_FACTOR_PATTERN = lo16.OPTION_ID(+)\r\n"
	    + " AND spl4.SYSTEM_REPLACEMENT_COST = lo17.OPTION_ID(+)\r\n"
	    + " AND spl4.SECURITY_LAW_COMPLIANCE_LEVEL = lo18.OPTION_ID(+) \r\n"
	    + " AND spl4.SOFTWARE_HARDWARE_SUPPORT = lo19.OPTION_ID(+)\r\n"
	    + " AND e.Organization_Id = O.Organization_Id(+) ORDER BY e.system_id";

}
