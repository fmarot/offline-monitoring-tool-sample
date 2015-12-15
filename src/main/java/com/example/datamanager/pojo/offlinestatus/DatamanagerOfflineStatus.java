package com.example.datamanager.pojo.offlinestatus;

import java.util.List;

import lombok.Data;

/** This contain the basic status of the datamanager regarding Offline:
 * - the basic list of raw events (each of one will be handled by a (unknown yet) Offline Sphere instance 
 * - the list of the existing Offline Sphere instance so you can contact them to have more details about what's going on in each of them */
@Data
public class DatamanagerOfflineStatus {
	private String offlineAPIVersion;
	private List<OfflineSphereInfo> offlineSpheres;
	private List<OfflineEvent> offlineEvents;
	
	public DatamanagerOfflineStatus(String offlineAPIVersion) {
		this.offlineAPIVersion = offlineAPIVersion;
	}
}
