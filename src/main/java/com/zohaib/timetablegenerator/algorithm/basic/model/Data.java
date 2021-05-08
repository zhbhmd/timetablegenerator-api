package com.zohaib.timetablegenerator.algorithm.basic.model;

import java.util.List;

public class Data {
	
	List<Course> courses;
	List<Slot> slots;
	List<Room> rooms;
	List<Teacher> teachers;
	List<StudentGroup> studentGroup;
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Slot> getSlots() {
		return slots;
	}
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<StudentGroup> getStudentGroup() {
		return studentGroup;
	}
	public void setStudentGroup(List<StudentGroup> studentGroup) {
		this.studentGroup = studentGroup;
	}
	
	
	
}
