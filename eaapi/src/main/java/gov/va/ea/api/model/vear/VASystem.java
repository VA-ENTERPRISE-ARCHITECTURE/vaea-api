package gov.va.ea.api.model.vear;

import java.math.BigDecimal;
import java.util.List;

public class VASystem {

    private BigDecimal systemID;
    private String name;
    private String type;
    private String acronym;
    private String parentOrganization;
    private String sponsorOrganization;
    private String status;
    private String description;

    private String systemCriticality;
    private String externalFacing;

    private String vasiURL;
    private List<Stakeholder> stakeholders;
    private List<Project> projects;

    private String softwareType;
    private String receivingOrganization;
    private String transformationStatus;
    private String itPortfolio;
    private String productLine;
    private String noDataStoreFlag;

    private String datastoreStatus;
    private String disasterRecoveryMethod;
    private String recoveryTimeObjective;
    private String recoveryPointObjective;
    private String storageSize;
    private String systemAvailability;
    private String sensitiveDataType;
    private String iamServiceType;
    private String virtualization;
    private String monitoringService;
    private String enterpriseBackup;
    private String sharedStorage;
    private String businessContinuity;
    private String sensitiveData;
    private String piiFlag;
    private String phiFlag;
    private String privacyOFCValidationDate;
    private String systemAge;
    private String activeNumberOfUsers;
    private String projectedGrowth;
    private String numberOfAuthentications;
    private String vulnerabilityScanningStatus;
    private String twoFactorAuthentication;
    private String systemReplacementCost;
    private String securityLawComplianceLevel;
    private String softwareHardwareSupport;
    private String numberOfRedundantSystems;
    private String lastMajorEnhancementDate;
    private String lastSystemFailureDate;
    private String overallScoringCriteria;
    private String initialDeploymentDate;
    private String decommissionDate;
    private String decommissionStatus;
    private String lsmAssesmentPoc;
    private String technicalDetailsComments;
    private String lastLSMStatusUpdate;
    private String twoFactorPattern;

    public String getSoftwareType() {
	return softwareType;
    }

    public void setSoftwareType(String softwareType) {
	this.softwareType = softwareType;
    }

    public String getReceivingOrganization() {
	return receivingOrganization;
    }

    public void setReceivingOrganization(String receivingOrganization) {
	this.receivingOrganization = receivingOrganization;
    }

    public String getTransformationStatus() {
	return transformationStatus;
    }

    public void setTransformationStatus(String transformationStatus) {
	this.transformationStatus = transformationStatus;
    }

    public String getItPortfolio() {
	return itPortfolio;
    }

    public void setItPortfolio(String itPortfolio) {
	this.itPortfolio = itPortfolio;
    }

    public String getProductLine() {
	return productLine;
    }

    public void setProductLine(String productLine) {
	this.productLine = productLine;
    }

    public String getNoDataStoreFlag() {
	return noDataStoreFlag;
    }

    public void setNoDataStoreFlag(String noDataStoreFlag) {
	this.noDataStoreFlag = noDataStoreFlag;
    }

    public String getDatastoreStatus() {
	return datastoreStatus;
    }

    public void setDatastoreStatus(String datastoreStatus) {
	this.datastoreStatus = datastoreStatus;
    }

    public String getDisasterRecoveryMethod() {
	return disasterRecoveryMethod;
    }

    public void setDisasterRecoveryMethod(String disasterRecoveryMethod) {
	this.disasterRecoveryMethod = disasterRecoveryMethod;
    }

    public String getRecoveryTimeObjective() {
	return recoveryTimeObjective;
    }

    public void setRecoveryTimeObjective(String recoveryTimeObjective) {
	this.recoveryTimeObjective = recoveryTimeObjective;
    }

    public String getRecoveryPointObjective() {
	return recoveryPointObjective;
    }

    public void setRecoveryPointObjective(String recoveryPointObjective) {
	this.recoveryPointObjective = recoveryPointObjective;
    }

    public String getStorageSize() {
	return storageSize;
    }

    public void setStorageSize(String storageSize) {
	this.storageSize = storageSize;
    }

