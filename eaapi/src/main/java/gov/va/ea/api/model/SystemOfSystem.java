package gov.va.ea.api.model;

public class SystemOfSystem
{
  private String childId;
  private String childName;
  private String childAcronym;
  private String parentId;
  private String parentName;
  private String parentAcronym;
  
  public String getChildId()
  {
    return this.childId;
  }
  
  public void setChildId(String childId)
  {
    this.childId = childId;
  }
  
  public String getChildName()
  {
    return this.childName;
  }
  
  public void setChildName(String childName)
  {
    this.childName = childName;
  }
  
  public String getChildAcronym()
  {
    return this.childAcronym;
  }
  
  public void setChildAcronym(String childAcronym)
  {
    this.childAcronym = childAcronym;
  }
  
  public String getParentId()
  {
    return this.parentId;
  }
  
  public void setParentId(String parentId)
  {
    this.parentId = parentId;
  }
  
  public String getParentName()
  {
    return this.parentName;
  }
  
  public void setParentName(String parentName)
  {
    this.parentName = parentName;
  }
  
  public String getParentAcronym()
  {
    return this.parentAcronym;
  }
  
  public void setParentAcronym(String parentAcronym)
  {
    this.parentAcronym = parentAcronym;
  }
}
