
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChangeLogEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeLogEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="urn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="actionPerformed" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}LibraryActionTypeEnum"/>
 *         &lt;element name="dateOfAction" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeLogEntry", propOrder = {
    "urn",
    "version",
    "actionPerformed",
    "dateOfAction"
})
public class ChangeLogEntry {

    protected int urn;
    protected int version;
    @XmlElement(required = true)
    protected LibraryActionTypeEnum actionPerformed;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateOfAction;

    /**
     * Gets the value of the urn property.
     * 
     */
    public int getUrn() {
        return urn;
    }

    /**
     * Sets the value of the urn property.
     * 
     */
    public void setUrn(int value) {
        this.urn = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the actionPerformed property.
     * 
     * @return
     *     possible object is
     *     {@link LibraryActionTypeEnum }
     *     
     */
    public LibraryActionTypeEnum getActionPerformed() {
        return actionPerformed;
    }

    /**
     * Sets the value of the actionPerformed property.
     * 
     * @param value
     *     allowed object is
     *     {@link LibraryActionTypeEnum }
     *     
     */
    public void setActionPerformed(LibraryActionTypeEnum value) {
        this.actionPerformed = value;
    }

    /**
     * Gets the value of the dateOfAction property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfAction() {
        return dateOfAction;
    }

    /**
     * Sets the value of the dateOfAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfAction(XMLGregorianCalendar value) {
        this.dateOfAction = value;
    }

}
