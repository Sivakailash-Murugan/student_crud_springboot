package org.jsp.student_crud.service;

import java.util.List;

import org.jsp.student_crud.dao.StudentDao;
import org.jsp.student_crud.dto.Student;
import org.jsp.student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public ResponseStructure<Student> save(Student student) {
        int totalMarks = student.getEnglish() + student.getMaths() + student.getScience();
        double percentage = totalMarks / 3.0;
        student.setPercentage(percentage);
        if (percentage < 35 || student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
            student.setResult("fail");
        } else if (percentage > 35 && percentage < 60) {
            student.setResult("secondclass");
        } else if (percentage > 60 && percentage < 85) {
            student.setResult("firstclass");
        } else if (percentage >= 85) {
            student.setResult("distinction");
        }

        ResponseStructure<Student> structure = new ResponseStructure<>();
        structure.setData(studentDao.save(student));
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Student saved successfully");
        return structure;

    }

    public ResponseStructure<List<Student>> saveStudents(List<Student> students) {

        for (Student student : students) {
            int totalMarks = student.getEnglish() + student.getMaths() + student.getScience();
            double percentage = totalMarks / 3.0;
            student.setPercentage(percentage);
            if (percentage < 35 || student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
                student.setResult("fail");
            } else if (percentage > 35 && percentage < 60) {
                student.setResult("secondclass");
            } else if (percentage > 60 && percentage < 85) {
                student.setResult("firstclass");
            } else if (percentage >= 85) {
                student.setResult("distinction");
            }

        }
        ResponseStructure<List<Student>> structure = new ResponseStructure<>();
        structure.setData(studentDao.saveStudents(students));
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Student saved successfully");
        return structure;
    }

    public ResponseStructure<List<Student>> findAll() {
       List<Student> list=studentDao.findall();
       if(list.isEmpty())
       {
        ResponseStructure<List<Student>> structure = new ResponseStructure<>();
        structure.setData(list);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Data Found");
        return structure;
       }
       else{
        ResponseStructure<List<Student>> structure = new ResponseStructure<>();
        structure.setData(null);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Data Not Found");
        return structure;
       }
    }

    public ResponseStructure<Student> findById(int id) {
        Student student =studentDao.findById(id);
        if (student==null) {
        ResponseStructure<Student> structure = new ResponseStructure<>();
        structure.setData(null);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Data Not found");
        return structure;
    }
    else
    {
        ResponseStructure<Student> structure = new ResponseStructure<>();
        structure.setData(student);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Data found");
        return structure;
    }
        }
        

}
