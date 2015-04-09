
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.GetOutputFilesURLAsZipMessage;


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
 *         &lt;element name="getOutputFilesURLAsZipMessage" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}GetOutputFilesURLAsZipMessage"/>
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
    "getOutputFilesURLAsZipMessage"
})
@XmlRootElement(name = "getOutputFilesURLAsZip")
public class GetOutputFilesURLAsZip {

    @XmlElement(required = true)
    protected GetOutputFilesURLAsZipMessage getOutputFilesURLAsZipMessage;

    /**
     * Gets the value of the getOutputFilesURLAsZipMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetOutputFilesURLAsZipMessage }
     *     
     */
    public GetOutputFilesURLAsZipMessage getGetOutputFilesURLAsZipMessage() {
        return getOutputFilesURLAsZipMessage;
    }

    /**
     * Sets the value of the getOutputFilesURLAsZipMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOutputFilesURLAsZipMessage }
     *     
     */
    public void setGetOutputFilesURLAsZipMessage(GetOutputFilesURLAsZipMessage value) {
        this.getOutputFilesURLAsZipMessage = value;
    }

}
