//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.2-hudson-jaxb-ri-2.2-63- 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.17 at 05:08:40 PM EST 
//


package edu.pitt.rods.research.apollo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AgentBasedModelRunRequestObjType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AgentBasedModelRunRequestObjType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ModelID" type="{http://research.rods.pitt.edu/apollo/}ModelID"/>
 *         &lt;element name="Parameters">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="registered">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;extension base="{http://research.rods.pitt.edu/apollo/}BaseModelParamObjType">
 *                           &lt;sequence>
 *                             &lt;element name="SchoolClosureControlMeasureInfo">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="PolicyType" type="{http://research.rods.pitt.edu/apollo/}SchoolClosurePolicyEnum"/>
 *                                       &lt;element name="Threshold">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                             &lt;minInclusive value="0"/>
 *                                             &lt;maxInclusive value="100"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="ClosurePeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                       &lt;element name="ClosureDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="VaccinationScheduleControlMeasureInfo">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="VaccineTemporalDistribution">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="VaccinationPrioritizationScheme" type="{http://research.rods.pitt.edu/apollo/}VaccinationPrioritizationSchemeEnum"/>
 *                                       &lt;element name="Compliance">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                             &lt;minInclusive value="0"/>
 *                                             &lt;maxInclusive value="100"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="NumberOfRuns" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="RandomSeed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="PercentImmune">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *                                   &lt;minInclusive value="0"/>
 *                                   &lt;maxInclusive value="100"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/extension>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Unregistered" type="{http://research.rods.pitt.edu/apollo/}SupportedTypeCollectionType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AgentBasedModelRunRequestObjType", propOrder = {
    "modelID",
    "parameters"
})
public class AgentBasedModelRunRequestObjType {

    @XmlElement(name = "ModelID", required = true)
    protected ModelID modelID;
    @XmlElement(name = "Parameters", required = true)
    protected AgentBasedModelRunRequestObjType.Parameters parameters;

    /**
     * Gets the value of the modelID property.
     * 
     * @return
     *     possible object is
     *     {@link ModelID }
     *     
     */
    public ModelID getModelID() {
        return modelID;
    }

