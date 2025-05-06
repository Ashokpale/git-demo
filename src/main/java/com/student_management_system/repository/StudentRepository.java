package com.student_management_system.repository;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student_management_system.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	//String findByName(String name);
	
	List<String> findByName(String name);

	@Query("Select s from Student  s ")
	List<Student> queryAllStudents();
	
	
	List<Student> findByDepartment(String department);
	


}