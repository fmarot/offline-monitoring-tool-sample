package com.example.offlineinstance.pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WaitingQueueItem {

	private StudyLink	studyLink;
	private Date		timeOfAddition;
	/** may be null in case of automatic action triggered on new study event */
	private String		workflow;
}
