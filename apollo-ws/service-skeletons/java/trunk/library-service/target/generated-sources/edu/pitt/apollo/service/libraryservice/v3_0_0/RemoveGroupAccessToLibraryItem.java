
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.ModifyGroupOwnershipMessage;


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
 *         &lt;element name="removeGroupAccessToLibraryItemMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}ModifyGroupOwnershipMessage"/>
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
    "removeGroupAccessToLibraryItemMessage"
})
@XmlRootElement(name = "removeGroupAccessToLibraryItem")
public class RemoveGroupAccessToLibraryItem {

    @XmlElement(required = true)
    protected ModifyGroupOwnershipMessage removeGroupAccessToLibraryItemMessage;

    /**
     * Gets the value of the removeGroupAccessToLibraryItemMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ModifyGroupOwnershipMessage }
     *     
     */
    public ModifyGroupOwnershipMessage getRemoveGroupAccessToLibraryItemMessage() {
        return removeGroupAccessToLibraryItemMessage;
    }

    /**
     * Sets the value of the removeGroupAccessToLibraryItemMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyGroupOwnershipMessage }
     *     
     */
    public void setRemoveGroupAccessToLibraryItemMessage(ModifyGroupOwnershipMessage value) {
        this.removeGroupAccessToLibraryItemMessage = value;
    }

}
