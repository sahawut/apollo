
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.SetLibraryItemAsNotReleasedMessage;


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
 *         &lt;element name="setLibraryItemAsNotReleasedMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}SetLibraryItemAsNotReleasedMessage"/>
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
    "setLibraryItemAsNotReleasedMessage"
})
@XmlRootElement(name = "setLibraryItemAsNotReleased")
public class SetLibraryItemAsNotReleased {

    @XmlElement(required = true)
    protected SetLibraryItemAsNotReleasedMessage setLibraryItemAsNotReleasedMessage;

    /**
     * Gets the value of the setLibraryItemAsNotReleasedMessage property.
     * 
     * @return
     *     possible object is
     *     {@link SetLibraryItemAsNotReleasedMessage }
     *     
     */
    public SetLibraryItemAsNotReleasedMessage getSetLibraryItemAsNotReleasedMessage() {
        return setLibraryItemAsNotReleasedMessage;
    }

    /**
     * Sets the value of the setLibraryItemAsNotReleasedMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SetLibraryItemAsNotReleasedMessage }
     *     
     */
    public void setSetLibraryItemAsNotReleasedMessage(SetLibraryItemAsNotReleasedMessage value) {
        this.setLibraryItemAsNotReleasedMessage = value;
    }

}
