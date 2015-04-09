
package edu.pitt.apollo.library_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;


/**
 * <p>Java class for GetDiffResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDiffResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://services-common.apollo.pitt.edu/v3_0_0/}MethodCallStatus"/>
 *         &lt;element name="diff" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDiffResult", propOrder = {
    "status",
    "diff"
})
public class GetDiffResult {

    @XmlElement(required = true)
    protected MethodCallStatus status;
    @XmlElement(required = true)
    protected String diff;

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
     * Gets the value of the diff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiff() {
        return diff;
    }

    /**
     * Sets the value of the diff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiff(String value) {
        this.diff = value;
    }

}
