
package edu.pitt.apollo.visualizer_service_types.v3_0_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import edu.pitt.apollo.services_common.v3_0_0.Authentication;
import edu.pitt.apollo.services_common.v3_0_0.RunIdentificationAndLabel;
import edu.pitt.apollo.services_common.v3_0_0.SoftwareIdentification;


/**
 * <p>Java class for RunVisualizationMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RunVisualizationMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="visualizerIdentification" type="{http://services-common.apollo.pitt.edu/v3_0_0/}SoftwareIdentification"/>
 *         &lt;element name="authentication" type="{http://services-common.apollo.pitt.edu/v3_0_0/}Authentication"/>
 *         &lt;element name="simulationRunIds" type="{http://services-common.apollo.pitt.edu/v3_0_0/}RunIdentificationAndLabel" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RunVisualizationMessage", propOrder = {
    "visualizerIdentification",
    "authentication",
    "simulationRunIds"
})
public class RunVisualizationMessage {

    @XmlElement(required = true)
    protected SoftwareIdentification visualizerIdentification;
    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected List<RunIdentificationAndLabel> simulationRunIds;

    /**
     * Gets the value of the visualizerIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareIdentification }
     *     
     */
    public SoftwareIdentification getVisualizerIdentification() {
        return visualizerIdentification;
    }

    /**
     * Sets the value of the visualizerIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareIdentification }
     *     
     */
    public void setVisualizerIdentification(SoftwareIdentification value) {
        this.visualizerIdentification = value;
    }

    /**
     * Gets the value of the authentication property.
     * 
     * @return
     *     possible object is
     *     {@link Authentication }
     *     
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    /**
     * Sets the value of the authentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authentication }
     *     
     */
    public void setAuthentication(Authentication value) {
        this.authentication = value;
    }

    /**
     * Gets the value of the simulationRunIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simulationRunIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimulationRunIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RunIdentificationAndLabel }
     * 
     * 
     */
    public List<RunIdentificationAndLabel> getSimulationRunIds() {
        if (simulationRunIds == null) {
            simulationRunIds = new ArrayList<RunIdentificationAndLabel>();
        }
        return this.simulationRunIds;
    }

}
