package com.ertanalabay.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ertanalabay.dto.DtoStudent;
import com.ertanalabay.dto.DtoStudentIU;
import com.ertanalabay.entities.Student;
import com.ertanalabay.repository.StudentRepository;
import com.ertanalabay.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
		
		DtoStudent response = new DtoStudent();
		Student student = new Student();
		BeanUtils.copyProperties(dtoStudentIU, student);
		
		Student dbStudent = studentRepository.save(student);
		BeanUtils.copyProperties(dbStudent, response);
		return response;
	}
	
	@Override
	public List<DtoStudent> getAllStudents() {
		
		// dtoList adında bi liste oluşturur. 
		// Bu listeye Bean yardımıyla Student clasındaki verileri foreach'le ekler.
		// En son da listeyi(dtoList) döner.
		List<DtoStudent> dtoList = new ArrayList<>();
		
		List<Student> studentList = studentRepository.findAll();
		for (Student student : studentList) {
			DtoStudent dto = new DtoStudent();
			BeanUtils.copyProperties(student, dto);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	@Override
	public DtoStudent getStudentById(Long id) {
		DtoStudent dto = new DtoStudent();
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			Student dbStudent =  optional.get();
			
			BeanUtils.copyProperties(dbStudent, dto);
		}
		return dto;
	}

	@Override
	public void deleteStudent(Long id) {
		
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			studentRepository.delete(optional.get());
		}
		
	}

	@Override
	public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU) {

		DtoStudent dto = new DtoStudent();
		
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student dbStudent = optional.get();
			
			dbStudent.setFirstName(dtoStudentIU.getFirstName());
			dbStudent.setLastName(dtoStudentIU.getLastName());
			dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
		
			Student updatedStudent = studentRepository.save(dbStudent);
			
			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}
		return null;
	}
}
