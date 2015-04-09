
package edu.pitt.apollo.service.libraryservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.library_service_types.v3_0_0.GetReleaseVersionMessage;


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
 *         &lt;element name="getLibraryItemReleaseVersionMessage" type="{http://library-service-types.apollo.pitt.edu/v3_0_0/}GetReleaseVersionMessage"/>
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
    "getLibraryItemReleaseVersionMessage"
})
@XmlRootElement(name = "getLibraryItemReleaseVersion")
public class GetLibraryItemReleaseVersion {

    @XmlElement(required = true)
    protected GetReleaseVersionMessage getLibraryItemReleaseVersionMessage;

    /**
     * Gets the value of the getLibraryItemReleaseVersionMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetReleaseVersionMessage }
     *     
     */
    public GetReleaseVersionMessage getGetLibraryItemReleaseVersionMessage() {
        return getLibraryItemReleaseVersionMessage;
    }

    /**
     * Sets the value of the getLibraryItemReleaseVersionMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReleaseVersionMessage }
     *     
     */
    public void setGetLibraryItemReleaseVersionMessage(GetReleaseVersionMessage value) {
        this.getLibraryItemReleaseVersionMessage = value;
    }

}
