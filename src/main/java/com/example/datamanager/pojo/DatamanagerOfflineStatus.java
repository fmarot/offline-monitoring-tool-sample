package com.example.datamanager.pojo;

import java.util.List;

import lombok.Data;

@Data
public class DatamanagerOfflineStatus {
	private String offlineAPIVersion;
	private List<OfflineSphereInfo> offlineSpheres;
	private List<OfflineEvent> offlineEvents;
	
	public DatamanagerOfflineStatus(String offlineAPIVersion) {
		this.offlineAPIVersion = offlineAPIVersion;
	}
}