    public String getSystemAvailability() {
	return systemAvailability;
    }

    public void setSystemAvailability(String systemAvailability) {
	this.systemAvailability = systemAvailability;
    }

    public String getSensitiveDataType() {
	return sensitiveDataType;
    }

    public void setSensitiveDataType(String sensitiveDataType) {
	this.sensitiveDataType = sensitiveDataType;
    }

    public String getIamServiceType() {
	return iamServiceType;
    }

    public void setIamServiceType(String iamServiceType) {
	this.iamServiceType = iamServiceType;
    }

    public String getVirtualization() {
	return virtualization;
    }

    public void setVirtualization(String virtualization) {
	this.virtualization = virtualization;
    }

    public String getMonitoringService() {
	return monitoringService;
    }

    public void setMonitoringService(String monitoringService) {
	this.monitoringService = monitoringService;
    }

    public String getEnterpriseBackup() {
	return enterpriseBackup;
    }

    public void setEnterpriseBackup(String enterpriseBackup) {
	this.enterpriseBackup = enterpriseBackup;
    }

    public String getSharedStorage() {
	return sharedStorage;
    }

    public void setSharedStorage(String sharedStorage) {
	this.sharedStorage = sharedStorage;
    }

    public String getBusinessContinuity() {
	return businessContinuity;
    }

    public void setBusinessContinuity(String businessContinuity) {
	this.businessContinuity = businessContinuity;
    }

    public String getSensitiveData() {
	return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
	this.sensitiveData = sensitiveData;
    }

    public String getPiiFlag() {
	return piiFlag;
    }

    public void setPiiFlag(String piiFlag) {
	this.piiFlag = piiFlag;
    }

    public String getPhiFlag() {
	return phiFlag;
    }

    public void setPhiFlag(String phiFlag) {
	this.phiFlag = phiFlag;
    }

    public String getPrivacyOFCValidationDate() {
	return privacyOFCValidationDate;
    }

    public void setPrivacyOFCValidationDate(String privacyOFCValidationDate) {
	this.privacyOFCValidationDate = privacyOFCValidationDate;
    }

    public String getSystemAge() {
	return systemAge;
    }

    public void setSystemAge(String systemAge) {
	this.systemAge = systemAge;
    }

    public String getActiveNumberOfUsers() {
	return activeNumberOfUsers;
    }

    public void setActiveNumberOfUsers(String activeNumberOfUsers) {
	this.activeNumberOfUsers = activeNumberOfUsers;
    }

    public String getProjectedGrowth() {
	return projectedGrowth;
    }

    public void setProjectedGrowth(String projectedGrowth) {
	this.projectedGrowth = projectedGrowth;
    }

    public String getNumberOfAuthentications() {
	return numberOfAuthentications;
    }

    public void setNumberOfAuthentications(String numberOfAuthentications) {
	this.numberOfAuthentications = numberOfAuthentications;
    }

    public String getVulnerabilityScanningStatus() {
	return vulnerabilityScanningStatus;
    }

    public void setVulnerabilityScanningStatus(String vulnerabilityScanningStatus) {
	this.vulnerabilityScanningStatus = vulnerabilityScanningStatus;
    }

    public String getTwoFactorAuthentication() {
	return twoFactorAuthentication;
    }

