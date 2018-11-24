package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessFunction {
    private String hierarchyNumber;

    private BigDecimal systemId;
    private String systemAcronym;
    private String systemName;
    private String systemStatus;

    private String businessFunction;
    private String businessDescription;
    private String organizationName;

    public String getHierarchyNumber() {
	return hierarchyNumber;
    }

    public void setHierarchyNumber(String hierarchyNumber) {
	this.hierarchyNumber = hierarchyNumber;
    }

    public BigDecimal getSystemId() {
	return systemId;
    }

    public void setSystemId(BigDecimal systemId) {
	this.systemId = systemId;
    }

    public String getSystemAcronym() {
	return systemAcronym;
    }

    public void setSystemAcronym(String systemAcronym) {
	this.systemAcronym = systemAcronym;
    }

    public String getSystemName() {
	return systemName;
    }

    public void setSystemName(String systemName) {
	this.systemName = systemName;
    }

    public String getSystemStatus() {
	return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
	this.systemStatus = systemStatus;
    }

    public String getBusinessFunction() {
	return businessFunction;
    }

    public void setBusinessFunction(String businessFunction) {
	this.businessFunction = businessFunction;
    }

    public String getBusinessDescription() {
	return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
	this.businessDescription = businessDescription;
    }

    public String getOrganizationName() {
	return organizationName;
    }

    public void setOrganizationName(String organizationName) {
	this.organizationName = organizationName;
    }

}
