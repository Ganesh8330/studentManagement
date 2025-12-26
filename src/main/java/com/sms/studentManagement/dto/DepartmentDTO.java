package com.sms.studentManagement.dto;

public class DepartmentDTO {

    private Long departmentId;
    private String department_name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "department_id=" + departmentId +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
