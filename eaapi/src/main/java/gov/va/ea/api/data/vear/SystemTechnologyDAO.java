package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemTechnology;

public class SystemTechnologyDAO extends BaseDAO {

    public List<SystemTechnology> getSystemTechnologies() {
	return jdbcTemplate.query(system_technology_query, new SystemTechnologyMapper());
    }

    private static final class SystemTechnologyMapper implements RowMapper<SystemTechnology> {
	public SystemTechnology mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemTechnology sysTech = new SystemTechnology();
	    sysTech.setSystemId(rs.getBigDecimal("system_id"));
	    sysTech.setSystemAcronym(rs.getString("system_acronym"));
	    sysTech.setSystemName(rs.getString("system_name"));
	    sysTech.setSystemDescription(rs.getString("system_description"));
	    sysTech.setSystemStatus(rs.getString("system_status"));
	    sysTech.setTechnologyType(rs.getString("technology_type"));
	    sysTech.setTechnologyName(rs.getString("name"));
	    return sysTech;
	}
    }

    String system_technology_query = "select sys.system_id, sys.system_acronym, sys.system_name, sys.system_description\r\n"
	    + ", lo2.description \"system_status\", lo1.description \"technology_type\", technology.name\r\n"
	    + "from ee.element_attr_c56 sys, ee.element_attr_c404 technology\r\n"
	    + ", ee.element_attr_c405 system_technology, ee.list_option lo1, ee.list_option lo2\r\n"
	    + "where sys.system_id = system_technology.system_id \r\n"
	    + "and technology.technology_id =  system_technology.technology_id\r\n"
	    + "and lo1.option_id(+) = technology.technology_type and sys.system_status_pick_list <> 1019\r\n"
	    + "and sys.system_status_pick_list = lo2.option_id(+)\r\n" + "order by sys.system_id";

}
