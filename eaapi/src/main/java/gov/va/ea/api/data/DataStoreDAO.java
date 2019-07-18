package gov.va.ea.api.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.model.DataStore;

@Repository
public class DataStoreDAO extends BaseDAO {

    public List<DataStore> getDataStores() {
	return jdbcTemplate.query(DATA_STORE_QUERY, new DataStoreMapper());
    }

    private static final class DataStoreMapper implements RowMapper<DataStore> {
	public DataStore mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    DataStore dataStore = new DataStore();
	    dataStore.setDataStoreName(rs.getString("data_store_name"));
	    dataStore.setSystemId(rs.getBigDecimal("system_id"));
	    dataStore.setDataStoreAcronym(rs.getString("data_store_acronym"));
	    dataStore.setSystemName(rs.getString("system_name"));
	    dataStore.setPortfolio(rs.getString("portfolio"));
	    dataStore.setProductLine(rs.getString("product_line"));
	    dataStore.setHasSchema(rs.getString("has_schema"));
	    dataStore.setDataStoreDescription(rs.getString("data_store_description"));
	    dataStore.setAdministrationStaffOffice(rs.getString("administration_staff_office"));
	    dataStore.setPersistentPii(rs.getString("persistent_pii"));
	    dataStore.setPersistentPhi(rs.getString("persistent_phi"));
	    dataStore.setPersistentPci(rs.getString("persistent_pci"));
	    dataStore.setSystemOfRecord(rs.getString("system_of_record"));
	    dataStore.setAuthoritativeDataStore(rs.getString("authoritative_data_store"));
	    dataStore.setEncrypted(rs.getString("encrypted"));
	    dataStore.setEncryptedDescription(rs.getString("encrypted_description"));
	    dataStore.setEncryptedInTransit(rs.getString("encrypted_in_transit"));
	    dataStore.setType(rs.getString("type"));
	    dataStore.setSize(rs.getString("size"));
	    dataStore.setNumberOfReplicas(rs.getString("number_of_replicas"));
	    dataStore.setCategory(rs.getString("category"));
	    dataStore.setScope(rs.getString("scope"));
	    dataStore.setDataStoreEncryptionMethod(rs.getString("data_store_encryption_method"));
	    dataStore.setEndNodeEncryptionMethod(rs.getString("end_node_encryption_method"));
	    dataStore.setEncryptedBackupsIndicator(rs.getString("encrypted_backups_indicator"));
	    dataStore.setEncryptedBackupMethod(rs.getString("encrypted_backup_method"));
	    return dataStore;
	}
    }

    private static String DATA_STORE_QUERY = "SELECT coalesce(ds.technical_name,ds.business_name) \"data_store_name\", sys_agg.system_id, sys_agg.system_name,\r\n"
	    + "    ds.acronym \"data_store_acronym\", sys_agg.port_name \"portfolio\", sys_agg.pl_name \"product_line\",\r\n"
	    + "    DECODE( (SELECT COUNT(*) FROM db_schema WHERE data_store = ds.data_store_id ),0,'No','Yes') \"has_schema\",\r\n"
	    + "    ds.description \"data_store_description\", sys_agg.organization_acronym \"administration_staff_office\",\r\n"
	    + "    sys_agg.admin_id, DECODE(pii,1,'Yes','No') \"persistent_pii\", DECODE(phi,1,'Yes','No') \"persistent_phi\",\r\n"
	    + "    DECODE(pci,1,'Yes','No') \"persistent_pci\", system_of_record \"system_of_record\", \r\n"
	    + "    aut_dat_sto.description \"authoritative_data_store\", DECODE(data_store_incrypted_ind,1,'Yes','No') \"encrypted\",\r\n"
	    + "    data_store_incrypt_description \"encrypted_description\", \r\n"
	    + "    DECODE(entrypted_in_transit_ind,1,'Yes','No') \"encrypted_in_transit\", dstype.description \"type\",\r\n"
	    + "    dssize.description \"size\", ds.number_of_replicas \"number_of_replicas\", dscategory.description \"category\",\r\n"
	    + "    dsscope.description \"scope\", dsincmethod.description \"data_store_encryption_method\", dsencmethod.description \"end_node_encryption_method\",\r\n"
	    + "    dsentbackid.description \"encrypted_backups_indicator\", dsbackmethod.description \"encrypted_backup_method\"\r\n"
	    + "FROM data_store ds LEFT JOIN ( SELECT ds_system.data_store, o2.element_id admin_id, o2.organization_acronym,\r\n"
	    + "    p.port_name, p.pl_name, ssys.system_id, ssys.system_name FROM ee.element_attr_c419 ds_system\r\n"
	    + "    LEFT JOIN ee.element_attr_c56 ssys ON ssys.system_id = ds_system.system LEFT OUTER JOIN ( SELECT\r\n"
	    + "    pl.element_id, port.name port_name, pl.name pl_name FROM ee.element_attr_c1416 port, ee.element_attr_c2125 pl\r\n"
	    + "    WHERE port.element_id = pl.portfolio ) p ON ssys.product_line = p.element_id\r\n"
	    + "    LEFT JOIN vasi_organization o ON ssys.organization_id = o.organization_id\r\n"
	    + "    LEFT JOIN vasi_organization o2 ON o.parent_0_organization = o2.organization_id\r\n"
	    + "    GROUP BY ds_system.data_store, o2.element_id, o2.organization_acronym, p.port_name, p.pl_name,\r\n"
	    + "    ssys.system_id, ssys.system_name) sys_agg ON sys_agg.data_store = ds.data_store_id\r\n"
	    + "    LEFT JOIN ee.list_option dstype ON ds.workload_type = dstype.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dssize ON ds.database_size = dssize.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dscategory ON ds.category = dscategory.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dsscope ON ds.scope = dsscope.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dsincmethod ON ds.data_store_incrypt_method = dsincmethod.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dsencmethod ON ds.end_node_entrypt_method = dsencmethod.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dsentbackid ON ds.entrypted_backups_ind = dsentbackid.option_id\r\n"
	    + "    LEFT JOIN ee.list_option dsbackmethod ON ds.entrypted_backups_method = dsbackmethod.option_id\r\n"
	    + "    LEFT JOIN ee.list_option aut_dat_sto ON ds.authoritative_data_store = aut_dat_sto.option_id\r\n"
	    + " ORDER BY sys_agg.system_id, upper(coalesce(ds.technical_name,ds.business_name) )";

}
