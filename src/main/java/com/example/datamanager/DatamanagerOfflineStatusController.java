package com.example.datamanager;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GLOBALS;
import com.example.datamanager.pojo.offlinestatus.DatamanagerOfflineStatus;
import com.example.datamanager.pojo.offlinestatus.NewStudyEvent;
import com.example.datamanager.pojo.offlinestatus.OfflineEvent;
import com.example.datamanager.pojo.offlinestatus.OfflineSphereInfo;
import com.example.datamanager.pojo.offlinestatus.WorkflowTriggeredEvent;

@RestController
public class DatamanagerOfflineStatusController {

	@Value("${offlineAPIVersion}")
	private String	offlineAPIVersion;

	@RequestMapping("/datamanager/offlinestatus")
	public DatamanagerOfflineStatus offlineStatus() {
		DatamanagerOfflineStatus status = new DatamanagerOfflineStatus(offlineAPIVersion);
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
				add(new OfflineSphereInfo("127.0.0.1", 8080, "http://127.0.0.1:8080/offlineinstance/offlinetechnicalstatus", "http://127.0.0.1:8080/offlineinstance/offlinestatus"));
				add(new OfflineSphereInfo("192.168.2.1", 80, "http://127.0.0.1:8080/offlineinstance/offlinetechnicalstatus", "http://192.168.10.10:8080/offlineinstance/offlinestatus"));
				add(new OfflineSphereInfo("192.168.10.10", 999, "http://127.0.0.1:8080/offlineinstance/offlinetechnicalstatus", "http://192.168.10.10:999/offlineinstance/offlinestatus"));
			}
		});
		return status;
	}
}