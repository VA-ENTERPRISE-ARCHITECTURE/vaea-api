package gov.va.ea.api.data.vear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import gov.va.ea.api.data.BaseDAO;
import gov.va.ea.api.model.vear.SystemInvestment;

public class SystemInvestmentDAO extends BaseDAO {

    public List<SystemInvestment> getSystemInvestments() {
	return jdbcTemplate.query(system_investment_qurey, new SystemInvestmentMapper());
    }

    private static final class SystemInvestmentMapper implements RowMapper<SystemInvestment> {
	public SystemInvestment mapRow(ResultSet rs, int rowNumber) throws SQLException {
	    SystemInvestment sysInv = new SystemInvestment();
	    sysInv.setSystemId(rs.getBigDecimal("system_id"));
	    sysInv.setSystemAcronym(rs.getString("system_acronym"));
	    sysInv.setSystemName(rs.getString("system_name"));
	    sysInv.setSystemDescription(rs.getString("system_description"));
	    sysInv.setSystemStatus(rs.getString("system_status"));
	    sysInv.setItInvestmentCode(rs.getString("budgetcodes"));
	    sysInv.setItInvestment(rs.getString("budgetlines"));
	    return sysInv;
	}
    }

    String system_investment_qurey = "select master.system_id, master.system_name, master.system_acronym, lo2.description \"system_status\"\r\n"
	    + "     , master.budgetcodes, master.budgetlines\r\n"
	    + "from ( select syst.system_Id, syst.system_Acronym, syst.system_Name, syst.system_status_pick_list\r\n"
	    + "    , Sf.Budgetlines, Sf.Budgetcodes from Ee.Element_Attr_C56 syst\r\n" + "    Left Outer Join (\r\n"
	    + "    Select system_funding.system_id As system_funding_id \r\n"
	    + "    , Rtrim(Xmlagg(Xmlelement(E, F.Name, ', ').Extract('//text()') Order By F.Name).Getclobval(), ', ') As Budgetlines\r\n"
	    + "    , Rtrim(Xmlagg(Xmlelement(E, F.budget_code, ', ').Extract('//text()') Order By F.budget_code).Getclobval(), ', ') As Budgetcodes\r\n"
	    + "    From Ee.Element_Attr_C62 System_Funding\r\n"
	    + "    Left Outer Join Ee.Element_Attr_C45 F On F.Element_Id = System_Funding.Budget_Code\r\n"
	    + "    Group By System_Id)Sf On syst.system_Id = Sf.System_Funding_Id)master\r\n"
	    + "    , ee.list_option lo2\r\n"
	    + "where master.system_status_pick_list <> 1019 and master.system_status_pick_list = lo2.option_id (+) \r\n"
	    + "    order by master.system_Id";

}
