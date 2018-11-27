package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemSecurity {

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String systemDescription;
    private String securityId;
    private String ato;
    private String fismaClassification;
    private String scConfidentiality;
    private String scAvailability;
    private String scIntegrity;
    private String securityDescription;
    private String environment;

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

    public String getSecurityId() {
	return securityId;
    }

    public void setSecurityId(String securityId) {
	this.securityId = securityId;
    }

    public String getAto() {
	return ato;
    }

    public void setAto(String ato) {
	this.ato = ato;
    }

    public String getFismaClassification() {
	return fismaClassification;
    }

    public void setFismaClassification(String fismaClassification) {
	this.fismaClassification = fismaClassification;
    }

    public String getScConfidentiality() {
	return scConfidentiality;
    }

    public void setScConfidentiality(String scConfidentiality) {
	this.scConfidentiality = scConfidentiality;
    }

    public String getScAvailability() {
	return scAvailability;
    }

    public void setScAvailability(String scAvailability) {
	this.scAvailability = scAvailability;
    }

    public String getScIntegrity() {
	return scIntegrity;
    }

    public void setScIntegrity(String scIntegrity) {
	this.scIntegrity = scIntegrity;
    }

    public String getSecurityDescription() {
	return securityDescription;
    }

    public void setSecurityDescription(String securityDescription) {
	this.securityDescription = securityDescription;
    }

    public String getEnvironment() {
	return environment;
    }

    public void setEnvironment(String environment) {
	this.environment = environment;
    }
}
