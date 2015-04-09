
package edu.pitt.apollo.apollo_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import edu.pitt.apollo.services_common.v3_0_0.Authentication;
import edu.pitt.apollo.services_common.v3_0_0.SoftwareIdentification;
import edu.pitt.apollo.types.v3_0_0.InfectiousDiseaseScenario;
import edu.pitt.apollo.types.v3_0_0.SimulatorTimeSpecification;


/**
 * <p>Java class for RunSimulationsMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RunSimulationsMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="simulatorIdentification" type="{http://services-common.apollo.pitt.edu/v3_0_0/}SoftwareIdentification"/>
 *         &lt;element name="authentication" type="{http://services-common.apollo.pitt.edu/v3_0_0/}Authentication"/>
 *         &lt;element name="simulatorTimeSpecification" type="{http://types.apollo.pitt.edu/v3_0_0/}SimulatorTimeSpecification"/>
 *         &lt;element name="baseInfectiousDiseaseScenario" type="{http://types.apollo.pitt.edu/v3_0_0/}InfectiousDiseaseScenario"/>
 *         &lt;element name="batchConfigurationFile" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="md5HashOfbatchConfigurationFile" type="{http://www.w3.org/2001/XMLSchema}token"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RunSimulationsMessage", propOrder = {
    "simulatorIdentification",
    "authentication",
    "simulatorTimeSpecification",
    "baseInfectiousDiseaseScenario",
    "batchConfigurationFile",
    "md5HashOfbatchConfigurationFile"
})
public class RunSimulationsMessage {

    @XmlElement(required = true)
    protected SoftwareIdentification simulatorIdentification;
    @XmlElement(required = true)
    protected Authentication authentication;
    @XmlElement(required = true)
    protected SimulatorTimeSpecification simulatorTimeSpecification;
    @XmlElement(required = true)
    protected InfectiousDiseaseScenario baseInfectiousDiseaseScenario;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String batchConfigurationFile;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String md5HashOfbatchConfigurationFile;

    /**
     * Gets the value of the simulatorIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link SoftwareIdentification }
     *     
     */
    public SoftwareIdentification getSimulatorIdentification() {
        return simulatorIdentification;
    }

    /**
     * Sets the value of the simulatorIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoftwareIdentification }
     *     
     */
    public void setSimulatorIdentification(SoftwareIdentification value) {
        this.simulatorIdentification = value;
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
     * Gets the value of the simulatorTimeSpecification property.
     * 
     * @return
     *     possible object is
     *     {@link SimulatorTimeSpecification }
     *     
     */
    public SimulatorTimeSpecification getSimulatorTimeSpecification() {
        return simulatorTimeSpecification;
    }

    /**
     * Sets the value of the simulatorTimeSpecification property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimulatorTimeSpecification }
     *     
     */
    public void setSimulatorTimeSpecification(SimulatorTimeSpecification value) {
        this.simulatorTimeSpecification = value;
    }

    /**
     * Gets the value of the baseInfectiousDiseaseScenario property.
     * 
     * @return
     *     possible object is
     *     {@link InfectiousDiseaseScenario }
     *     
     */
    public InfectiousDiseaseScenario getBaseInfectiousDiseaseScenario() {
        return baseInfectiousDiseaseScenario;
    }

    /**
     * Sets the value of the baseInfectiousDiseaseScenario property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfectiousDiseaseScenario }
     *     
     */
    public void setBaseInfectiousDiseaseScenario(InfectiousDiseaseScenario value) {
        this.baseInfectiousDiseaseScenario = value;
    }

    /**
     * Gets the value of the batchConfigurationFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchConfigurationFile() {
        return batchConfigurationFile;
    }

    /**
     * Sets the value of the batchConfigurationFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchConfigurationFile(String value) {
        this.batchConfigurationFile = value;
    }

    /**
     * Gets the value of the md5HashOfbatchConfigurationFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMd5HashOfbatchConfigurationFile() {
        return md5HashOfbatchConfigurationFile;
    }

    /**
     * Sets the value of the md5HashOfbatchConfigurationFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMd5HashOfbatchConfigurationFile(String value) {
        this.md5HashOfbatchConfigurationFile = value;
    }

}
