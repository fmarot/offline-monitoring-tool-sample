package com.example.datamanager.pojo;

import java.util.List;

import lombok.Data;

@Data
public class DatamanagerOfflineStatus {
	private List<OfflineSphereInfo> offlineSpheres;
	private List<OfflineEvent> offlineEvents;
}
