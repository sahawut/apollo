
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.AddLibraryItemContainerMessage;


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
 *         &lt;element name="addLibraryItemContainerMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}AddLibraryItemContainerMessage"/>
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
    "addLibraryItemContainerMessage"
})
@XmlRootElement(name = "addLibraryItemContainer")
public class AddLibraryItemContainer {

    @XmlElement(required = true)
    protected AddLibraryItemContainerMessage addLibraryItemContainerMessage;

    /**
     * Gets the value of the addLibraryItemContainerMessage property.
     * 
     * @return
     *     possible object is
     *     {@link AddLibraryItemContainerMessage }
     *     
     */
    public AddLibraryItemContainerMessage getAddLibraryItemContainerMessage() {
        return addLibraryItemContainerMessage;
    }

    /**
     * Sets the value of the addLibraryItemContainerMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddLibraryItemContainerMessage }
     *     
     */
    public void setAddLibraryItemContainerMessage(AddLibraryItemContainerMessage value) {
        this.addLibraryItemContainerMessage = value;
    }

}
