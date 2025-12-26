package com.sms.studentManagement.repository;

import com.sms.studentManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
