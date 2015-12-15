package com.example.datamanager.pojo.offlinestatus;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NewStudyEvent implements OfflineEvent {

	private String	studyIUID;
	private Date eventTime;
}
