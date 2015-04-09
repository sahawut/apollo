
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import edu.pitt.apollo.services_common.v3_0_0.Authentication;


/**
 * <p>Java class for GetDiffMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDiffMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://services-common.apollo.pitt.edu/v3_0_0/}Authentication"/>
 *         &lt;element name="urn" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="version1" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *         &lt;element name="version2" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDiffMessage", propOrder = {
    "authentication",
    "urn",
    "version1",
    "version2"
})
public class GetDiffMessage {

    @XmlElement(required = true)
    protected Authentication authentication;
    protected int urn;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version1;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String version2;

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
     * Gets the value of the version1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion1() {
        return version1;
    }

    /**
     * Sets the value of the version1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion1(String value) {
        this.version1 = value;
    }

    /**
     * Gets the value of the version2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion2() {
        return version2;
    }

    /**
     * Sets the value of the version2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion2(String value) {
        this.version2 = value;
    }

}
