
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.GetOutputFilesURLAsZipResult;


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
 *         &lt;element name="getOutputFilesURLAsZipResult" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}GetOutputFilesURLAsZipResult"/>
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
    "getOutputFilesURLAsZipResult"
})
@XmlRootElement(name = "getOutputFilesURLAsZipResponse")
public class GetOutputFilesURLAsZipResponse {

    @XmlElement(required = true)
    protected GetOutputFilesURLAsZipResult getOutputFilesURLAsZipResult;

    /**
     * Gets the value of the getOutputFilesURLAsZipResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetOutputFilesURLAsZipResult }
     *     
     */
    public GetOutputFilesURLAsZipResult getGetOutputFilesURLAsZipResult() {
        return getOutputFilesURLAsZipResult;
    }

    /**
     * Sets the value of the getOutputFilesURLAsZipResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOutputFilesURLAsZipResult }
     *     
     */
    public void setGetOutputFilesURLAsZipResult(GetOutputFilesURLAsZipResult value) {
        this.getOutputFilesURLAsZipResult = value;
    }

}
