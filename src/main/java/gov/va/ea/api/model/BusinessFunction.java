package gov.va.ea.api.model;

public class BusinessFunction
{
  private String elementId;
  private String bfId;
  private String bfName;
  private String parentBf;
  private String hierarchy_number;
  private String org;
  private int level;
  private int numberOfSystems;
  
  public String getElementId()
  {
    return this.elementId;
  }
  
  public void setElementId(String elementId)
  {
    this.elementId = elementId;
  }
  
  public int getNumberOfSystems()
  {
    return this.numberOfSystems;
  }
  
  public void setNumberOfSystems(int numberOfSystems)
  {
    this.numberOfSystems = numberOfSystems;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public void setLevel(int level)
  {
    this.level = level;
  }
  
  public String getBfId()
  {
    return this.bfId;
  }
  
  public void setBfId(String bfId)
  {
    this.bfId = bfId;
  }
  
  public String getBfName()
  {
    return this.bfName;
  }
  
  public void setBfName(String bfName)
  {
    this.bfName = bfName;
  }
  
  public String getParentBf()
  {
    return this.parentBf;
  }
  
  public void setParentBf(String parentBf)
  {
    this.parentBf = parentBf;
  }
  
  public String getHierarchy_number()
  {
    return this.hierarchy_number;
  }
  
  public void setHierarchy_number(String hierarchy_number)
  {
    this.hierarchy_number = hierarchy_number;
  }
  
  public String getOrg()
  {
    return this.org;
  }
  
  public void setOrg(String org)
  {
    this.org = org;
  }
}
