
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.GetLibraryItemURNsResult;


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
 *         &lt;element name="getLibraryItemURNsResult" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}GetLibraryItemURNsResult"/>
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
    "getLibraryItemURNsResult"
})
@XmlRootElement(name = "getLibraryItemURNsResponse")
public class GetLibraryItemURNsResponse {

    @XmlElement(required = true)
    protected GetLibraryItemURNsResult getLibraryItemURNsResult;

    /**
     * Gets the value of the getLibraryItemURNsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetLibraryItemURNsResult }
     *     
     */
    public GetLibraryItemURNsResult getGetLibraryItemURNsResult() {
        return getLibraryItemURNsResult;
    }

    /**
     * Sets the value of the getLibraryItemURNsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLibraryItemURNsResult }
     *     
     */
    public void setGetLibraryItemURNsResult(GetLibraryItemURNsResult value) {
        this.getLibraryItemURNsResult = value;
    }

}