    public void setTwoFactorAuthentication(String twoFactorAuthentication) {
	this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public String getSystemReplacementCost() {
	return systemReplacementCost;
    }

    public void setSystemReplacementCost(String systemReplacementCost) {
	this.systemReplacementCost = systemReplacementCost;
    }

    public String getSecurityLawComplianceLevel() {
	return securityLawComplianceLevel;
    }

    public void setSecurityLawComplianceLevel(String securityLawComplianceLevel) {
	this.securityLawComplianceLevel = securityLawComplianceLevel;
    }

    public String getSoftwareHardwareSupport() {
	return softwareHardwareSupport;
    }

    public void setSoftwareHardwareSupport(String softwareHardwareSupport) {
	this.softwareHardwareSupport = softwareHardwareSupport;
    }

    public String getNumberOfRedundantSystems() {
	return numberOfRedundantSystems;
    }

    public void setNumberOfRedundantSystems(String numberOfRedundantSystems) {
	this.numberOfRedundantSystems = numberOfRedundantSystems;
    }

    public String getLastMajorEnhancementDate() {
	return lastMajorEnhancementDate;
    }

    public void setLastMajorEnhancementDate(String lastMajorEnhancementDate) {
	this.lastMajorEnhancementDate = lastMajorEnhancementDate;
    }

    public String getLastSystemFailureDate() {
	return lastSystemFailureDate;
    }

    public void setLastSystemFailureDate(String lastSystemFailureDate) {
	this.lastSystemFailureDate = lastSystemFailureDate;
    }

    public String getOverallScoringCriteria() {
	return overallScoringCriteria;
    }

    public void setOverallScoringCriteria(String overallScoringCriteria) {
	this.overallScoringCriteria = overallScoringCriteria;
    }

    public String getInitialDeploymentDate() {
	return initialDeploymentDate;
    }

    public void setInitialDeploymentDate(String initialDeploymentDate) {
	this.initialDeploymentDate = initialDeploymentDate;
    }

    public String getDecommissionDate() {
	return decommissionDate;
    }

    public void setDecommissionDate(String decommissionDate) {
	this.decommissionDate = decommissionDate;
    }

    public String getDecommissionStatus() {
	return decommissionStatus;
    }

    public void setDecommissionStatus(String decommissionStatus) {
	this.decommissionStatus = decommissionStatus;
    }

    public String getLsmAssesmentPoc() {
	return lsmAssesmentPoc;
    }

    public void setLsmAssesmentPoc(String lsmAssesmentPoc) {
	this.lsmAssesmentPoc = lsmAssesmentPoc;
    }

    public String getTechnicalDetailsComments() {
	return technicalDetailsComments;
    }

    public void setTechnicalDetailsComments(String technicalDetailsComments) {
	this.technicalDetailsComments = technicalDetailsComments;
    }

    public String getLastLSMStatusUpdate() {
	return lastLSMStatusUpdate;
    }

    public void setLastLSMStatusUpdate(String lastLSMStatusUpdate) {
	this.lastLSMStatusUpdate = lastLSMStatusUpdate;
    }

    public String getTwoFactorPattern() {
	return twoFactorPattern;
    }

    public void setTwoFactorPattern(String twoFactorPattern) {
	this.twoFactorPattern = twoFactorPattern;
    }

    public BigDecimal getSystemID() {
	return this.systemID;
    }

    public void setSystemID(BigDecimal systemID) {
	this.systemID = systemID;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return this.type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public String getAcronym() {
	return this.acronym;
    }

    public void setAcronym(String acronym) {
	this.acronym = acronym;
    }

    public String getSponsorOrganization() {
	return this.sponsorOrganization;
    }

    public void setSponsorOrganization(String sponsorOrganization) {
	this.sponsorOrganization = sponsorOrganization;
    }

    public String getStatus() {
	return this.status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getSystemCriticality() {
	return this.systemCriticality;
    }

    public void setSystemCriticality(String systemCriticality) {
	this.systemCriticality = systemCriticality;
    }

    public String getExternalFacing() {
	return this.externalFacing;
    }

    public void setExternalFacing(String externalFacing) {
	this.externalFacing = externalFacing;
    }

    public String getParentOrganization() {
	return this.parentOrganization;
    }

    public void setParentOrganization(String parentOrganization) {
	this.parentOrganization = parentOrganization;
    }

    public List<Stakeholder> getStakeholders() {
	return this.stakeholders;
    }

    public void setStakeholders(List<Stakeholder> stakeholders) {
	this.stakeholders = stakeholders;
    }

    public List<Project> getProjects() {
	return this.projects;
    }

    public void setProjects(List<Project> projects) {
	this.projects = projects;
    }

    public String getVasiURL() {
	return vasiURL;
    }

    public void setVasiURL(String vasiURL) {
	this.vasiURL = vasiURL;
    }
}
