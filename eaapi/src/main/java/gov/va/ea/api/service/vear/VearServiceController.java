package gov.va.ea.api.service.vear;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.va.ea.api.data.vear.BusinessFunctionDAO;
import gov.va.ea.api.data.vear.ProjectDAO;
import gov.va.ea.api.data.vear.StakeholderDAO;
import gov.va.ea.api.data.vear.SystemDAO;
import gov.va.ea.api.data.vear.SystemOfSystemDAO;
import gov.va.ea.api.model.vear.BusinessFunction;
import gov.va.ea.api.model.vear.Project;
import gov.va.ea.api.model.vear.Stakeholder;
import gov.va.ea.api.model.vear.SystemOfSystem;
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
}
