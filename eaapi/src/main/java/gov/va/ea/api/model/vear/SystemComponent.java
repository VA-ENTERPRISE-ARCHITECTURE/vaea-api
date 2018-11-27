package gov.va.ea.api.model.vear;

import java.math.BigDecimal;

public class SystemComponent {

    private BigDecimal systemId;
    private String systemName;
    private String systemAcronym;
    private String systemStatus;
    private String systemDescription;
    private String componentName;
    private String componentAcronym;
    private String componentType;
    private String componentDescription;

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

    public String getComponentName() {
	return componentName;
    }

    public void setComponentName(String componentName) {
	this.componentName = componentName;
    }

    public String getComponentAcronym() {
	return componentAcronym;
    }

    public void setComponentAcronym(String componentAcronym) {
	this.componentAcronym = componentAcronym;
    }

    public String getComponentType() {
	return componentType;
    }

    public void setComponentType(String componentType) {
	this.componentType = componentType;
    }

    public String getComponentDescription() {
	return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
	this.componentDescription = componentDescription;
    }

}
