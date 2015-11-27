package com.example.datamanager;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GLOBALS;
import com.example.datamanager.pojo.DatamanagerOfflineStatus;
import com.example.datamanager.pojo.NewStudyEvent;
import com.example.datamanager.pojo.OfflineEvent;
import com.example.datamanager.pojo.OfflineSphereInfo;
import com.example.datamanager.pojo.WorkflowTriggeredEvent;

@RestController
public class DatamanagerOfflineStatusController {

	@RequestMapping("/datamanager/offlinestatus")
	public DatamanagerOfflineStatus offlineStatus() {
		DatamanagerOfflineStatus status = new DatamanagerOfflineStatus();
		status.setOfflineEvents(new ArrayList<OfflineEvent>() {

			{
				add(new NewStudyEvent("111111-1111", new Date()));
				add(new NewStudyEvent("654324", new Date()));
				add(new WorkflowTriggeredEvent(GLOBALS.STUDY_2_UUID, new Date(), GLOBALS.WORFLOW_1));
				add(new WorkflowTriggeredEvent(GLOBALS.STUDY_1_UUID, new Date(), GLOBALS.WORFLOW_2));
				add(new NewStudyEvent("64741-4216587-4554", new Date()));
			}
		});
		status.setOfflineSpheres(new ArrayList<OfflineSphereInfo>() {

			{
				add(new OfflineSphereInfo("192.168.0.1", 8080));
				add(new OfflineSphereInfo("192.168.2.1", 80));
				add(new OfflineSphereInfo("192.168.10.10", 999));
			}
		});
		return status;
	}
}