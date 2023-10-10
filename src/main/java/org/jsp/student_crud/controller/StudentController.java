package org.jsp.student_crud.controller;

import java.util.List;

import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.jsp.student_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<ResponseStructure<Student>> save(@RequestBody Student student) {
        return new ResponseEntity<ResponseStructure<Student>>(studentService.save(student), HttpStatus.CREATED);
    }

    @PostMapping("/students/many")
    public ResponseEntity<ResponseStructure<List<Student>>> saveStudentMany(@RequestBody List<Student> student) {
        return new ResponseEntity<ResponseStructure<List<Student>>>(studentService.saveStudents(student),
                HttpStatus.CREATED);
    }

     @GetMapping("/students")
     public ResponseEntity<ResponseStructure<List<Student>>> findAll(){
        return new ResponseEntity<ResponseStructure<List<Student>>>(studentService.findAll(), HttpStatus.OK);
        
     }

     @GetMapping("/students/id")
     public ResponseEntity<ResponseStructure<Student>> findById(@RequestParam int id) {
        return new ResponseEntity<ResponseStructure<Student>>(studentService.findById(id), HttpStatus.OK);
     }
}
