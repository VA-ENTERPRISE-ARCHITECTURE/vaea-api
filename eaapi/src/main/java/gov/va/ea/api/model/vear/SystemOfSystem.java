package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemOfSystem {

    private String parentSystemId;
    private String parentSystemName;
    private String parentSystemAcronym;

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;

    private String parentSystemStatus;

    public String getSystemName() {
	return systemName;
    }

    public void setSystemName(String systemName) {
	this.systemName = systemName;
    }

    public String getSystemAcronym() {
	return systemAcronym;
    }

    public void setSystemAcronym(String systemAcronym) {
	this.systemAcronym = systemAcronym;
    }

    public String getSystemStatus() {
	return systemStatus;
    }

    public void setSystemStatus(String systemStatus) {
	this.systemStatus = systemStatus;
    }

    public String getParentSystemId() {
	return parentSystemId;
    }

    public String getParentSystemStatus() {
	return parentSystemStatus;
    }

    public void setParentSystemStatus(String parentSystemStatus) {
	this.parentSystemStatus = parentSystemStatus;
    }

    public void setParentSystemId(String parentSystemId) {
	this.parentSystemId = parentSystemId;
    }

    public String getParentSystemName() {
	return parentSystemName;
    }

    public void setParentSystemName(String parentSystemName) {
	this.parentSystemName = parentSystemName;
    }

    public String getParentSystemAcronym() {
	return parentSystemAcronym;
    }

    public void setParentSystemAcronym(String parentSystemAcronym) {
	this.parentSystemAcronym = parentSystemAcronym;
    }

    public BigDecimal getSystemId() {
	return systemId;
    }

    public void setSystemId(BigDecimal systemId) {
	this.systemId = systemId;
    }

}
