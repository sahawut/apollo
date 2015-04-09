
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.GetOutputFilesURLsResult;


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
 *         &lt;element name="getOutputFilesURLsResult" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}GetOutputFilesURLsResult"/>
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
    "getOutputFilesURLsResult"
})
@XmlRootElement(name = "getOutputFilesURLsResponse")
public class GetOutputFilesURLsResponse {

    @XmlElement(required = true)
    protected GetOutputFilesURLsResult getOutputFilesURLsResult;

    /**
     * Gets the value of the getOutputFilesURLsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetOutputFilesURLsResult }
     *     
     */
    public GetOutputFilesURLsResult getGetOutputFilesURLsResult() {
        return getOutputFilesURLsResult;
    }

    /**
     * Sets the value of the getOutputFilesURLsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOutputFilesURLsResult }
     *     
     */
    public void setGetOutputFilesURLsResult(GetOutputFilesURLsResult value) {
        this.getOutputFilesURLsResult = value;
    }

}
