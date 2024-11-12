package com.ertanalabay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ertanalabay.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	 //BUralara kendş özel methotlarını yazabilirsin.
	/*
	// HQL sorgusu
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	*/
	// SQL sorgusu
	@Query(value = "SELECT * from student.student", nativeQuery = true)
	List<Student> findAllStudents();
	
}
