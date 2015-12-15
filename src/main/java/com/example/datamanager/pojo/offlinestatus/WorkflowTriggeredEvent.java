package com.example.datamanager.pojo.offlinestatus;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

/** This class represents events created by end-users where they requested a specific WF to be run */
@AllArgsConstructor
@Data
public class WorkflowTriggeredEvent implements OfflineEvent {

	private String	studyIUID;
	private Date	eventTime;
	private String workflowName;
}