    /**
     * Sets the value of the modelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModelID }
     *     
     */
    public void setModelID(ModelID value) {
        this.modelID = value;
    }

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link AgentBasedModelRunRequestObjType.Parameters }
     *     
     */
    public AgentBasedModelRunRequestObjType.Parameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgentBasedModelRunRequestObjType.Parameters }
     *     
     */
    public void setParameters(AgentBasedModelRunRequestObjType.Parameters value) {
        this.parameters = value;
    }


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
     *         &lt;element name="registered">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;extension base="{http://research.rods.pitt.edu/apollo/}BaseModelParamObjType">
     *                 &lt;sequence>
     *                   &lt;element name="SchoolClosureControlMeasureInfo">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="PolicyType" type="{http://research.rods.pitt.edu/apollo/}SchoolClosurePolicyEnum"/>
     *                             &lt;element name="Threshold">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                                   &lt;minInclusive value="0"/>
     *                                   &lt;maxInclusive value="100"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="ClosurePeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                             &lt;element name="ClosureDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="VaccinationScheduleControlMeasureInfo">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="VaccineTemporalDistribution">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="VaccinationPrioritizationScheme" type="{http://research.rods.pitt.edu/apollo/}VaccinationPrioritizationSchemeEnum"/>
     *                             &lt;element name="Compliance">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                                   &lt;minInclusive value="0"/>
     *                                   &lt;maxInclusive value="100"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="NumberOfRuns" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="RandomSeed" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="PercentImmune">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
     *                         &lt;minInclusive value="0"/>
     *                         &lt;maxInclusive value="100"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/extension>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Unregistered" type="{http://research.rods.pitt.edu/apollo/}SupportedTypeCollectionType"/>
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
        "registered",
        "unregistered"
    })
    public static class Parameters {

        @XmlElement(required = true)
        protected AgentBasedModelRunRequestObjType.Parameters.Registered registered;
        @XmlElement(name = "Unregistered", required = true)
        protected SupportedTypeCollectionType unregistered;

        /**
         * Gets the value of the registered property.
         * 
         * @return
         *     possible object is
         *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered }
         *     
         */
        public AgentBasedModelRunRequestObjType.Parameters.Registered getRegistered() {
            return registered;
        }

        /**
         * Sets the value of the registered property.
         * 
         * @param value
         *     allowed object is
         *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered }
         *     
         */
        public void setRegistered(AgentBasedModelRunRequestObjType.Parameters.Registered value) {
            this.registered = value;
        }

        /**
         * Gets the value of the unregistered property.
         * 
         * @return
         *     possible object is
         *     {@link SupportedTypeCollectionType }
         *     
         */
        public SupportedTypeCollectionType getUnregistered() {
            return unregistered;
        }

        /**
         * Sets the value of the unregistered property.
         * 
         * @param value
         *     allowed object is
         *     {@link SupportedTypeCollectionType }
         *     
         */
        public void setUnregistered(SupportedTypeCollectionType value) {
            this.unregistered = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;extension base="{http://research.rods.pitt.edu/apollo/}BaseModelParamObjType">
         *       &lt;sequence>
         *         &lt;element name="SchoolClosureControlMeasureInfo">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="PolicyType" type="{http://research.rods.pitt.edu/apollo/}SchoolClosurePolicyEnum"/>
         *                   &lt;element name="Threshold">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *                         &lt;minInclusive value="0"/>
         *                         &lt;maxInclusive value="100"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="ClosurePeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                   &lt;element name="ClosureDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="VaccinationScheduleControlMeasureInfo">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="VaccineTemporalDistribution">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="VaccinationPrioritizationScheme" type="{http://research.rods.pitt.edu/apollo/}VaccinationPrioritizationSchemeEnum"/>
         *                   &lt;element name="Compliance">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *                         &lt;minInclusive value="0"/>
         *                         &lt;maxInclusive value="100"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="NumberOfRuns" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="RandomSeed" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="PercentImmune">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
         *               &lt;minInclusive value="0"/>
         *               &lt;maxInclusive value="100"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/extension>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "schoolClosureControlMeasureInfo",
            "vaccinationScheduleControlMeasureInfo",
            "numberOfRuns",
            "randomSeed",
            "percentImmune"
        })
        public static class Registered
            extends BaseModelParamObjType
        {

            @XmlElement(name = "SchoolClosureControlMeasureInfo", required = true)
            protected AgentBasedModelRunRequestObjType.Parameters.Registered.SchoolClosureControlMeasureInfo schoolClosureControlMeasureInfo;
            @XmlElement(name = "VaccinationScheduleControlMeasureInfo", required = true)
            protected AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo vaccinationScheduleControlMeasureInfo;
            @XmlElement(name = "NumberOfRuns")
            protected int numberOfRuns;
            @XmlElement(name = "RandomSeed")
            protected int randomSeed;
            @XmlElement(name = "PercentImmune")
            protected double percentImmune;

            /**
             * Gets the value of the schoolClosureControlMeasureInfo property.
             * 
             * @return
             *     possible object is
             *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.SchoolClosureControlMeasureInfo }
             *     
             */
            public AgentBasedModelRunRequestObjType.Parameters.Registered.SchoolClosureControlMeasureInfo getSchoolClosureControlMeasureInfo() {
                return schoolClosureControlMeasureInfo;
            }

            /**
             * Sets the value of the schoolClosureControlMeasureInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.SchoolClosureControlMeasureInfo }
             *     
             */
            public void setSchoolClosureControlMeasureInfo(AgentBasedModelRunRequestObjType.Parameters.Registered.SchoolClosureControlMeasureInfo value) {
                this.schoolClosureControlMeasureInfo = value;
            }

            /**
             * Gets the value of the vaccinationScheduleControlMeasureInfo property.
             * 
             * @return
             *     possible object is
             *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo }
             *     
             */
            public AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo getVaccinationScheduleControlMeasureInfo() {
                return vaccinationScheduleControlMeasureInfo;
            }

            /**
             * Sets the value of the vaccinationScheduleControlMeasureInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo }
             *     
             */
            public void setVaccinationScheduleControlMeasureInfo(AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo value) {
                this.vaccinationScheduleControlMeasureInfo = value;
            }

            /**
             * Gets the value of the numberOfRuns property.
             * 
             */
            public int getNumberOfRuns() {
                return numberOfRuns;
            }

            /**
             * Sets the value of the numberOfRuns property.
             * 
             */
            public void setNumberOfRuns(int value) {
                this.numberOfRuns = value;
            }

            /**
             * Gets the value of the randomSeed property.
             * 
             */
            public int getRandomSeed() {
                return randomSeed;
            }

            /**
             * Sets the value of the randomSeed property.
             * 
             */
            public void setRandomSeed(int value) {
                this.randomSeed = value;
            }

            /**
             * Gets the value of the percentImmune property.
             * 
             */
            public double getPercentImmune() {
                return percentImmune;
            }

            /**
             * Sets the value of the percentImmune property.
             * 
             */
            public void setPercentImmune(double value) {
                this.percentImmune = value;
            }


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
             *         &lt;element name="PolicyType" type="{http://research.rods.pitt.edu/apollo/}SchoolClosurePolicyEnum"/>
             *         &lt;element name="Threshold">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
             *               &lt;minInclusive value="0"/>
             *               &lt;maxInclusive value="100"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="ClosurePeriod" type="{http://www.w3.org/2001/XMLSchema}int"/>
             *         &lt;element name="ClosureDelay" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
                "policyType",
                "threshold",
                "closurePeriod",
                "closureDelay"
            })
            public static class SchoolClosureControlMeasureInfo {

                @XmlElement(name = "PolicyType", required = true)
                protected SchoolClosurePolicyEnum policyType;
                @XmlElement(name = "Threshold")
                protected double threshold;
                @XmlElement(name = "ClosurePeriod")
                protected int closurePeriod;
                @XmlElement(name = "ClosureDelay")
                protected int closureDelay;

                /**
                 * Gets the value of the policyType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link SchoolClosurePolicyEnum }
                 *     
                 */
                public SchoolClosurePolicyEnum getPolicyType() {
                    return policyType;
                }

                /**
                 * Sets the value of the policyType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link SchoolClosurePolicyEnum }
                 *     
                 */
                public void setPolicyType(SchoolClosurePolicyEnum value) {
                    this.policyType = value;
                }

                /**
                 * Gets the value of the threshold property.
                 * 
                 */
                public double getThreshold() {
                    return threshold;
                }

                /**
                 * Sets the value of the threshold property.
                 * 
                 */
                public void setThreshold(double value) {
                    this.threshold = value;
                }

                /**
                 * Gets the value of the closurePeriod property.
                 * 
                 */
                public int getClosurePeriod() {
                    return closurePeriod;
                }

                /**
                 * Sets the value of the closurePeriod property.
                 * 
                 */
                public void setClosurePeriod(int value) {
                    this.closurePeriod = value;
                }

                /**
                 * Gets the value of the closureDelay property.
                 * 
                 */
                public int getClosureDelay() {
                    return closureDelay;
                }

                /**
                 * Sets the value of the closureDelay property.
                 * 
                 */
                public void setClosureDelay(int value) {
                    this.closureDelay = value;
                }

            }


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
             *         &lt;element name="VaccineTemporalDistribution">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="VaccinationPrioritizationScheme" type="{http://research.rods.pitt.edu/apollo/}VaccinationPrioritizationSchemeEnum"/>
             *         &lt;element name="Compliance">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
             *               &lt;minInclusive value="0"/>
             *               &lt;maxInclusive value="100"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
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
                "vaccineTemporalDistribution",
                "vaccinationPrioritizationScheme",
                "compliance"
            })
            public static class VaccinationScheduleControlMeasureInfo {

                @XmlElement(name = "VaccineTemporalDistribution", required = true)
                protected AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo.VaccineTemporalDistribution vaccineTemporalDistribution;
                @XmlElement(name = "VaccinationPrioritizationScheme", required = true)
                protected VaccinationPrioritizationSchemeEnum vaccinationPrioritizationScheme;
                @XmlElement(name = "Compliance")
                protected double compliance;

                /**
                 * Gets the value of the vaccineTemporalDistribution property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo.VaccineTemporalDistribution }
                 *     
                 */
                public AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo.VaccineTemporalDistribution getVaccineTemporalDistribution() {
                    return vaccineTemporalDistribution;
                }

                /**
                 * Sets the value of the vaccineTemporalDistribution property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo.VaccineTemporalDistribution }
                 *     
                 */
                public void setVaccineTemporalDistribution(AgentBasedModelRunRequestObjType.Parameters.Registered.VaccinationScheduleControlMeasureInfo.VaccineTemporalDistribution value) {
                    this.vaccineTemporalDistribution = value;
                }

                /**
                 * Gets the value of the vaccinationPrioritizationScheme property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link VaccinationPrioritizationSchemeEnum }
                 *     
                 */
                public VaccinationPrioritizationSchemeEnum getVaccinationPrioritizationScheme() {
                    return vaccinationPrioritizationScheme;
                }

                /**
                 * Sets the value of the vaccinationPrioritizationScheme property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link VaccinationPrioritizationSchemeEnum }
                 *     
                 */
                public void setVaccinationPrioritizationScheme(VaccinationPrioritizationSchemeEnum value) {
                    this.vaccinationPrioritizationScheme = value;
                }

                /**
                 * Gets the value of the compliance property.
                 * 
                 */
                public double getCompliance() {
                    return compliance;
                }

                /**
                 * Sets the value of the compliance property.
                 * 
                 */
                public void setCompliance(double value) {
                    this.compliance = value;
                }


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
                 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="unbounded"/>
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
                    "value"
                })
                public static class VaccineTemporalDistribution {

                    @XmlElement(type = Double.class)
                    protected List<Double> value;

                    /**
                     * Gets the value of the value property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the value property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getValue().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Double }
                     * 
                     * 
                     */
                    public List<Double> getValue() {
                        if (value == null) {
                            value = new ArrayList<Double>();
                        }
                        return this.value;
                    }

                }

            }

        }

    }

}