package com.example.datamanager;

import java.util.Arrays;
import java.util.Date;

import com.example.GLOBALS;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.datamanager.pojo.studies.Modality;
import com.example.datamanager.pojo.studies.StudiesInfo;
import com.example.datamanager.pojo.studies.StudyInfo;

@RestController
public class DatamanagerStudyController {

	// this is dirty => there should be a real StudyService
	public static StudiesInfo	studies;

	public DatamanagerStudyController() {
		studies = new StudiesInfo();
		studies.add(createFakeStudy(GLOBALS.STUDY_1_UUID));
		studies.add(createFakeStudy(GLOBALS.STUDY_3_UUID));
		studies.add(createFakeStudy(GLOBALS.STUDY_4_UUID));
	}

	@RequestMapping(value = "/datamanager/studies/{studyIUID}", method = RequestMethod.GET)
	public StudyInfo studies(@PathVariable String studyIUID) throws InterruptedException {
		StudyInfo study = studies.findByUid(studyIUID);
		return study;
	}

	@RequestMapping("/datamanager/studies")
	public StudiesInfo study() {
		return studies;
	}

	private StudyInfo createFakeStudy(String studyIUID) {
		StudyInfo studyInfo = new StudyInfo("patientName", "studyDescription", "patientId", studyIUID, new Date(), Arrays.asList(Modality.CT, Modality.MR), new Date());
		return studyInfo;
	}
}