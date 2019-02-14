package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemLocation {

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String systemDescription;
    private String facilityFullName;
    private String facilityId;
    private String dataCenterId;

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

    public String getFacilityFullName() {
	return facilityFullName;
    }

    public void setFacilityFullName(String facilityFullName) {
	this.facilityFullName = facilityFullName;
    }

    public String getFacilityId() {
	return facilityId;
    }

    public void setFacilityId(String facilityId) {
	this.facilityId = facilityId;
    }

    public String getDataCenterId() {
	return dataCenterId;
    }

    public void setDataCenterId(String dataCenterId) {
	this.dataCenterId = dataCenterId;
    }
}
