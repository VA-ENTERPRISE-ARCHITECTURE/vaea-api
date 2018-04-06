package gov.va.ea.api.model;

import java.math.BigDecimal;

public class Project
{
  private BigDecimal projectId;
  private String name;
  private String status;
  private String EPSCode;
  private String responsibleOrg;
  
  public BigDecimal getProjectId()
  {
    return this.projectId;
  }
  
  public void setProjectId(BigDecimal projectId)
  {
    this.projectId = projectId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getEPSCode()
  {
    return this.EPSCode;
  }
  
  public void setEPSCode(String ePSCode)
  {
    this.EPSCode = ePSCode;
  }
  
  public String getResponsibleOrg()
  {
    return this.responsibleOrg;
  }
  
  public void setResponsibleOrg(String responsibleOrg)
  {
    this.responsibleOrg = responsibleOrg;
  }
}
