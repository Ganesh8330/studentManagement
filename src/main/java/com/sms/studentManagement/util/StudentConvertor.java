package com.sms.studentManagement.util;

import com.sms.studentManagement.dto.StudentDTO;
import com.sms.studentManagement.models.Department;
import com.sms.studentManagement.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentConvertor {

    public static StudentDTO toDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudent_id());
        studentDTO.setStudentName(student.getStudent_name());
        studentDTO.setStudentEmail(student.getStudent_email());
        studentDTO.setDeptId(student.getDepartment().getDept_id());
        return studentDTO;
    }

    public static List<StudentDTO> toDTOList(List<Student> students){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s: students){
            studentDTOS.add(toDTO(s));
        }
        return studentDTOS;
    }

    public static Student toEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setStudent_name(studentDTO.getStudentName());
        student.setStudent_email(studentDTO.getStudentEmail());
        return student;
    }

}
