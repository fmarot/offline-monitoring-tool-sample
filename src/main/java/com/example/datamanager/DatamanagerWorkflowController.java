package com.example.datamanager;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.datamanager.pojo.studies.StudyInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DatamanagerWorkflowController {

	private List<String>	workflows	= Arrays.asList("worflow_prostate", "workflow_breast");

	@RequestMapping("/datamanager/workflows")
	public List<String> workflows() {
		return workflows;
	}

	@RequestMapping(value = "datamanager/workflows/{workflowId}", method = RequestMethod.PUT)
	public StudyInfo updateStudent(@PathVariable String workflowId, @PathVariable String studyIUID) {
		log.info("Will launch WF {} on study {}", workflowId, studyIUID);
		// TODO start the WF
		StudyInfo study = DatamanagerStudyController.studies.findByUid(studyIUID);
		return study;
	}
}