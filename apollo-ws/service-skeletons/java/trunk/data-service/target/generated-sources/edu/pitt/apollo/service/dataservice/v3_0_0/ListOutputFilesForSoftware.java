
package edu.pitt.apollo.service.dataservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.data_service_types.v3_0_0.ListOutputFilesForSoftwareMessage;


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
 *         &lt;element name="listOutputFilesForSoftwareMessage" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}ListOutputFilesForSoftwareMessage"/>
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
    "listOutputFilesForSoftwareMessage"
})
@XmlRootElement(name = "listOutputFilesForSoftware")
public class ListOutputFilesForSoftware {

    @XmlElement(required = true)
    protected ListOutputFilesForSoftwareMessage listOutputFilesForSoftwareMessage;

    /**
     * Gets the value of the listOutputFilesForSoftwareMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ListOutputFilesForSoftwareMessage }
     *     
     */
    public ListOutputFilesForSoftwareMessage getListOutputFilesForSoftwareMessage() {
        return listOutputFilesForSoftwareMessage;
    }

    /**
     * Sets the value of the listOutputFilesForSoftwareMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListOutputFilesForSoftwareMessage }
     *     
     */
    public void setListOutputFilesForSoftwareMessage(ListOutputFilesForSoftwareMessage value) {
        this.listOutputFilesForSoftwareMessage = value;
    }

}
