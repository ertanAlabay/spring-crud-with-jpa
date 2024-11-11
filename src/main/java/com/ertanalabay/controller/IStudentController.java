package com.ertanalabay.controller;

import java.util.List;

import com.ertanalabay.dto.DtoStudent;
import com.ertanalabay.dto.DtoStudentIU;

public interface IStudentController {

	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Long id);
	
	public void deleteStudent(Long id);
	
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
