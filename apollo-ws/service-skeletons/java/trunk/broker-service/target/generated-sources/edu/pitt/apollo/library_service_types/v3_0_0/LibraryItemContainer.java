
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.types.v3_0_0.ApolloIndexableItem;


/**
 * <p>Java class for LibraryItemContainer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LibraryItemContainer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="catalogEntry" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}CatalogEntry"/>
 *         &lt;element name="libraryItem" type="{http://types.apollo.pitt.edu/v3_0_0/}ApolloIndexableItem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LibraryItemContainer", propOrder = {
    "catalogEntry",
    "libraryItem"
})
public class LibraryItemContainer {

    @XmlElement(required = true)
    protected CatalogEntry catalogEntry;
    @XmlElement(required = true)
    protected ApolloIndexableItem libraryItem;

    /**
     * Gets the value of the catalogEntry property.
     * 
     * @return
     *     possible object is
     *     {@link CatalogEntry }
     *     
     */
    public CatalogEntry getCatalogEntry() {
        return catalogEntry;
    }

    /**
     * Sets the value of the catalogEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatalogEntry }
     *     
     */
    public void setCatalogEntry(CatalogEntry value) {
        this.catalogEntry = value;
    }

    /**
     * Gets the value of the libraryItem property.
     * 
     * @return
     *     possible object is
     *     {@link ApolloIndexableItem }
     *     
     */
    public ApolloIndexableItem getLibraryItem() {
        return libraryItem;
    }

    /**
     * Sets the value of the libraryItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApolloIndexableItem }
     *     
     */
    public void setLibraryItem(ApolloIndexableItem value) {
        this.libraryItem = value;
    }

}
