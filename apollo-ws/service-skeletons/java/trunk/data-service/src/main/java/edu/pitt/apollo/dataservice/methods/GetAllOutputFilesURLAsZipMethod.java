package edu.pitt.apollo.dataservice.methods;

import edu.pitt.apollo.ApolloServiceQueue;
import edu.pitt.apollo.data_service_types.v3_0_0.GetAllOutputFilesURLAsZipMessage;
import static edu.pitt.apollo.dataservice.methods.DataServiceMethod.OUTPUT_DIRECTORY;
import edu.pitt.apollo.dataservice.thread.DataServiceAllFilesThread;
import edu.pitt.apollo.dataservice.thread.DataServiceThread;
import edu.pitt.apollo.dataservice.utils.RunUtils;
import edu.pitt.apollo.db.exceptions.ApolloDatabaseException;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatus;
import edu.pitt.apollo.services_common.v3_0_0.MethodCallStatusEnum;
import java.io.File;
import java.math.BigInteger;

/**
 *
 * Author: Nick Millett
 * Email: nick.millett@gmail.com
 * Date: Feb 6, 2015
 * Time: 4:40:06 PM
 * Class: GetAllOutputFilesURLAsZipMethod
 */
public class GetAllOutputFilesURLAsZipMethod extends DataServiceMethod {

	private GetAllOutputFilesURLAsZipMessage message;

	public GetAllOutputFilesURLAsZipMethod(ApolloServiceQueue queue, BigInteger runId) {
		super(queue, runId);
		loadGetAllOutputFilesURLAzZipMessage();
	}

	@Override
	public void downloadFiles() {

		String outputDirectory = OUTPUT_DIRECTORY + runId + File.separator;
		DataServiceThread thread = new DataServiceAllFilesThread(runId, message.getRunId(), queue, dbUtils, outputDirectory, ZIP_FILE_NAME, message.getFileNames());

		MethodCallStatus queueStatus = queue.addThreadToQueueAndRun(thread);
		if (queueStatus.getStatus().equals(MethodCallStatusEnum.FAILED)) {
			RunUtils.updateStatus(dbUtils, runId, MethodCallStatusEnum.FAILED, queueStatus.getMessage());
		} else {
			RunUtils.updateStatus(dbUtils, runId, MethodCallStatusEnum.RUNNING, "The data service request was successful");
		}

	}

	private void loadGetAllOutputFilesURLAzZipMessage() {
		try {
			message = dbUtils.getGetAllOutputFilesURLAsZipMessageForRun(runId);
			if (message == null) {
				RunUtils.updateStatus(dbUtils, runId, MethodCallStatusEnum.FAILED, "The runSimulationMessage obtained from the database was null");
			}
		} catch (ApolloDatabaseException ex) {
			RunUtils.updateStatus(dbUtils, runId, MethodCallStatusEnum.FAILED, ex.getMessage());
		}
	}
}
