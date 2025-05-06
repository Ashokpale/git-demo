package com.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student_management_system.entities.Student;
import com.student_management_system.repository.StudentRepository;
import com.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    //Use @RequestBody to map the incoming JSON to a Student object
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student); 
    }
    
    @PostMapping("/saveAllStudents")
    public List<Student> saveStudent(@RequestBody List<Student> students){
		return studentService.saveAllStudents(students);
    	
    }
    
    @GetMapping("/allStudents")
    public List<Student> getAll(){
		return studentService.getAllStudent();
    	
    }
    
    @GetMapping("/{id}")
    public Student findStudent(@PathVariable Long id) {
    	return studentService.studentfindById(id);
    }
    
    @GetMapping("/count")
    public long count() {
    	return studentService.studentCount();
    }
    
    
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student  student) {
    	return studentService.updateById(id,student);
    }
    
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
    
    @GetMapping("/status")
    public List<String> studentStatus(@RequestParam("name") String name) {
        return studentService.findStudentStatus(name);
    } 
    
    @GetMapping("/findAllSort")
    public List<Student> findAll(Sort id ){
    	return studentService.findAllstudents(id);
    }
    
    @GetMapping("queryAllstudents")
    public List<Student> allStudents(){
    	return studentRepository.queryAllStudents();
    }
    
}
