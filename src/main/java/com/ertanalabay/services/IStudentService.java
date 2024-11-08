package com.ertanalabay.services;

import java.util.List;

import com.ertanalabay.entities.Student;

public interface IStudentService {

	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(Long id);
	
	public void deleteStudent(Long id);
	
	public Student updateStudent(Long id, Student updateStudent);
}
