
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.TerminateRunRequest;


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
 *         &lt;element name="terminateRunRequest" type="{http://services-common.apollo.pitt.edu/v3_0_0/}TerminateRunRequest"/>
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
    "terminateRunRequest"
})
@XmlRootElement(name = "terminateRun")
public class TerminateRun {

    @XmlElement(required = true)
    protected TerminateRunRequest terminateRunRequest;

    /**
     * Gets the value of the terminateRunRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TerminateRunRequest }
     *     
     */
    public TerminateRunRequest getTerminateRunRequest() {
        return terminateRunRequest;
    }

    /**
     * Sets the value of the terminateRunRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminateRunRequest }
     *     
     */
    public void setTerminateRunRequest(TerminateRunRequest value) {
        this.terminateRunRequest = value;
    }

}
