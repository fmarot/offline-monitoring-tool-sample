package com.example.datamanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OfflineSphereInfo {
	String ip;
	int port;
	String hrefOfflinetechnicalstatus;	// TODO: ideally, we should have at least 2 listed url, one for http://localhost:8080/offlineinstance/offlinetechnicalstatus and one for http://localhost:8080/offlineinstance/offlinestatus
	String hrefOfflinestatus; // TODO2: the representation of the links may follow the HAL specification (see Spring hateoas) or the JSON-LD specification
}
