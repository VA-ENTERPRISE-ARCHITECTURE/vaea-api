package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.Stakeholder;

@Repository("StakeholderDAO.Vear")
public class StakeholderDAO extends BaseDAO {

    public List<Stakeholder> getStakeholders() {
	return jdbcTemplate.query(STAKEHOLDER_QUERY, new StakeholderMapper());
    }

    private static final class StakeholderMapper implements RowMapper<Stakeholder> {
	public Stakeholder mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    Stakeholder stakeholder = new Stakeholder();
	    stakeholder.setSystemId(rs.getBigDecimal("system_id"));
	    stakeholder.setSystemName(rs.getString("system_name"));
	    stakeholder.setSystemAcronym(rs.getString("system_acronym"));
	    stakeholder.setSystemStatus(rs.getString("system_status"));
	    stakeholder.setStakeholderName(rs.getString("stakeholder_name"));
	    stakeholder.setStakeholdeType(rs.getString("stakeholde_type"));
	    stakeholder.setStakeholdeOrganization(rs.getString("organization_name"));
	    stakeholder.setStakeholdeTitle(rs.getString("title"));
	    stakeholder.setStakeholdeEmail(rs.getString("email"));
	    stakeholder.setStakeholdePhone(rs.getString("phone"));
	    return stakeholder;
	}
    }

    private static String STAKEHOLDER_QUERY = "select sys.system_id, sys.system_name, sys.system_acronym, lo2.description \"system_status\",\r\n"
	    + "    stk.last_name || ', ' || stk.first_name \"stakeholder_name\",\r\n"
	    + "    lo.description \"stakeholde_type\", stk.title, org.organization_name, stk.phone\r\n"
	    + "    , stk.email\r\n"
	    + "from ee.element_attr_c56 sys, ee.element_attr_c402 stk, ee.element_attr_c403 sysstk,\r\n"
	    + "    ee.element_attr_c53 org, ee.list_option lo, ee.list_option lo2\r\n"
	    + "where sysstk.system_id = sys.system_id and sysstk.stakeholder_id = stk.stakeholder_id\r\n"
	    + "    and stk.organization_id = org.organization_id (+)\r\n"
	    + "    and sysstk.stakeholder_type_id = lo.option_id (+)\r\n"
	    + "    and sys.system_status_pick_list <> 1019\r\n"
	    + "    and lo2.option_id(+) = sys.system_status_pick_list\r\n"
	    + "    and lo.description not like 'VASI Information Owner%' \r\n" + "order by sys.system_id";
}