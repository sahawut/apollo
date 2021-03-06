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
package edu.pitt.apollo.apolloclient.tutorial;

import edu.pitt.apollo.apolloclient.tutorial.ApolloServiceTypeFactory.SimulatorIdentificationEnum;
import edu.pitt.apollo.types.v2_0_1.RunSimulationMessage;

public class Chapter2_RunSimulationWithNoIntervention extends AbstractRunAndVisualizeSimulationClass {
	public Chapter2_RunSimulationWithNoIntervention() {
		super();
	}

	public void runExample() {
		RunSimulationMessage runSimulationMessage = ApolloServiceTypeFactory
				.getMinimalistRunSimulationMessage(SimulatorIdentificationEnum.FRED);
		runScenarioAndDisplayResults(runSimulationMessage);
	}

	public static void main(String args[]) throws java.lang.Exception {
		Chapter2_RunSimulationWithNoIntervention tutorialChapter2 = new Chapter2_RunSimulationWithNoIntervention();
		tutorialChapter2.runExample();

	}
}