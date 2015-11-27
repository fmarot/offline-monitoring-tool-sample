package com.example.offlineinstance.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OfflineSphereTechnicalStatus {

	private String	offlineAPIVersion;
	private String	ip;
	private int		port;
	private String	sphereVersion;
	private String	seriesRecognitionInfo;	// TODO
	private String	logs;					// TODO
}
