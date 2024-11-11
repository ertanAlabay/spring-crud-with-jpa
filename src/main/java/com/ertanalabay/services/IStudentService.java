package com.ertanalabay.services;

import java.util.List;

import com.ertanalabay.dto.DtoStudent;
import com.ertanalabay.dto.DtoStudentIU;

public interface IStudentService {

	public DtoStudent saveStudent(DtoStudentIU student);
	
	public List<DtoStudent> getAllStudents();
	
	public DtoStudent getStudentById(Long id);
	
	public void deleteStudent(Long id);
	
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
