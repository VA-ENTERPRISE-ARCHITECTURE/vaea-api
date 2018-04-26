package gov.va.ea.api.data;


import gov.va.ea.api.model.VASIAttribute;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VASIAttributeDAO extends BaseDAO {
	
	public List<VASIAttribute> getVASIAttributes(String vasiId) {
		
		return jdbcTemplate.query(ATTRIBUTE_QUERY, new Object[] { new BigDecimal(vasiId) }, new AttributeMapper());
		
	}

	private static final class AttributeMapper implements RowMapper<VASIAttribute> {
		public VASIAttribute mapRow(ResultSet rs, int rowNumber) throws SQLException {
			VASIAttribute attribute = new VASIAttribute();
			attribute.setSystemName(rs.getString("system_name"));
			attribute.setSystemAcronym(rs.getString("system_acronym"));
			attribute.setSystemId(rs.getBigDecimal("system_id"));
			return attribute;
		}
	}
	
	private static String ATTRIBUTE_QUERY = "SELECT system_id, system_acronym, system_name, concat(concat('https://vaausdarapp41.aac.dva.va.gov/ee/request/folder/e/', element_id),'/c/56/nt/-1?name-lookup=VASI_HOME') as access_url from ee.element_attr_c56 system where system.SYSTEM_STATUS_PICK_LIST in (715, 716)";
}

