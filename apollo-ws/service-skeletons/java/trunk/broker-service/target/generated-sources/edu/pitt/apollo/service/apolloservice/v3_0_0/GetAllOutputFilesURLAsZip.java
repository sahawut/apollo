
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.GetAllOutputFilesURLAsZipMessage;


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
 *         &lt;element name="getAllOutputFilesURLAsZipMessage" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}GetAllOutputFilesURLAsZipMessage"/>
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
    "getAllOutputFilesURLAsZipMessage"
})
@XmlRootElement(name = "getAllOutputFilesURLAsZip")
public class GetAllOutputFilesURLAsZip {

    @XmlElement(required = true)
    protected GetAllOutputFilesURLAsZipMessage getAllOutputFilesURLAsZipMessage;

    /**
     * Gets the value of the getAllOutputFilesURLAsZipMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetAllOutputFilesURLAsZipMessage }
     *     
     */
    public GetAllOutputFilesURLAsZipMessage getGetAllOutputFilesURLAsZipMessage() {
        return getAllOutputFilesURLAsZipMessage;
    }

    /**
     * Sets the value of the getAllOutputFilesURLAsZipMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAllOutputFilesURLAsZipMessage }
     *     
     */
    public void setGetAllOutputFilesURLAsZipMessage(GetAllOutputFilesURLAsZipMessage value) {
        this.getAllOutputFilesURLAsZipMessage = value;
    }

}
