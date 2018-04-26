package gov.va.ea.api.model;

import java.math.BigDecimal;

public class VASIAttribute {
	
	private BigDecimal systemId;
	private String systemAcronym;
	private String systemName;
	
	public BigDecimal getSystemId() {
		return this.systemId;
	}
	public void setSystemId(BigDecimal systemId) {
		this.systemId = systemId;
	}
	public String getSystemAcronym() {
		return this.systemAcronym;
	}
	public void setSystemAcronym(String systemAcronym) {
		this.systemAcronym = systemAcronym;
	}
	public String getSystemName() {
		return this.systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	

}
