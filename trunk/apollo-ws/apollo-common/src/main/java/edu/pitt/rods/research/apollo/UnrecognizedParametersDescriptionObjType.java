//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.17 at 05:08:40 PM EST 
//


package edu.pitt.rods.research.apollo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnrecognizedParametersDescriptionObjType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnrecognizedParametersDescriptionObjType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Required" type="{http://research.rods.pitt.edu/apollo/}SupportedTypeCollectionType"/>
 *         &lt;element name="Optional" type="{http://research.rods.pitt.edu/apollo/}SupportedTypeCollectionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnrecognizedParametersDescriptionObjType", propOrder = {
    "required",
    "optional"
})
public class UnrecognizedParametersDescriptionObjType {

    @XmlElement(name = "Required", required = true)
    protected SupportedTypeCollectionType required;
    @XmlElement(name = "Optional", required = true)
    protected SupportedTypeCollectionType optional;

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedTypeCollectionType }
     *     
     */
    public SupportedTypeCollectionType getRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedTypeCollectionType }
     *     
     */
    public void setRequired(SupportedTypeCollectionType value) {
        this.required = value;
    }

    /**
     * Gets the value of the optional property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedTypeCollectionType }
     *     
     */
    public SupportedTypeCollectionType getOptional() {
        return optional;
    }

    /**
     * Sets the value of the optional property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedTypeCollectionType }
     *     
     */
    public void setOptional(SupportedTypeCollectionType value) {
        this.optional = value;
    }

}