
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.Authentication;


/**
 * <p>Java class for AddLibraryItemContainerMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddLibraryItemContainerMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://services-common.apollo.pitt.edu/v3_0_0/}Authentication"/>
 *         &lt;element name="libraryItemContainer" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}LibraryItemContainer"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddLibraryItemContainerMessage", propOrder = {
    "authentication",
    "libraryItemContainer",
    "comment"
})
public class AddLibraryItemContainerMessage {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected LibraryItemContainer libraryItemContainer;
    @XmlElement(required = true)
    protected String comment;

    /**
     * Gets the value of the authentication property.
     * 
     * @return
     *     possible object is
     *     {@link Authentication }
     *     
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authentication }
     *     
     */
    public void setAuthentication(Authentication value) {
        this.authentication = value;
    }

    /**
     * Gets the value of the libraryItemContainer property.
     * 
     * @return
     *     possible object is
     *     {@link LibraryItemContainer }
     *     
     */
    public LibraryItemContainer getLibraryItemContainer() {
        return libraryItemContainer;
    }

    /**
     * Sets the value of the libraryItemContainer property.
     * 
     * @param value
     *     allowed object is
     *     {@link LibraryItemContainer }
     *     
     */
    public void setLibraryItemContainer(LibraryItemContainer value) {
        this.libraryItemContainer = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
