
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;


/**
 * <p>Java class for GetLibraryItemContainerResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetLibraryItemContainerResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://services-common.apollo.pitt.edu/v3_0_0/}MethodCallStatus"/>
 *         &lt;element name="libraryItemContainer" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}LibraryItemContainer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLibraryItemContainerResult", propOrder = {
    "status",
    "libraryItemContainer"
})
public class GetLibraryItemContainerResult {

    @XmlElement(required = true)
    protected MethodCallStatus status;
    @XmlElement(required = true)
    protected LibraryItemContainer libraryItemContainer;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link MethodCallStatus }
     *     
     */
    public MethodCallStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodCallStatus }
     *     
     */
    public void setStatus(MethodCallStatus value) {
        this.status = value;
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

}
