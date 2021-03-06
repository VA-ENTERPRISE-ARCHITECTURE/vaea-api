package gov.va.ea.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.va.ea.api.data.BusinessFunctionDAO;
import gov.va.ea.api.data.DataStoreDAO;
import gov.va.ea.api.data.OrganizationDAO;
import gov.va.ea.api.data.ProjectDAO;
import gov.va.ea.api.data.StakeholderDAO;
import gov.va.ea.api.data.SystemDAO;
import gov.va.ea.api.data.SystemOfSystemDAO;
import gov.va.ea.api.data.SystemProjectDAO;
import gov.va.ea.api.data.VASISystemAttributeDAO;
import gov.va.ea.api.model.BusinessFunction;
import gov.va.ea.api.model.DataStore;
import gov.va.ea.api.model.Organization;
import gov.va.ea.api.model.Project;
import gov.va.ea.api.model.SystemBusinessFunction;
import gov.va.ea.api.model.SystemOfSystem;
import gov.va.ea.api.model.SystemProject;
import gov.va.ea.api.model.VASISystemAttribute;
import gov.va.ea.api.model.VASystem;

@RestController
public class ServiceController {
    @Autowired
    SystemDAO sysDao;
    @Autowired
    StakeholderDAO stakeholderDAO;
    @Autowired
    ProjectDAO projectDAO;
    @Autowired
    OrganizationDAO orgDao;
    @Autowired
    SystemOfSystemDAO sosDao;
    @Autowired
    BusinessFunctionDAO bfDao;
    @Autowired
    VASISystemAttributeDAO vasisystemattributeDao;
    @Autowired
    SystemProjectDAO systemProjectDao;
    @Autowired
    DataStoreDAO dataStoreDAO;

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = { "/systems" })
    public List<VASystem> getSystems() {
	return sysDao.getActiveSystems();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/systems/{vasiId}" })
    public VASystem getSystem(@PathVariable String vasiId) {
	VASystem system = this.sysDao.getSystem(vasiId);
	system.setStakeholders(this.stakeholderDAO.getStakeholders(vasiId));
	system.setProjects(this.projectDAO.getProjects(vasiId));
	return system;
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/organizations/{orgId}" })
    public List<Organization> getOrgs(@PathVariable String orgId) {
	return this.orgDao.getOrgs(orgId);
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/systemofsystems/{vasiId}" })
    public List<SystemOfSystem> getSoSs(@PathVariable String vasiId) {
	return this.sosDao.getSoSs(vasiId);
    }

    /*
     * @RequestMapping(method = {
     * org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
     * "/brm/{hierarchyNumber}" }) public List<BusinessFunction>
     * getBFs(@PathVariable String hierarchyNumber) { return
     * this.bfDao.getBfs(hierarchyNumber); }
     */

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/systembusinessfunctions" })
    public List<SystemBusinessFunction> getSystemBusinessFunctions() {
	return sysDao.getSystemBusinessFunctions();
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/businessfunctions" })
    public List<BusinessFunction> getBusinessFunctions() {
	return this.bfDao.getBfs("1054");
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/businessfunctions/{hierarchyNumber}" })
    public List<BusinessFunction> getSubBusinessFunctions(@PathVariable String hierarchyNumber) {
	return this.bfDao.getBfDetails(hierarchyNumber);
    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/vasiSystemAttributes" })
    List<VASISystemAttribute> getVASISystemAttributes() {
	return this.vasisystemattributeDao.getVASISystemAttributes();

    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = {
	    "/systemProjects" })
    List<SystemProject> getSystemProjects() {
	return this.systemProjectDao.getSystemProjects();

    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = { "/projects" })
    List<Project> getProjects() {
	return this.projectDAO.getProjects();

    }

    @RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, value = { "/datastores" })
    List<DataStore> getDataStores() {
	return this.dataStoreDAO.getDataStores();

    }
}
