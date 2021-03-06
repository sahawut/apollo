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

package edu.pitt.apollo.simulatorclient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.ws.Holder;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import edu.pitt.apollo.service.simulatorservice.SimulatorService;
import edu.pitt.apollo.service.simulatorservice.SimulatorServiceEI;
import edu.pitt.apollo.types.AntiviralControlMeasure;
import edu.pitt.apollo.types.Authentication;
import edu.pitt.apollo.types.Disease;
import edu.pitt.apollo.types.PopulationDiseaseState;
import edu.pitt.apollo.types.RunStatus;
import edu.pitt.apollo.types.RunStatusEnum;
import edu.pitt.apollo.types.ServiceRecord;
import edu.pitt.apollo.types.SimulatedPopulation;
import edu.pitt.apollo.types.SimulatorConfiguration;
import edu.pitt.apollo.types.SimulatorIdentification;
import edu.pitt.apollo.types.SimulatorTimeSpecification;
import edu.pitt.apollo.types.TimeStepUnit;
import edu.pitt.apollo.types.VaccinationControlMeasure;

public class WSClient {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
//		SimulatorService ss = new SimulatorService(new URL("http://jdl50-mnb-024.home:8087/fred?wsdl"));
//        SimulatorServiceEI port = ss.getSimulatorServiceEndpoint();  
//        
//        {
//        System.out.println("Invoking getRunStatus...");
//        java.lang.String _getRunStatus_runId = "Pitt,PSC,CMU_FRED_2.0.1_231162";
//        edu.pitt.apollo.types.RunStatus _getRunStatus__return = port.getRunStatus(_getRunStatus_runId);
//        System.out.println("getRunStatus.result=" + _getRunStatus__return.getMessage());


	
		SimulatorService service = new SimulatorService(new URL("http://warhol-fred.psc.edu:8087/fred?wsdl"));
		
		
		SimulatorServiceEI port = service.getSimulatorServiceEndpoint();
		
		 // Turn off chunking so that NTLM can occur
        Client client = ClientProxy.getClient(port);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(36000);
        httpClientPolicy.setAllowChunking(false);
        http.setClient(httpClientPolicy);
//	
	
	    //ServiceRegistrationRecord srr = new ServiceRegistrationRecord();

		Authentication auth = new Authentication();
		auth.setRequesterId("fake_user");
		auth.setRequesterPassword("fake_password");
	//	srr.setAuthentication(auth);

		ServiceRecord sr = new ServiceRecord();
		SimulatorIdentification si = new SimulatorIdentification();
		si.setSimulatorDeveloper("UPitt,PSC,CMU");
		si.setSimulatorName("FRED");
		si.setSimulatorVersion("2.0.1");
		sr.setSimulatorIdentification(si);

	//	srr.setServiceRecord(sr);
		//srr.setUrl("http://warhol-fred.psc.edu:8087/fred?wsdl");
//		srr.setUrl("http://localhost:8087/fred?wsdl");

		Holder<Boolean> success = new Holder<Boolean>();
		Holder<String> msg = new Holder<String>();
	//	port.registerService(srr, success, msg);
		System.out.println(msg.value);

		SimulatorConfiguration simulatorConfiguration = new SimulatorConfiguration();

		simulatorConfiguration.setAuthentication(auth);
		simulatorConfiguration
				.setAntiviralControlMeasure(new AntiviralControlMeasure());
		AntiviralControlMeasure acm = simulatorConfiguration
				.getAntiviralControlMeasure();
		acm.setAntiviralCmCompliance(0d);
		acm.setAntiviralEfficacy(0d);
		acm.setAntiviralEfficacyDelay(0d);
		acm.getAntiviralAdminSchedule().add(1d);
		acm.getAntiviralSupplySchedule().add(1d);

		simulatorConfiguration.setSimulatorIdentification(si);

		simulatorConfiguration.setDisease(new Disease());
		Disease disease = simulatorConfiguration.getDisease();
		disease.setAsymptomaticInfectionFraction(0.5);
		disease.setDiseaseName("Influenza");
		disease.setInfectiousPeriod(3.2);
		disease.setLatentPeriod(2.0);
		disease.setReproductionNumber(1.7);

		simulatorConfiguration
				.setPopulationInitialization(new SimulatedPopulation());
		SimulatedPopulation sp = simulatorConfiguration
				.getPopulationInitialization();
		sp.setPopulationLocation("42003");

		List<PopulationDiseaseState> ds = sp.getPopulationDiseaseState();
		PopulationDiseaseState pds = new PopulationDiseaseState();
		pds.setDiseaseState("susceptible");
		pds.setPopCount(new BigInteger("1157474"));
		ds.add(pds);
		pds = new PopulationDiseaseState();
		pds.setDiseaseState("exposed");
		pds.setPopCount(new BigInteger("0"));
		ds.add(pds);
		pds = new PopulationDiseaseState();
		pds.setDiseaseState("infectious");
		pds.setPopCount(new BigInteger("100"));
		ds.add(pds);
		pds = new PopulationDiseaseState();
		pds.setDiseaseState("recovered");
		pds.setPopCount(new BigInteger("60920"));
		ds.add(pds);

		simulatorConfiguration
				.setSimulatorTimeSpecification(new SimulatorTimeSpecification());
		SimulatorTimeSpecification stc = simulatorConfiguration
				.getSimulatorTimeSpecification();
		stc.setRunLength(new BigInteger("30"));
		stc.setTimeStepUnit(TimeStepUnit.DAY);
		stc.setTimeStepValue(1d);

		simulatorConfiguration
				.setVaccinationControlMeasure(new VaccinationControlMeasure());
		VaccinationControlMeasure vcm = simulatorConfiguration
				.getVaccinationControlMeasure();
		vcm.setVaccineCmCompliance(0d);
		vcm.setVaccineEfficacy(0d);
		vcm.setVaccineEfficacyDelay(0d);
		for (int i = 0; i < 30; i++) {
			vcm.getVaccinationAdminSchedule().add(0d);
			vcm.getVaccineSupplySchedule().add(0d);
		}
		
		String runId = port.run(simulatorConfiguration);

		System.out.println("Simulation result: " + runId);
		

		//String runId = "Pitt,PSC,CMU_FRED_2.0.1_231162";
		RunStatus rs = port.getRunStatus(runId);
		while (rs.getStatus() != RunStatusEnum.COMPLETED) {
			System.out.println("Status is " + rs.getStatus());
			System.out.println("Message is " + rs.getMessage());
			System.out.println("\n");
			Thread.sleep(500);
		    rs = port.getRunStatus(runId);
		}
		System.out.println("Status is " + rs.getStatus());
		System.out.println("Message is " + rs.getMessage());
		// port.unRegisterService(srr, success, msg);
		// System.out.println(msg.value);
	}
		 
}
