package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemComponent;

public class SystemComponentDAO extends BaseDAO {

    public List<SystemComponent> getSystemComponents() {
	return jdbcTemplate.query(system_component_qurey, new SystemComponentMapper());
    }

    private static final class SystemComponentMapper implements RowMapper<SystemComponent> {
	public SystemComponent mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemComponent sysComp = new SystemComponent();
	    sysComp.setSystemId(rs.getBigDecimal("system_id"));
	    sysComp.setSystemAcronym(rs.getString("system_acronym"));
	    sysComp.setSystemName(rs.getString("system_name"));
	    sysComp.setSystemDescription(rs.getString("system_description"));
	    sysComp.setSystemStatus(rs.getString("system_status"));
	    sysComp.setComponentName(rs.getString("component_name"));
	    sysComp.setComponentAcronym(rs.getString("component_acronym"));
	    sysComp.setComponentType(rs.getString("component_type"));
	    sysComp.setComponentDescription(rs.getString("component_description"));
	    return sysComp;
	}
    }

    String system_component_qurey = "select sys.system_id, sys.system_name, sys.system_acronym, sys.system_description\r\n"
	    + "    , lo2.description \"system_status\", sysComp.component_name, sysComp.component_acronym\r\n"
	    + "    , lo.description \"component_type\", sysComp.component_description\r\n"
	    + "from ee.element_attr_c60 sysComp, ee.element_attr_c56 sys, ee.list_option lo, ee.list_option lo2\r\n"
	    + "where sysComp.component_type_pick_list = lo.option_id (+) and sysComp.system_id = sys.system_id\r\n"
	    + "    and sys.system_status_pick_list <> 1019 and lo2.option_id(+) = sys.system_status_pick_list\r\n"
	    + "    order by sys.system_id";

}
