
package edu.pitt.apollo.service.apolloservice.v2_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.types.v2_0.RunVisualizationMessage;


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
 *         &lt;element name="runVisualizationMessage" type="{http://types.apollo.pitt.edu/v2_0/}RunVisualizationMessage"/>
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
    "runVisualizationMessage"
})
@XmlRootElement(name = "runVisualization")
public class RunVisualization {

    @XmlElement(required = true)
    protected RunVisualizationMessage runVisualizationMessage;

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