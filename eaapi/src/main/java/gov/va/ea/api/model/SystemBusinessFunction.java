package gov.va.ea.api.model;

import java.math.BigDecimal;

public class SystemBusinessFunction {
    private BigDecimal systemID;
    private String bfName;
    private String hierarchy_number;

    public BigDecimal getSystemID() {
	return systemID;
    }

    public void setSystemID(BigDecimal systemID) {
	this.systemID = systemID;
    }

    public String getBfName() {
	return bfName;
    }

    public void setBfName(String bfName) {
	this.bfName = bfName;
    }

    public String getHierarchy_number() {
	return hierarchy_number;
    }

    public void setHierarchy_number(String hierarchy_number) {
	this.hierarchy_number = hierarchy_number;
    }

}