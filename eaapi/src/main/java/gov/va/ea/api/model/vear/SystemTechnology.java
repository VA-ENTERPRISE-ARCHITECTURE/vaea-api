package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemTechnology {

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String systemDescription;
    private String technologyType;
    private String technologyName;

    public BigDecimal getSystemId() {
	return systemId;
    }

    public void setSystemId(BigDecimal systemId) {
	this.systemId = systemId;
    }

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

    public String getSystemDescription() {
	return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
	this.systemDescription = systemDescription;
    }

    public String getTechnologyType() {
	return technologyType;
    }

    public void setTechnologyType(String technologyType) {
	this.technologyType = technologyType;
    }

    public String getTechnologyName() {
	return technologyName;
    }

    public void setTechnologyName(String technologyName) {
	this.technologyName = technologyName;
    }
}
