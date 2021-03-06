package edu.pitt.apollo.libraryclient;

import edu.pitt.apollo.types.v3_0_0.ApolloPathogenCode;
import edu.pitt.apollo.types.v3_0_0.DiseaseOutcomeEnum;
import edu.pitt.apollo.types.v3_0_0.DiseaseOutcomeWithProbability;
import edu.pitt.apollo.types.v3_0_0.FixedDuration;
import edu.pitt.apollo.types.v3_0_0.Infection;
import edu.pitt.apollo.types.v3_0_0.InfectionAcquisitionFromInfectiousHost;
import edu.pitt.apollo.types.v3_0_0.InfectionStateEnum;
import edu.pitt.apollo.types.v3_0_0.InfectiousDisease;
import edu.pitt.apollo.types.v3_0_0.InfectiousDiseaseScenario;
import edu.pitt.apollo.types.v3_0_0.Location;
import edu.pitt.apollo.types.v3_0_0.LocationDefinition;
import edu.pitt.apollo.types.v3_0_0.PopulationInfectionAndImmunityCensus;
import edu.pitt.apollo.types.v3_0_0.PopulationInfectionAndImmunityCensusData;
import edu.pitt.apollo.types.v3_0_0.PopulationInfectionAndImmunityCensusDataCell;
import edu.pitt.apollo.types.v3_0_0.ProbabilisticParameter;
import edu.pitt.apollo.types.v3_0_0.ReproductionNumber;
import edu.pitt.apollo.types.v3_0_0.UnitOfTimeEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * Author: Nick Millett
 * Email: nick.millett@gmail.com
 * Date: Dec 4, 2014
 * Time: 11:03:07 AM
 * Class: ExampleInfectiousDiseaseScenario
 */
public class ExampleInfectiousDiseaseScenario {

	public static InfectiousDiseaseScenario getScenario() throws DatatypeConfigurationException, ParseException {

		InfectiousDiseaseScenario scenario = new InfectiousDiseaseScenario();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = simpleDateFormat.parse("2009-09-08T00:00:00-04:00");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		XMLGregorianCalendar xmlCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		scenario.setScenarioDate(xmlCal);

		Infection infection = new Infection();
		InfectionAcquisitionFromInfectiousHost iafih = new InfectionAcquisitionFromInfectiousHost();

		ApolloPathogenCode pathogen = new ApolloPathogenCode();
		pathogen.setNcbiTaxonId("114727");
		pathogen.setCladeName("Influenza A (H1N1)pdm09");
		infection.setPathogen(pathogen);
		infection.setHostTaxonId("9606");

		iafih.setInfectiousHostTaxonId("9606");

		ReproductionNumber r0 = new ReproductionNumber();
		r0.setExactValue(1.3);
		iafih.getBasicReproductionNumbers().add(r0);

		FixedDuration latentPeriod = new FixedDuration();
		latentPeriod.setUnitOfTime(UnitOfTimeEnum.DAY);
		latentPeriod.setValue(2.0);
		iafih.setLatentPeriodDuration(latentPeriod);

		FixedDuration infectiousPeriod = new FixedDuration();
		infectiousPeriod.setUnitOfTime(UnitOfTimeEnum.DAY);
		infectiousPeriod.setValue(6.0);
		iafih.setInfectiousPeriodDuration(latentPeriod);

		infection.getInfectionAcquisitionsFromInfectiousHosts().add(iafih);

		InfectiousDisease disease = new InfectiousDisease();
		disease.setDiseaseId("Influenza");
		disease.setCausalPathogen(pathogen);
		disease.setSpeciesWithDisease("9606");

		DiseaseOutcomeWithProbability dowp = new DiseaseOutcomeWithProbability();
		dowp.setDiseaseOutcome(DiseaseOutcomeEnum.ASYMPTOMATIC);
		ProbabilisticParameter probability = new ProbabilisticParameter();
		probability.setProbability(0.33);
		dowp.setProbability(probability);

		disease.getDiseaseOutcomesWithProbabilities().add(dowp);

		infection.getInfectiousDiseases().add(disease);
		scenario.getInfections().add(infection);

		Location location = new Location();
		LocationDefinition locationDefinition = new LocationDefinition();
		locationDefinition.getLocationsIncluded().add("42003");
		location.setLocationDefinition(locationDefinition);
		scenario.setLocation(location);

		PopulationInfectionAndImmunityCensus census = new PopulationInfectionAndImmunityCensus();

		census.setDescription("");
		census.setPopulationSpecies("9606");
		census.setSimulatorTime(0);
		census.setPathogen(pathogen);
		census.setLocation(location);

		PopulationInfectionAndImmunityCensusData data = new PopulationInfectionAndImmunityCensusData();
		data.setLocation(location);

		PopulationInfectionAndImmunityCensusDataCell susceptibleCell = new PopulationInfectionAndImmunityCensusDataCell();
		susceptibleCell.setInfectionState(InfectionStateEnum.SUSCEPTIBLE);
		susceptibleCell.setFractionInState(0.94859);

		PopulationInfectionAndImmunityCensusDataCell exposedCell = new PopulationInfectionAndImmunityCensusDataCell();
		exposedCell.setInfectionState(InfectionStateEnum.LATENT);
		exposedCell.setFractionInState(0.00538);

		PopulationInfectionAndImmunityCensusDataCell infectiousCell = new PopulationInfectionAndImmunityCensusDataCell();
		infectiousCell.setInfectionState(InfectionStateEnum.INFECTIOUS);
		infectiousCell.setFractionInState(0.00603);

		PopulationInfectionAndImmunityCensusDataCell recoveredCell = new PopulationInfectionAndImmunityCensusDataCell();
		recoveredCell.setInfectionState(InfectionStateEnum.RECOVERED);
		recoveredCell.setFractionInState(0.04);

		data.getCensusDataCells().add(susceptibleCell);
		data.getCensusDataCells().add(exposedCell);
		data.getCensusDataCells().add(infectiousCell);
		data.getCensusDataCells().add(recoveredCell);

		census.setCensusData(data);

		scenario.getPopulationInfectionAndImmunityCensuses().add(census);

		return scenario;
	}

}
