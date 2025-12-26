package com.sms.studentManagement.repository;

import com.sms.studentManagement.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
