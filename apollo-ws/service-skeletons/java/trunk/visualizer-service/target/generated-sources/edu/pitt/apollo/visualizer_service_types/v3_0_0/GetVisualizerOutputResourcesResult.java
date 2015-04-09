
package edu.pitt.apollo.visualizer_service_types.v3_0_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;
import edu.pitt.apollo.services_common.v3_0_0.UrlOutputResource;


/**
 * <p>Java class for GetVisualizerOutputResourcesResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetVisualizerOutputResourcesResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="methodCallStatus" type="{http://services-common.apollo.pitt.edu/v3_0_0/}MethodCallStatus"/>
 *         &lt;element name="urlOutputResources" type="{http://services-common.apollo.pitt.edu/v3_0_0/}UrlOutputResource" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVisualizerOutputResourcesResult", propOrder = {
    "methodCallStatus",
    "urlOutputResources"
})
public class GetVisualizerOutputResourcesResult {

    @XmlElement(required = true)
    protected MethodCallStatus methodCallStatus;
    protected List<UrlOutputResource> urlOutputResources;

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
     * Gets the value of the urlOutputResources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the urlOutputResources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUrlOutputResources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UrlOutputResource }
     * 
     * 
     */
    public List<UrlOutputResource> getUrlOutputResources() {
        if (urlOutputResources == null) {
            urlOutputResources = new ArrayList<UrlOutputResource>();
        }
        return this.urlOutputResources;
    }

}
