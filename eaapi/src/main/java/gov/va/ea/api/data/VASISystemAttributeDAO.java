package gov.va.ea.api.data;


import gov.va.ea.api.model.VASISystemAttribute;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VASISystemAttributeDAO extends BaseDAO {
	
	public List<VASISystemAttribute> getVASISystemAttributes() {
		
		return jdbcTemplate.query(ATTRIBUTE_QUERY, new AttributeMapper());
		
	}

	private static final class AttributeMapper implements RowMapper<VASISystemAttribute> {
		public VASISystemAttribute mapRow(ResultSet rs, int rowNumber) throws SQLException {
			VASISystemAttribute attribute = new VASISystemAttribute();
			attribute.setSystemName(rs.getString("system_name"));
			attribute.setSystemAcronym(rs.getString("system_acronym"));
			attribute.setSystemId(rs.getBigDecimal("system_id"));
			attribute.setAccess_url(rs.getString("access_url"));
			return attribute;
		}
	}
	
	private static String ATTRIBUTE_QUERY = "SELECT system_id, system_acronym, system_name, concat(concat('https://vaausdarapp41.aac.dva.va.gov/ee/request/folder/e/', element_id),'/c/56/nt/-1?name-lookup=VASI_HOME') as access_url from ee.element_attr_c56 system where system.SYSTEM_STATUS_PICK_LIST in (715, 716)";
}

