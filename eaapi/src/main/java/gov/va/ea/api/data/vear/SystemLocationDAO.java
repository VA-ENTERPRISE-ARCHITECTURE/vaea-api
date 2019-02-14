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
	    sysLoc.setFacilityId(rs.getString("real_property_IDENTIFIER"));
	    sysLoc.setDataCenterId(rs.getString("FDCCI_IDENTIFIER"));
	    return sysLoc;
	}
    }

    String system_location_qurey = "select master.system_id , master.system_acronym, master.system_name, master.system_description, lo.description \"system_status\"\r\n"
	    + ", master.facility_full_name, master.FDCCI_IDENTIFIER, master.real_property_IDENTIFIER \r\n"
	    + "from  (select syst.system_id, syst.system_acronym, syst.system_name, syst.system_description, syst.system_status_pick_list\r\n"
	    + "    , realProp.facility_full_name, realProp.FDCCI_IDENTIFIER, realProp.real_property_IDENTIFIER\r\n"
	    + "    from ee.element_attr_c56 syst Left Outer Join (select sysRealProp.system_Id\r\n"
	    + "        , rp.facility_full_name, rpS.FDCCI_IDENTIFIER, rp.real_property_IDENTIFIER\r\n"
	    + "        from ee.element_attr_c2105 sysRealProp, ee.element_attr_c2097 rp, ee.element_attr_c2104 rpS\r\n"
	    + "        where rp.element_id(+) = sysRealProp.real_property\r\n"
	    + "        and rpS.REAL_PROPERTY_IDENTIFIER(+) = rp.element_id\r\n"
	    + "        order by system_Id) realProp On realProp.system_Id = Syst.system_Id) master\r\n"
	    + "    , ee.list_option lo\r\n"
	    + "where master.system_status_pick_list = lo.option_id (+) and master.system_status_pick_list <> 1019\r\n"
	    + "    order by master.system_id";

}
