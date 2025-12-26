package com.sms.studentManagement.service;

import com.sms.studentManagement.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartment();

    Department getDepartmentById(Long id);

}
