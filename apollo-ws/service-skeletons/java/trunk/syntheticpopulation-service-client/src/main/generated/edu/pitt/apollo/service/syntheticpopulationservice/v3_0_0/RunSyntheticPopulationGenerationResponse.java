
package edu.pitt.apollo.service.syntheticpopulationservice.v3_0_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.ServiceResult;


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
 *         &lt;element name="serviceResult" type="{http://services-common.apollo.pitt.edu/v3_0_0/}ServiceResult" maxOccurs="unbounded"/>
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
    "serviceResult"
})
@XmlRootElement(name = "runSyntheticPopulationGenerationResponse")
public class RunSyntheticPopulationGenerationResponse {

    @XmlElement(required = true)
    protected List<ServiceResult> serviceResult;

    /**
     * Gets the value of the serviceResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceResult }
     * 
     * 
     */
    public List<ServiceResult> getServiceResult() {
        if (serviceResult == null) {
            serviceResult = new ArrayList<ServiceResult>();
        }
        return this.serviceResult;
    }

}
