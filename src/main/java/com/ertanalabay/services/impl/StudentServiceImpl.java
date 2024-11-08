package com.ertanalabay.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ertanalabay.entities.Student;
import com.ertanalabay.repository.StudentRepository;
import com.ertanalabay.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}
	
	@Override
	public Student getStudentById(Long id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		
		/* Alternatif
		 * 
		Student dbStudent = getStudentById(id);
		if (dbStudent != null) {
			studentRepository.delete(dbStudent);
		}
		
		*/
		studentRepository.deleteById(id);
		
	}
}
