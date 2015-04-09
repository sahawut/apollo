
package edu.pitt.apollo.data_service_types.v3_0_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.Authentication;
import edu.pitt.apollo.services_common.v3_0_0.SoftwareIdentification;


/**
 * <p>Java class for GetOutputFilesURLAsZipMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetOutputFilesURLAsZipMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authentication" type="{http://services-common.apollo.pitt.edu/v3_0_0/}Authentication"/>
 *         &lt;element name="softwareIdentification" type="{http://services-common.apollo.pitt.edu/v3_0_0/}SoftwareIdentification"/>
 *         &lt;element name="runIdsAndFiles" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}RunIdAndFiles" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOutputFilesURLAsZipMessage", propOrder = {
    "authentication",
    "softwareIdentification",
    "runIdsAndFiles"
})
public class GetOutputFilesURLAsZipMessage {

    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected SoftwareIdentification softwareIdentification;
    @XmlElement(required = true)
    protected List<RunIdAndFiles> runIdsAndFiles;

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
     * Gets the value of the softwareIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareIdentification }
     *     
     */
    public SoftwareIdentification getSoftwareIdentification() {
        return softwareIdentification;
    }

    /**
     * Sets the value of the softwareIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareIdentification }
     *     
     */
    public void setSoftwareIdentification(SoftwareIdentification value) {
        this.softwareIdentification = value;
    }

    /**
     * Gets the value of the runIdsAndFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the runIdsAndFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRunIdsAndFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RunIdAndFiles }
     * 
     * 
     */
    public List<RunIdAndFiles> getRunIdsAndFiles() {
        if (runIdsAndFiles == null) {
            runIdsAndFiles = new ArrayList<RunIdAndFiles>();
        }
        return this.runIdsAndFiles;
    }

}
