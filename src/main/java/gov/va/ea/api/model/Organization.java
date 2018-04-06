package gov.va.ea.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Organization
{
  private String orgId;
  private String elementId;
  private String orgName;
  private String acronym;
  private String mailStop;
  private String parentOrg;
  private String rootParentOrg;
  @JsonIgnore
  private int numberOfSystems;
  private int level;
  
  public int getNumberOfSystems()
  {
    return this.numberOfSystems;
  }
  
  public void setNumberOfSystems(int numberOfSystems)
  {
    this.numberOfSystems = numberOfSystems;
  }
  
  public String getRootParentOrg()
  {
    return this.rootParentOrg;
  }
  
  public void setRootParentOrg(String rootParentOrg)
  {
    this.rootParentOrg = rootParentOrg;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public void setLevel(int level)
  {
    this.level = level;
  }
  
  public String getOrgId()
  {
    return this.orgId;
  }
  
  public void setOrgId(String orgId)
  {
    this.orgId = orgId;
  }
  
  public String getOrgName()
  {
    return this.orgName;
  }
  
  public void setOrgName(String orgName)
  {
    this.orgName = orgName;
  }
  
  public String getAcronym()
  {
    return this.acronym;
  }
  
  public void setAcronym(String acronym)
  {
    this.acronym = acronym;
  }
  
  public String getMailStop()
  {
    return this.mailStop;
  }
  
  public void setMailStop(String mailStop)
  {
    this.mailStop = mailStop;
  }
  
  public String getParentOrg()
  {
    return this.parentOrg;
  }
  
  public void setParentOrg(String parentOrg)
  {
    this.parentOrg = parentOrg;
  }
  
  public String getElementId()
  {
    return this.elementId;
  }
  
  public void setElementId(String elementId)
  {
    this.elementId = elementId;
  }
}
