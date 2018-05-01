package gov.va.ea.api.model;

import java.math.BigDecimal;

public class VASISystemAttribute {
	
	private BigDecimal systemId;
	private String systemAcronym;
	private String systemName;
	private String access_url;
	
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
	
	public String getAccess_url() {
		return this.access_url;
	}
	
	public void setAccess_url(String access_url) {
		this.access_url = access_url;
	}
}
 