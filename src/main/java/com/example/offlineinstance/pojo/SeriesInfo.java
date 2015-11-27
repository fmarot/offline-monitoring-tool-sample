package com.example.offlineinstance.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SeriesInfo {

	private String	manufacturer;
	private String	model;
	private String	softwareVersions;

	private String	description;
	private String	protocol;
	private String	imageType;
	private String	type;
}
