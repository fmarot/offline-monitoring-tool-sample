package com.example.offlineinstance.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


/** Some parameters involved in the computation of:<br>
 * - the workflow choice<br>
 * - or at the start of an Offline workflow.<br> 
 * Having those parameters afterward may help debugging or understanding a strange behavior */
@AllArgsConstructor
@Data
public class ProcessingParameters {

	/** For each Workflow that was not chosen to be run, the reasons why it was not run.
	 * May be empty in the case of offline WF triggered manually */
	private List<WorkflowPreventedReasons>	workflowPreventedReasons;

	/** list of the available series at the time of deciding which workflow will be executed.
	 * If the upload is incomplete, we will see here an unexpected number of Series or images */
	private List<SeriesInfo>				availableSeries;

}
