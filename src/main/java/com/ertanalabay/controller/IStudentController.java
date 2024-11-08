package com.ertanalabay.controller;

import java.util.List;

import com.ertanalabay.entities.Student;

public interface IStudentController {

	public Student saveStudent(Student student);

	public List<Student> getAllStudents();
	
	public Student getStudentById(Long id);
	
	public void deleteStudent(Long id);
}
