package com.sms.studentManagement.service.Implements;

import com.sms.studentManagement.exception.DepartmentNotFoundException;
import com.sms.studentManagement.models.Department;
import com.sms.studentManagement.repository.DepartmentRepository;
import com.sms.studentManagement.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found for the given id: "+id));
    }
}
