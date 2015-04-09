
package edu.pitt.apollo.visualizer_service_types.v3_0_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RunVisualizationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RunVisualizationResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="visualizationRunId" type="{http://services-common.apollo.pitt.edu/v3_0_0/}RunIdentification"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RunVisualizationResult", propOrder = {
    "visualizationRunId"
})
public class RunVisualizationResult {

    @XmlElement(required = true)
    protected BigInteger visualizationRunId;

    /**
     * Gets the value of the visualizationRunId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVisualizationRunId() {
        return visualizationRunId;
    }

    /**
     * Sets the value of the visualizationRunId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVisualizationRunId(BigInteger value) {
        this.visualizationRunId = value;
    }

}
