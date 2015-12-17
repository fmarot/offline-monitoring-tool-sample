package com.example.datamanager;

import java.util.Arrays;
import java.util.Date;

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

	private int					studyIndex	= 0;

	public DatamanagerStudyController() {
		studies = new StudiesInfo();
		studies.add(createFakeStudy());
		studies.add(createFakeStudy());
		studies.add(createFakeStudy());
	}

	@RequestMapping(value = "/datamanager/studies/{studyIUID}", method = RequestMethod.GET)
	public StudyInfo studies(@PathVariable String studyIUID) {
		StudyInfo study = studies.findByUid(studyIUID);
		return study;
	}

	@RequestMapping("/datamanager/studies")
	public StudiesInfo study() {
		return studies;
	}

	private StudyInfo createFakeStudy() {
		StudyInfo studyInfo = new StudyInfo("patientName", "studyDescription", "patientId", "" + studyIndex, new Date(), Arrays.asList(Modality.CT, Modality.MR), new Date());
		studyIndex++;
		return studyInfo;
	}
}