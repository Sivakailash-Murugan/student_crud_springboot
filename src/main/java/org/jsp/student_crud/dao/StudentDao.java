package org.jsp.student_crud.dao;

import java.util.List;


import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public List<Student> findall() {
        return studentRepository.findAll();
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
