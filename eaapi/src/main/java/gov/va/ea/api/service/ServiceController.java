package gov.va.ea.api.service;

import gov.va.ea.api.data.BusinessFunctionDAO;
import gov.va.ea.api.data.OrganizationDAO;
import gov.va.ea.api.data.ProjectDAO;
import gov.va.ea.api.data.StakeholderDAO;
import gov.va.ea.api.data.SystemDAO;
import gov.va.ea.api.data.SystemOfSystemDAO;
import gov.va.ea.api.data.VASIAttributeDAO;
import gov.va.ea.api.model.BusinessFunction;
import gov.va.ea.api.model.Organization;
import gov.va.ea.api.model.SystemOfSystem;
import gov.va.ea.api.model.VASIAttribute;
import gov.va.ea.api.model.VASystem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController
{
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
  VASIAttributeDAO attributeDao;
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/systems/{vasiId}"})
  public VASystem getSystem(@PathVariable String vasiId)
  {
    VASystem system = this.sysDao.getSystem(vasiId);
    system.setStakeholders(this.stakeholderDAO.getStakeholders(vasiId));
    system.setProjects(this.projectDAO.getProjects(vasiId));
    return system;
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/organizations/{orgId}"})
  public List<Organization> getOrgs(@PathVariable String orgId)
  {
    return this.orgDao.getOrgs(orgId);
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/systemofsystems/{vasiId}"})
  public List<SystemOfSystem> getSoSs(@PathVariable String vasiId)
  {
    return this.sosDao.getSoSs(vasiId);
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/brm/{hierarchyNumber}"})
  public List<BusinessFunction> getBFs(@PathVariable String hierarchyNumber)
  {
    return this.bfDao.getBfs(hierarchyNumber);
  }
  
  @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET}, value={"/attributes/{vasiId}"})
  List<VASIAttribute> getVASIAttributes(@PathVariable String vasiId)
  {
    return this.attributeDao.getVASIAttributes(vasiId);
  }
}
