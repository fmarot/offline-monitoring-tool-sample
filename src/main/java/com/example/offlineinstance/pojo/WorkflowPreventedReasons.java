package com.example.offlineinstance.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorkflowPreventedReasons {

	private String			workflowName;
	/** list of the rules that prevented the workflow from being launched */
	private List<String>	unverifiedRules;
}
