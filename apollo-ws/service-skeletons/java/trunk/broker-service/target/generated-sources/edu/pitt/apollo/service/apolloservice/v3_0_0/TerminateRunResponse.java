
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.TerminteRunResult;


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
 *         &lt;element name="terminateRunResult" type="{http://services-common.apollo.pitt.edu/v3_0_0/}TerminteRunResult"/>
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
    "terminateRunResult"
})
@XmlRootElement(name = "terminateRunResponse")
public class TerminateRunResponse {

    @XmlElement(required = true)
    protected TerminteRunResult terminateRunResult;

    /**
     * Gets the value of the terminateRunResult property.
     * 
     * @return
     *     possible object is
     *     {@link TerminteRunResult }
     *     
     */
    public TerminteRunResult getTerminateRunResult() {
        return terminateRunResult;
    }

    /**
     * Sets the value of the terminateRunResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminteRunResult }
     *     
     */
    public void setTerminateRunResult(TerminteRunResult value) {
        this.terminateRunResult = value;
    }

}
