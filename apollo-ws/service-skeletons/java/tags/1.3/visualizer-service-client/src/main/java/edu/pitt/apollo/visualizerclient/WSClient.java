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

package edu.pitt.apollo.visualizerclient;



import edu.pitt.apollo.service.visualizerservice._07._03._2013.VisualizerServiceEI;
import edu.pitt.apollo.service.visualizerservice._07._03._2013.VisualizerServiceV13;
import edu.pitt.apollo.types._07._03._2013.RunStatus;

public class WSClient {
	public static void main(String[] args) {
		VisualizerServiceV13 service = new VisualizerServiceV13();
		VisualizerServiceEI port = service.getVisualizerServiceEndpoint();

		RunStatus rs = port.getRunStatus("test");
		System.out.println(rs.getMessage());

		System.out.println("Status: " + rs.getStatus());
	}
}
