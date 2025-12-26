package com.sms.studentManagement.controller;


import com.sms.studentManagement.dto.DepartmentDTO;
import com.sms.studentManagement.exception.DepartmentNotFoundException;
import com.sms.studentManagement.models.Department;
import com.sms.studentManagement.service.DepartmentService;
import com.sms.studentManagement.util.DepartmentConvertor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public List<DepartmentDTO> getDepartments(){
         List<Department> departments = departmentService.getDepartment();
        return DepartmentConvertor.toDTOList(departments);
    }

    @GetMapping("{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        return DepartmentConvertor.toDTO(department);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<?> handleDepartmentNotFound(DepartmentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
