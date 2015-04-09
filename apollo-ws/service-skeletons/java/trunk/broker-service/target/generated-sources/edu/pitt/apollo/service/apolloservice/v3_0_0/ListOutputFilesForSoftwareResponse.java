
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.ListOutputFilesForSoftwareResult;


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
 *         &lt;element name="listOutputFilesForSoftwareResult" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}ListOutputFilesForSoftwareResult"/>
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
    "listOutputFilesForSoftwareResult"
})
@XmlRootElement(name = "listOutputFilesForSoftwareResponse")
public class ListOutputFilesForSoftwareResponse {

    @XmlElement(required = true)
    protected ListOutputFilesForSoftwareResult listOutputFilesForSoftwareResult;

    /**
     * Gets the value of the listOutputFilesForSoftwareResult property.
     * 
     * @return
     *     possible object is
     *     {@link ListOutputFilesForSoftwareResult }
     *     
     */
    public ListOutputFilesForSoftwareResult getListOutputFilesForSoftwareResult() {
        return listOutputFilesForSoftwareResult;
    }

    /**
     * Sets the value of the listOutputFilesForSoftwareResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOutputFilesForSoftwareResult }
     *     
     */
    public void setListOutputFilesForSoftwareResult(ListOutputFilesForSoftwareResult value) {
        this.listOutputFilesForSoftwareResult = value;
    }

}
