package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class Stakeholder {
    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String stakeholderName;
    private String stakeholdeType;
    private String stakeholdeTitle;
    private String stakeholdeOrganization;
    private String stakeholdePhone;
    private String stakeholdeEmail;

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

    public String getStakeholderName() {
	return stakeholderName;
    }

    public void setStakeholderName(String stakeholderName) {
	this.stakeholderName = stakeholderName;
    }

    public String getStakeholdeType() {
	return stakeholdeType;
    }

    public void setStakeholdeType(String stakeholdeType) {
	this.stakeholdeType = stakeholdeType;
    }

    public String getStakeholdeTitle() {
	return stakeholdeTitle;
    }

    public void setStakeholdeTitle(String stakeholdeTitle) {
	this.stakeholdeTitle = stakeholdeTitle;
    }

    public String getStakeholdeOrganization() {
	return stakeholdeOrganization;
    }

    public void setStakeholdeOrganization(String stakeholdeOrganization) {
	this.stakeholdeOrganization = stakeholdeOrganization;
    }

    public String getStakeholdePhone() {
	return stakeholdePhone;
    }

    public void setStakeholdePhone(String stakeholdePhone) {
	this.stakeholdePhone = stakeholdePhone;
    }

    public String getStakeholdeEmail() {
	return stakeholdeEmail;
    }

    public void setStakeholdeEmail(String stakeholdeEmail) {
	this.stakeholdeEmail = stakeholdeEmail;
    }

}
