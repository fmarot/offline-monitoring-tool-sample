package com.example.offlineinstance.pojo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProcessedQueueItem extends WaitingQueueItem {

	public ProcessedQueueItem(StudyInfo studyInfo, Date timeOfAddition,
			String workflow, Date timeOfProcessed,
			Boolean result, String resultInfo,
			List<ProcessingParameters> processingParameters) {
		super(studyInfo, timeOfAddition, workflow);
		this.timeOfProcessed = timeOfProcessed;
		this.result = result;
		this.resultInfo = resultInfo;
		this.processingParameters = processingParameters;
	}

	private Date						timeOfProcessed;
	/** true in case of everything went as expected, false in case of any problem */
	private Boolean						result;
	/** in case of result=false, this may be used to display additionnal parameters explaining the problem */
	private String						resultInfo;

	private List<ProcessingParameters>	processingParameters;

}
