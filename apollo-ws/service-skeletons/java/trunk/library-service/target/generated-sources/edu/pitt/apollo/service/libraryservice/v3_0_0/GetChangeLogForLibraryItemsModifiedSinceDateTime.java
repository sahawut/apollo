
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage;


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
 *         &lt;element name="getChangeLogForLibraryItemsModifiedSinceDateTimeMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage"/>
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
    "getChangeLogForLibraryItemsModifiedSinceDateTimeMessage"
})
@XmlRootElement(name = "getChangeLogForLibraryItemsModifiedSinceDateTime")
public class GetChangeLogForLibraryItemsModifiedSinceDateTime {

    @XmlElement(required = true)
    protected GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage getChangeLogForLibraryItemsModifiedSinceDateTimeMessage;

    /**
     * Gets the value of the getChangeLogForLibraryItemsModifiedSinceDateTimeMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage }
     *     
     */
    public GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage getGetChangeLogForLibraryItemsModifiedSinceDateTimeMessage() {
        return getChangeLogForLibraryItemsModifiedSinceDateTimeMessage;
    }

    /**
     * Sets the value of the getChangeLogForLibraryItemsModifiedSinceDateTimeMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage }
     *     
     */
    public void setGetChangeLogForLibraryItemsModifiedSinceDateTimeMessage(GetChangeLogForLibraryItemsModifiedSinceDateTimeMessage value) {
        this.getChangeLogForLibraryItemsModifiedSinceDateTimeMessage = value;
    }

}
