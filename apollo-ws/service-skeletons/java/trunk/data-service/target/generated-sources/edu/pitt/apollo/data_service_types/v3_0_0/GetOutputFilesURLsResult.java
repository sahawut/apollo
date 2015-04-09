
package edu.pitt.apollo.data_service_types.v3_0_0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;


/**
 * <p>Java class for GetOutputFilesURLsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetOutputFilesURLsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="methodCallStatus" type="{http://services-common.apollo.pitt.edu/v3_0_0/}MethodCallStatus"/>
 *         &lt;element name="requestIdentification" type="{http://services-common.apollo.pitt.edu/v3_0_0/}RunIdentification"/>
 *         &lt;element name="urlsForRunIdsAndFiles" type="{http://data-service-types.apollo.pitt.edu/v3_0_0/}URLForFileAndRunId" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOutputFilesURLsResult", propOrder = {
    "methodCallStatus",
    "requestIdentification",
    "urlsForRunIdsAndFiles"
})
public class GetOutputFilesURLsResult {

    @XmlElement(required = true)
    protected MethodCallStatus methodCallStatus;
    @XmlElement(required = true)
    protected BigInteger requestIdentification;
    @XmlElement(required = true)
    protected List<URLForFileAndRunId> urlsForRunIdsAndFiles;

    /**
     * Gets the value of the methodCallStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MethodCallStatus }
     *     
     */
    public MethodCallStatus getMethodCallStatus() {
        return methodCallStatus;
    }

    /**
     * Sets the value of the methodCallStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MethodCallStatus }
     *     
     */
    public void setMethodCallStatus(MethodCallStatus value) {
        this.methodCallStatus = value;
    }

    /**
     * Gets the value of the requestIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequestIdentification() {
        return requestIdentification;
    }

    /**
     * Sets the value of the requestIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequestIdentification(BigInteger value) {
        this.requestIdentification = value;
    }

    /**
     * Gets the value of the urlsForRunIdsAndFiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urlsForRunIdsAndFiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrlsForRunIdsAndFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link URLForFileAndRunId }
     * 
     * 
     */
    public List<URLForFileAndRunId> getUrlsForRunIdsAndFiles() {
        if (urlsForRunIdsAndFiles == null) {
            urlsForRunIdsAndFiles = new ArrayList<URLForFileAndRunId>();
        }
        return this.urlsForRunIdsAndFiles;
    }

}
