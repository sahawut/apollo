
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.RunResult;


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
 *         &lt;element name="simulationResult" type="{http://services-common.apollo.pitt.edu/v3_0_0/}RunResult"/>
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
    "simulationResult"
})
@XmlRootElement(name = "runSimulationResponse")
public class RunSimulationResponse {

    @XmlElement(required = true)
    protected RunResult simulationResult;

    /**
     * Gets the value of the simulationResult property.
     * 
     * @return
     *     possible object is
     *     {@link RunResult }
     *     
     */
    public RunResult getSimulationResult() {
        return simulationResult;
    }

    /**
     * Sets the value of the simulationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunResult }
     *     
     */
    public void setSimulationResult(RunResult value) {
        this.simulationResult = value;
    }

}
