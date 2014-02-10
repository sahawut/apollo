
package edu.pitt.apollo.types.v2_0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VaccinationEfficacyByTimeSinceDose complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VaccinationEfficacyByTimeSinceDose">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfDosesAdministered" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="timeIntervalLabelDefinitions" type="{http://types.apollo.pitt.edu/v2_0/}TimeAxisCategoryLabels" maxOccurs="unbounded"/>
 *         &lt;element name="vaccinationEfficacyByTimeSinceMostRecentDose" type="{http://types.apollo.pitt.edu/v2_0/}Fraction" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VaccinationEfficacyByTimeSinceDose", propOrder = {
    "numberOfDosesAdministered",
    "timeIntervalLabelDefinitions",
    "vaccinationEfficacyByTimeSinceMostRecentDose"
})
public class VaccinationEfficacyByTimeSinceDose {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numberOfDosesAdministered;
    @XmlElement(required = true)
    protected List<TimeAxisCategoryLabels> timeIntervalLabelDefinitions;
    @XmlElement(type = Double.class)
    protected List<Double> vaccinationEfficacyByTimeSinceMostRecentDose;

    /**
     * Gets the value of the numberOfDosesAdministered property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfDosesAdministered() {
        return numberOfDosesAdministered;
    }

    /**
     * Sets the value of the numberOfDosesAdministered property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfDosesAdministered(BigInteger value) {
        this.numberOfDosesAdministered = value;
    }

    /**
     * Gets the value of the timeIntervalLabelDefinitions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeIntervalLabelDefinitions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeIntervalLabelDefinitions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimeAxisCategoryLabels }
     * 
     * 
     */
    public List<TimeAxisCategoryLabels> getTimeIntervalLabelDefinitions() {
        if (timeIntervalLabelDefinitions == null) {
            timeIntervalLabelDefinitions = new ArrayList<TimeAxisCategoryLabels>();
        }
        return this.timeIntervalLabelDefinitions;
    }

    /**
     * Gets the value of the vaccinationEfficacyByTimeSinceMostRecentDose property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vaccinationEfficacyByTimeSinceMostRecentDose property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVaccinationEfficacyByTimeSinceMostRecentDose().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getVaccinationEfficacyByTimeSinceMostRecentDose() {
        if (vaccinationEfficacyByTimeSinceMostRecentDose == null) {
            vaccinationEfficacyByTimeSinceMostRecentDose = new ArrayList<Double>();
        }
        return this.vaccinationEfficacyByTimeSinceMostRecentDose;
    }

}
