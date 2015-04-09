
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.GetOutputFilesURLsMessage;


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
 *         &lt;element name="getOutputFilesURLsMessage" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}GetOutputFilesURLsMessage"/>
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
    "getOutputFilesURLsMessage"
})
@XmlRootElement(name = "getOutputFilesURLs")
public class GetOutputFilesURLs {

    @XmlElement(required = true)
    protected GetOutputFilesURLsMessage getOutputFilesURLsMessage;

    /**
     * Gets the value of the getOutputFilesURLsMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetOutputFilesURLsMessage }
     *     
     */
    public GetOutputFilesURLsMessage getGetOutputFilesURLsMessage() {
        return getOutputFilesURLsMessage;
    }

    /**
     * Sets the value of the getOutputFilesURLsMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOutputFilesURLsMessage }
     *     
     */
    public void setGetOutputFilesURLsMessage(GetOutputFilesURLsMessage value) {
        this.getOutputFilesURLsMessage = value;
    }

}
