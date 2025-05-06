package com.student_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.student_management_system.entities.Student;
import com.student_management_system.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public Student saveStudent(Student student) {

		return repository.save(student);

	}


	public List<Student> saveAllStudents(List<Student> students) {
	  
	        return repository.saveAll(students);
	   
	}


	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	public Student studentfindById(Long id) {
		
		return repository.findById(id).orElse(null);
	}


	public long studentCount() {
		return repository.count();
	}

	public Student updateById(Long id, Student student) {
		
	    Student studentExists = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
	    studentExists.setName(student.getName());
	    studentExists.setEmail(student.getEmail());
	    studentExists.setGender(student.getGender());
	    studentExists.setCourse(student.getCourse());
	    studentExists.setDepartment(student.getDepartment());
	    studentExists.setAge(student.getAge());
	    studentExists.setGpa(student.getGpa());
	    studentExists.setStatus(student.getStatus());
	    studentExists.setEnrollmentYear(student.getEnrollmentYear());

	    return repository.save(studentExists);
	}
	

	public void deleteStudentById(Long id) {
//		if((repository.existsById(id)) || (!repository.existsById(id)))
		 
				if(repository.existsById(id)) {
					System.out.println("Student found :" + id);
					repository.deleteById(id);
					System.out.println("Student deleted Successfully" );
				}
				else {
					System.out.println("Student alredy deleted id:" +id);
				}
				
	}

	public List<String> findStudentStatus(String name) {
		return repository.findByName(name);
		}


	public List<Student> findAllstudents(Sort id) {
		return repository.findAll(id);
	}


	


	public List<Student> getDepartment(String department) {
		
		return repository.getDepartment(department);
	}
	
	
}

	

