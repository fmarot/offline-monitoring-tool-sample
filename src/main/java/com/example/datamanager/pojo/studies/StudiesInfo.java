package com.example.datamanager.pojo.studies;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class StudiesInfo {

	private List<StudyInfo>	studies	= new ArrayList<>();

	public void add(StudyInfo study) {
		studies.add(study);
	}

	public StudyInfo findByUid(String studyUid) {
		for (StudyInfo study : studies) {
			if (study.getStudyUId().equals(studyUid)) {
				return study;
			}
		}
		log.error("Study nor found uid={}", studyUid);
		return null;
	}
}
