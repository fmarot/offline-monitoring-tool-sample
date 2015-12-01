package com.example.offlineinstance.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SeriesInfo {

	private String			manufacturer;
	private String			model;
	private String			softwareVersions;

	private String			seriesDescription;
	private String			seriesProtocol;
	private String			seriesNumber;
	private List<String>	imageTypes;
}
