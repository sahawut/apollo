
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.GetVersionsResult;


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
 *         &lt;element name="getVersionNumbersForLibraryItemResult" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}GetVersionsResult"/>
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
    "getVersionNumbersForLibraryItemResult"
})
@XmlRootElement(name = "getVersionNumbersForLibraryItemResponse")
public class GetVersionNumbersForLibraryItemResponse {

    @XmlElement(required = true)
    protected GetVersionsResult getVersionNumbersForLibraryItemResult;

    /**
     * Gets the value of the getVersionNumbersForLibraryItemResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetVersionsResult }
     *     
     */
    public GetVersionsResult getGetVersionNumbersForLibraryItemResult() {
        return getVersionNumbersForLibraryItemResult;
    }

    /**
     * Sets the value of the getVersionNumbersForLibraryItemResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetVersionsResult }
     *     
     */
    public void setGetVersionNumbersForLibraryItemResult(GetVersionsResult value) {
        this.getVersionNumbersForLibraryItemResult = value;
    }

}
