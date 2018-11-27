package gov.va.ea.api.service.vear;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.va.ea.api.data.vear.BusinessFunctionDAO;
import gov.va.ea.api.data.vear.ProjectDAO;
import gov.va.ea.api.data.vear.StakeholderDAO;
import gov.va.ea.api.data.vear.SystemComponentDAO;
import gov.va.ea.api.data.vear.SystemDAO;
import gov.va.ea.api.data.vear.SystemInvestmentDAO;
import gov.va.ea.api.data.vear.SystemLocationDAO;
import gov.va.ea.api.data.vear.SystemOfSystemDAO;
import gov.va.ea.api.data.vear.SystemSecurityDAO;
import gov.va.ea.api.data.vear.SystemTechnologyDAO;
import gov.va.ea.api.model.vear.BusinessFunction;
import gov.va.ea.api.model.vear.Project;
import gov.va.ea.api.model.vear.Stakeholder;
import gov.va.ea.api.model.vear.SystemComponent;
import gov.va.ea.api.model.vear.SystemInvestment;
import gov.va.ea.api.model.vear.SystemLocation;
import gov.va.ea.api.model.vear.SystemOfSystem;
import gov.va.ea.api.model.vear.SystemSecurity;
import gov.va.ea.api.model.vear.SystemTechnology;
import gov.va.ea.api.model.vear.VASystem;

@RestController
public class VearServiceController {
    @Autowired
    @Qualifier("SystemDAO.Vear")
    SystemDAO sysDao;
    @Autowired
    @Qualifier("StakeholderDAO.Vear")
    StakeholderDAO stakeholderDAO;
    @Autowired
    @Qualifier("ProjectDAO.Vear")
    ProjectDAO projectDAO;
    @Autowired
    @Qualifier("SystemOfSystemDAO.Vear")
    SystemOfSystemDAO sosDao;
    @Autowired
    @Qualifier("BusinessFunctionDAO.Vear")
    BusinessFunctionDAO bfDao;
    @Autowired
    @Qualifier("SystemComponentDAO.Vear")
    SystemComponentDAO systemComponentDAO;
    @Autowired
    @Qualifier("SystemInvestmentDAO.Vear")
    SystemInvestmentDAO systemInvestmentDAO;
    @Autowired
    @Qualifier("SystemLocationDAO.Vear")
    SystemLocationDAO systemLocationDAO;
    @Autowired
    @Qualifier("SystemSecurityDAO.Vear")
    SystemSecurityDAO systemSecurityDAO;
    @Autowired
    @Qualifier("SystemTechnologyDAO.Vear")
    SystemTechnologyDAO systemTechnologyDAO;

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = { "/vear/systems" })
    public List<VASystem> getSystems() {
	return sysDao.getActiveSystems();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemofsystems" })
    public List<SystemOfSystem> getSoSs() {
	return this.sosDao.getSoSs();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systembusinessfunctions" })
    public List<BusinessFunction> getBusinessFunctions() {
	return this.bfDao.getBfs();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemprojects" })
    List<Project> getProjects() {
	return this.projectDAO.getProjects();

    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemstakeholders" })
    public List<Stakeholder> getStakeholders() {
	return stakeholderDAO.getStakeholders();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systeminvestments" })
    public List<SystemInvestment> getSystemInvestments() {
	return systemInvestmentDAO.getSystemInvestments();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemcomponents" })
    public List<SystemComponent> getSystemComponents() {
	return systemComponentDAO.getSystemComponents();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemlocations" })
    public List<SystemLocation> getSystemLocations() {
	return systemLocationDAO.getSystemLocations();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemsecurity" })
    public List<SystemSecurity> getSystemSecurity() {
	return systemSecurityDAO.getSystemSecurity();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vear/systemtechnologies" })
    public List<SystemTechnology> getSystemTechnologies() {
	return systemTechnologyDAO.getSystemTechnologies();
    }
}
