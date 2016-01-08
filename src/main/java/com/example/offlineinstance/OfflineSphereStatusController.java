package com.example.offlineinstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GLOBALS;
import com.example.offlineinstance.pojo.OfflineSphereStatus;
import com.example.offlineinstance.pojo.OfflineSphereTechnicalStatus;
import com.example.offlineinstance.pojo.ProcessedQueueItem;
import com.example.offlineinstance.pojo.ProcessingParameters;
import com.example.offlineinstance.pojo.SeriesInfo;
import com.example.offlineinstance.pojo.StudyLink;
import com.example.offlineinstance.pojo.WaitingQueueItem;
import com.example.offlineinstance.pojo.WorkflowPreventedReasons;

@RestController
public class OfflineSphereStatusController {

	@Value("${offlineAPIVersion}")
	private String	offlineAPIVersion;

	@RequestMapping("/offlineinstance/offlinestatus")
	public OfflineSphereStatus offlineStatus() {
		OfflineSphereStatus status = buildFakeStatus();
		return status;
	}

	@RequestMapping("/offlineinstance/offlinetechnicalstatus")
	public OfflineSphereTechnicalStatus offlineTechnicalStatus() {
		return new OfflineSphereTechnicalStatus(offlineAPIVersion, "192.168.3.3", 1001, "3.1.0-SNAPSHOT", "todo...", "todo...");
	}

	private OfflineSphereStatus buildFakeStatus() {
		OfflineSphereStatus status = new OfflineSphereStatus();

		// 1st waiting study
		StudyLink studyInfo1 = new StudyLink(GLOBALS.STUDY_1_UUID, "http://127.0.0.1:8080/datamanager/studies/" + GLOBALS.STUDY_1_UUID);
		WaitingQueueItem waitingItem1 = new WaitingQueueItem(studyInfo1, new Date(), "worflowFoo");
		status.addWaitingItem(waitingItem1);

		// 2nd waiting study
		StudyLink studyInfo2 = new StudyLink(GLOBALS.STUDY_2_UUID, "http://127.0.0.1:8080/datamanager/studies/" + GLOBALS.STUDY_2_UUID);
		WaitingQueueItem waitingItem2 = new WaitingQueueItem(studyInfo2, new Date(), "worflowFoo");
		status.addWaitingItem(waitingItem2);

		// Study currently being processed
		StudyLink studyInfoProcessing = new StudyLink(GLOBALS.STUDY_4_UUID, "http://127.0.0.1:8080/datamanager/studies/" + GLOBALS.STUDY_4_UUID);
		WaitingQueueItem processingItem = new WaitingQueueItem(studyInfoProcessing, new Date(), "worflowBar");
		status.setProcessingItem(processingItem);

		// 1st processed study
		StudyLink studyInfo = new StudyLink(GLOBALS.STUDY_3_UUID, "http://127.0.0.1:8080/datamanager/studies/" + GLOBALS.STUDY_3_UUID);
		Date timeOfAddition = new Date();
		String workflow = GLOBALS.WORFLOW_1;
		Date timeOfProcessed = new Date();
		Boolean result = false;
		String resultInfo = "Exception: something went wrong, error code = FOOBAR_42";
		// @formatter:off
		
		List<WorkflowPreventedReasons> workflowPreventedReasons = new ArrayList<WorkflowPreventedReasons>() {{
			add(new WorkflowPreventedReasons("fakeWF_1", Arrays.asList("STUDY_DESCRIPTION" ,"PROTOCOL")));
			add(new WorkflowPreventedReasons("fakeWF_2", Arrays.asList("MANUFACTURER" ,"INSTANCES_SIZE", "IMAGE_TYPE")));
		}};
		List<SeriesInfo> availableSeries = new ArrayList<SeriesInfo>() {{
			add(new SeriesInfo("manufacturer", "model", "2.2-BETA", "T2 FLAIR TRA", "2 FLAIR TRA SENSE", "301",  Arrays.asList("ORIGINAL" ,"PRIMARY", "M_IR")));
			add(new SeriesInfo("manufacturer2", "old model", "1.1", "PERFUSION", "PERFUSION CLEAR", "401",  Arrays.asList("ORIGINAL" ,"PRIMARY", "FFE")));
		}};
		// @formatter:on
		ProcessingParameters processingParameter1 = new ProcessingParameters(workflowPreventedReasons, availableSeries);
		List<ProcessingParameters> params = Arrays.asList(processingParameter1);
		ProcessedQueueItem processedItem = new ProcessedQueueItem(studyInfo, timeOfAddition, workflow, timeOfProcessed, result, resultInfo, params);

		status.addProcessedItem(processedItem);
		return status;
	}
}