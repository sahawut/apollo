
package edu.pitt.apollo.service.visualizerservice.v3_0_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.visualizer_service_types.v3_0_0.RunVisualizationMessage;


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
 *         &lt;element name="visualizationRunId" type="{http://services-common.apollo.pitt.edu/v3_0_0/}RunIdentification"/>
 *         &lt;element name="runVisualizationMessage" type="{http://visualizer-service-types.apollo.pitt.edu/v3_0_0/}RunVisualizationMessage"/>
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
    "visualizationRunId",
    "runVisualizationMessage"
})
@XmlRootElement(name = "runVisualization")
public class RunVisualization {

    @XmlElement(required = true)
    protected BigInteger visualizationRunId;
    @XmlElement(required = true)
    protected RunVisualizationMessage runVisualizationMessage;

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

    /**
     * Gets the value of the runVisualizationMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RunVisualizationMessage }
     *     
     */
    public RunVisualizationMessage getRunVisualizationMessage() {
        return runVisualizationMessage;
    }

    /**
     * Sets the value of the runVisualizationMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunVisualizationMessage }
     *     
     */
    public void setRunVisualizationMessage(RunVisualizationMessage value) {
        this.runVisualizationMessage = value;
    }

}
