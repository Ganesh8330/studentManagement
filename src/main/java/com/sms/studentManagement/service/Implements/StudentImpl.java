package com.sms.studentManagement.service.Implements;

import com.sms.studentManagement.dto.StudentDTO;
import com.sms.studentManagement.exception.DepartmentNotFoundException;
import com.sms.studentManagement.exception.StudentNotFoundException;
import com.sms.studentManagement.models.Department;
import com.sms.studentManagement.models.Student;
import com.sms.studentManagement.repository.DepartmentRepository;
import com.sms.studentManagement.repository.StudentRepository;
import com.sms.studentManagement.service.StudentService;
import com.sms.studentManagement.util.StudentConvertor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentImpl(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
    }

    @Override
    public Student createStudent(StudentDTO studentDTO) {
        Department department =  departmentRepository.findById(studentDTO.getDeptId()).orElseThrow(()->new DepartmentNotFoundException("Department not found: "+studentDTO.getDeptId()));
        Student student = StudentConvertor.toEntity(studentDTO);
        student.setDepartment(department);
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(StudentDTO studentDTO, Long id) {

        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found for the given id: "+id));
        student.setStudent_name(studentDTO.getStudentName());
        student.setStudent_email(studentDTO.getStudentEmail());

        if (studentDTO.getDeptId() !=null){
            Department department = departmentRepository.findById(studentDTO.getDeptId()).orElseThrow(()->new DepartmentNotFoundException("Department not found for the given department id: "+id));
            student.setDepartment(department);
        }

        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not found for the given id: "+id));
        studentRepository.delete(student);
    }
}
