
package edu.pitt.apollo.simulator_service_types.v3_0_0;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.pitt.apollo.simulator_service_types.v3_0_0 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.pitt.apollo.simulator_service_types.v3_0_0
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RunSimulationMessage }
     * 
     */
    public RunSimulationMessage createRunSimulationMessage() {
        return new RunSimulationMessage();
    }

    /**
     * Create an instance of {@link GetPopulationAndEnvironmentCensusResult }
     * 
     */
    public GetPopulationAndEnvironmentCensusResult createGetPopulationAndEnvironmentCensusResult() {
        return new GetPopulationAndEnvironmentCensusResult();
    }

    /**
     * Create an instance of {@link GetConfigurationFileForSimulationResult }
     * 
     */
    public GetConfigurationFileForSimulationResult createGetConfigurationFileForSimulationResult() {
        return new GetConfigurationFileForSimulationResult();
    }

    /**
     * Create an instance of {@link RunSimulationResult }
     * 
     */
    public RunSimulationResult createRunSimulationResult() {
        return new RunSimulationResult();
    }

    /**
     * Create an instance of {@link GetScenarioLocationCodesSupportedBySimulatorResult }
     * 
     */
    public GetScenarioLocationCodesSupportedBySimulatorResult createGetScenarioLocationCodesSupportedBySimulatorResult() {
        return new GetScenarioLocationCodesSupportedBySimulatorResult();
    }

}
