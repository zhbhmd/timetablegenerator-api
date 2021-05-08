package com.zohaib.timetablegenerator.algorithm.basic.model;

import java.util.List;

public class Course {
	String code;
	String name;
	String teacher;
	List<String> studentGroups;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public List<String> getStudentGroups() {
		return studentGroups;
	}
	public void setStudentGroups(List<String> studentGroups) {
		this.studentGroups = studentGroups;
	}

}