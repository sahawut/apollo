
package edu.pitt.apollo.service.simulatorservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.simulator_service_types.v3_0_0.GetConfigurationFileForSimulationResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configurationFile" type="{http://simulator-service-types.apollo.pitt.edu/v3_0_0/}GetConfigurationFileForSimulationResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "configurationFile"
})
@XmlRootElement(name = "getConfigurationFileForSimulationResponse")
public class GetConfigurationFileForSimulationResponse {

    @XmlElement(required = true)
    protected GetConfigurationFileForSimulationResult configurationFile;

    /**
     * Gets the value of the configurationFile property.
     * 
     * @return
     *     possible object is
     *     {@link GetConfigurationFileForSimulationResult }
     *     
     */
    public GetConfigurationFileForSimulationResult getConfigurationFile() {
        return configurationFile;
    }

    /**
     * Sets the value of the configurationFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetConfigurationFileForSimulationResult }
     *     
     */
    public void setConfigurationFile(GetConfigurationFileForSimulationResult value) {
        this.configurationFile = value;
    }

}
