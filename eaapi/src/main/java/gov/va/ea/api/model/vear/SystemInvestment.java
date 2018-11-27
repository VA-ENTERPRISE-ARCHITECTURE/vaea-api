package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemInvestment {

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String systemDescription;
    private String itInvestmentCode;
    private String itInvestment;

    public String getItInvestmentCode() {
	return itInvestmentCode;
    }

    public void setItInvestmentCode(String itInvestmentCode) {
	this.itInvestmentCode = itInvestmentCode;
    }

    public String getItInvestment() {
	return itInvestment;
    }

    public void setItInvestment(String itInvestment) {
	this.itInvestment = itInvestment;
    }

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

}
