
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.GetLibraryItemContainerResult;


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
 *         &lt;element name="getLibraryItemContainerResult" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}GetLibraryItemContainerResult"/>
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
    "getLibraryItemContainerResult"
})
@XmlRootElement(name = "getLibraryItemContainerResponse")
public class GetLibraryItemContainerResponse {

    @XmlElement(required = true)
    protected GetLibraryItemContainerResult getLibraryItemContainerResult;

    /**
     * Gets the value of the getLibraryItemContainerResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetLibraryItemContainerResult }
     *     
     */
    public GetLibraryItemContainerResult getGetLibraryItemContainerResult() {
        return getLibraryItemContainerResult;
    }

    /**
     * Sets the value of the getLibraryItemContainerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetLibraryItemContainerResult }
     *     
     */
    public void setGetLibraryItemContainerResult(GetLibraryItemContainerResult value) {
        this.getLibraryItemContainerResult = value;
    }

}
