package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemLocation;

@Repository("SystemLocationDAO.Vear")
public class SystemLocationDAO extends BaseDAO {

    public List<SystemLocation> getSystemLocations() {
	return jdbcTemplate.query(system_location_qurey, new SystemLocationMapper());
    }

    private static final class SystemLocationMapper implements RowMapper<SystemLocation> {
	public SystemLocation mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemLocation sysLoc = new SystemLocation();
	    sysLoc.setSystemId(rs.getBigDecimal("system_id"));
	    sysLoc.setSystemAcronym(rs.getString("system_acronym"));
	    sysLoc.setSystemName(rs.getString("system_name"));
	    sysLoc.setSystemDescription(rs.getString("system_description"));
	    sysLoc.setSystemStatus(rs.getString("system_status"));
	    sysLoc.setFacilityFullName(rs.getString("facility_full_name"));
	    return sysLoc;
	}
    }

    String system_location_qurey = "select master.system_id, master.system_acronym, master.system_name, master.system_description\r\n"
	    + ", lo.description \"system_status\", master.facility_full_name from  \r\n"
	    + "    (select syst.system_id, syst.system_acronym, syst.system_name, syst.system_description\r\n"
	    + "    , syst.system_status_pick_list, realProp.facility_full_name \r\n"
	    + "    from ee.element_attr_c56 syst left outer join \r\n"
	    + "        (select sysRealProp.system_Id, rp.facility_full_name from ee.element_attr_c2105 sysRealProp\r\n"
	    + "         Left Outer Join ee.element_attr_c2097 rp On rp.element_id = sysRealProp.real_property\r\n"
	    + "        order by system_Id) realProp On realProp.system_Id = Syst.system_Id) master\r\n"
	    + "    , ee.list_option lo\r\n"
	    + "where master.system_status_pick_list = lo.option_id (+) and master.system_status_pick_list <> 1019\r\n"
	    + "    order by master.system_id";

}
