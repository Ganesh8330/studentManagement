package com.sms.studentManagement.service;

import com.sms.studentManagement.dto.StudentDTO;
import com.sms.studentManagement.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudentById(Long id);

    Student createStudent(StudentDTO studentDTO);

    Student updateStudent(StudentDTO studentDTO, Long id);
    void deleteStudent(Long id);

}
