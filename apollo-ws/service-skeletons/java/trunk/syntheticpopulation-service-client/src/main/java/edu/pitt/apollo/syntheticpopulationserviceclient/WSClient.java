/* Copyright 2012 University of Pittsburgh
*
* Licensed under the Apache License, Version 2.0 (the "License"); you may not
* use this file except in compliance with the License.  You may obtain a copy of
* the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
* License for the specific language governing permissions and limitations under
* the License.
*/

package edu.pitt.apollo.syntheticpopulationserviceclient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import edu.pitt.apollo.service.syntheticpopulationservice.v3_0_0.SyntheticPopulationServiceEI;
import edu.pitt.apollo.service.syntheticpopulationservice.v3_0_0.SyntheticPopulationServiceV300;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;
import edu.pitt.apollo.services_common.v3_0_0.ServiceResult;
import edu.pitt.apollo.synthetic_population_service_types.v3_0_0.RunSyntheticPopulationGenerationMessage;

public class WSClient {
	public static void main(String[] args) throws MalformedURLException {
//		SynthiaWS service = new SynthiaWS(new URL("https://synthiastage.rti.org/Account/synthia-WS.asmx?WSDL"));
//		SynthiaWSSoap port = service.getSynthiaWSSoap();
//		
//
////		RunStatus rs = port.getRunStatus("test");
////		System.out.println(rs.getMessage());
//
//		System.out.println("Using WSDL: https://synthiastage.rti.org/Account/synthia-WS.asmx?WSDL");
//		System.out.println("Calling getStatus for runId: 12497");
//		RunStatus rs = port.getStatus("12497");
//		System.out.println("Status Enum: " + rs.getStatus());
//		System.out.println("Status Message: " + rs.getMessage());
		//stuff above is interesting legacy comments
		
		
		//below is an example usage of generateSyntheticPopulation() and getRunStatus()
		List<String> boundaryIDs = new ArrayList<String>();
		List<String> variableIDs = new ArrayList<String>();
		BigInteger year = BigInteger.valueOf(2015);
		BigInteger month = BigInteger.valueOf(4);
		BigInteger day = BigInteger.valueOf(13);
		
		boundaryIDs.add("1");
		boundaryIDs.add("2");
		boundaryIDs.add("3");
		variableIDs.add("2");
		variableIDs.add("4");
		variableIDs.add("6");
		
		List<ServiceResult> serviceResults = generateSyntheticPopulation(boundaryIDs, variableIDs, year, month, day);
		
		for(ServiceResult result : serviceResults) {
			System.out.println(result.getURL());
			System.out.println(result.getDescription() + "\n");
		}
		
		//CAUTION: getRunStatus may be subject to changes
		BigInteger runID = BigInteger.ZERO;
		MethodCallStatus runStatus = getRunStatus(runID);
		
		System.out.println(runStatus + "\n");
		
		return;
	}
	
	/**
	 * @param boundaryIDs boundaryIDs is a list of the boundary fips codes which can be either the state fips code, 2 character, or county fips code, 5 character
	 * @param variableIDs variableIDs is a list of the string values from synthia.variables table 
	 * @param year year of the date
	 * @param month month of the date
	 * @param day day of the date
	 * @return the list of ServiceResults for running the synthetic population generation on the input parameters
	 **/
	public static List<ServiceResult> generateSyntheticPopulation(List<String> boundaryIDs, List<String> variableIDs, BigInteger year, BigInteger month, BigInteger day) throws MalformedURLException {
		SyntheticPopulationServiceV300 syntheticPopulationService = new SyntheticPopulationServiceV300();
		SyntheticPopulationServiceEI syntheticPopulationServiceEndpoint = syntheticPopulationService.getSyntheticPopulationServiceEndpoint();
		RunSyntheticPopulationGenerationMessage runSyntheticPopulationGenerationMessage = new RunSyntheticPopulationGenerationMessage();
		
		runSyntheticPopulationGenerationMessage.getBoundaryId().addAll(boundaryIDs);
		runSyntheticPopulationGenerationMessage.getVariableId().addAll(variableIDs);
		
		runSyntheticPopulationGenerationMessage.setYear(BigInteger.valueOf(2015));
		runSyntheticPopulationGenerationMessage.setMonth(BigInteger.valueOf(4));
		runSyntheticPopulationGenerationMessage.setDay(BigInteger.valueOf(10));
		
		return syntheticPopulationServiceEndpoint.runSyntheticPopulationGeneration(runSyntheticPopulationGenerationMessage);
	}
	
	public static MethodCallStatus getRunStatus(BigInteger runID) {
		SyntheticPopulationServiceV300 syntheticPopulationService = new SyntheticPopulationServiceV300();
		SyntheticPopulationServiceEI syntheticPopulationServiceEndpoint = syntheticPopulationService.getSyntheticPopulationServiceEndpoint();
		
		return syntheticPopulationServiceEndpoint.getRunStatus(runID);
	}
}
