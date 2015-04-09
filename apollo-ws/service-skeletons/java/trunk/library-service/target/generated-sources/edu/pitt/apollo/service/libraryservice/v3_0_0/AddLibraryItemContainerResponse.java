
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.AddLibraryItemContainerResult;


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
 *         &lt;element name="addLibraryItemContainerResult" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}AddLibraryItemContainerResult"/>
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
    "addLibraryItemContainerResult"
})
@XmlRootElement(name = "addLibraryItemContainerResponse")
public class AddLibraryItemContainerResponse {

    @XmlElement(required = true)
    protected AddLibraryItemContainerResult addLibraryItemContainerResult;

    /**
     * Gets the value of the addLibraryItemContainerResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddLibraryItemContainerResult }
     *     
     */
    public AddLibraryItemContainerResult getAddLibraryItemContainerResult() {
        return addLibraryItemContainerResult;
    }

    /**
     * Sets the value of the addLibraryItemContainerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddLibraryItemContainerResult }
     *     
     */
    public void setAddLibraryItemContainerResult(AddLibraryItemContainerResult value) {
        this.addLibraryItemContainerResult = value;
    }

}
