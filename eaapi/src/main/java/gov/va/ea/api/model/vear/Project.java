package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class Project {

    private String projectInvestmentCode;
    private String epmdPortfolio;

    private BigDecimal systemId;
    private String systemAcronym;
    private String systemName;
    private String systemStatus;

    private BigDecimal vipProjectId;
    private String projectName;
    private String projectStatus;
    private String epsCode;

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

    public BigDecimal getVipProjectId() {
	return vipProjectId;
    }

    public void setVipProjectId(BigDecimal vipProjectId) {
	this.vipProjectId = vipProjectId;
    }

    public String getProjectName() {
	return projectName;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public String getProjectStatus() {
	return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
	this.projectStatus = projectStatus;
    }

    public String getEpsCode() {
	return epsCode;
    }

    public void setEpsCode(String epsCode) {
	this.epsCode = epsCode;
    }

    public String getProjectInvestmentCode() {
	return projectInvestmentCode;
    }

    public void setProjectInvestmentCode(String projectInvestmentCode) {
	this.projectInvestmentCode = projectInvestmentCode;
    }

    public String getEpmdPortfolio() {
	return epmdPortfolio;
    }

    public void setEpmdPortfolio(String epmdPortfolio) {
	this.epmdPortfolio = epmdPortfolio;
    }

}
