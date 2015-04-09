
package edu.pitt.apollo.service.apolloservice.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.visualizer_service_types.v3_0_0.GetVisualizerOutputResourcesResult;


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
 *         &lt;element name="getVisualizerOutputResourcesResult" type="{http://visualizer-service-types.apollo.pitt.edu/v3_0_0/}GetVisualizerOutputResourcesResult"/>
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
    "getVisualizerOutputResourcesResult"
})
@XmlRootElement(name = "getVisualizerOutputResourcesResponse")
public class GetVisualizerOutputResourcesResponse {

    @XmlElement(required = true)
    protected GetVisualizerOutputResourcesResult getVisualizerOutputResourcesResult;

    /**
     * Gets the value of the getVisualizerOutputResourcesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetVisualizerOutputResourcesResult }
     *     
     */
    public GetVisualizerOutputResourcesResult getGetVisualizerOutputResourcesResult() {
        return getVisualizerOutputResourcesResult;
    }

    /**
     * Sets the value of the getVisualizerOutputResourcesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetVisualizerOutputResourcesResult }
     *     
     */
    public void setGetVisualizerOutputResourcesResult(GetVisualizerOutputResourcesResult value) {
        this.getVisualizerOutputResourcesResult = value;
    }

}
