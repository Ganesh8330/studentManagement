package com.sms.studentManagement.controller;

import com.sms.studentManagement.dto.StudentDTO;
import com.sms.studentManagement.exception.ApiResponse;
import com.sms.studentManagement.exception.StudentNotFoundException;
import com.sms.studentManagement.models.Student;
import com.sms.studentManagement.service.StudentService;
import com.sms.studentManagement.util.StudentConvertor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getStudents(){
        List<Student> students = studentService.getStudents();

        if (students.isEmpty()){
            throw  new StudentNotFoundException("Students not found");
        }

        return StudentConvertor.toDTOList(students);
    }

    @GetMapping("{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return StudentConvertor.toDTO(student);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Valid  @RequestBody StudentDTO studentDTO){
        studentService.createStudent(studentDTO);
        ApiResponse apiResponse = new ApiResponse("Inserted successfully",201, LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentDTO studentDTO,@PathVariable  Long id){
        studentService.updateStudent(studentDTO,id);
        ApiResponse apiResponse = new ApiResponse("Updated successfully",201,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        ApiResponse apiResponse = new ApiResponse("Deleted successfully",202,LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}


