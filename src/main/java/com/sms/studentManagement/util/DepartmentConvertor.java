package com.sms.studentManagement.util;

import com.sms.studentManagement.dto.DepartmentDTO;
import com.sms.studentManagement.models.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentConvertor {

    public static List<DepartmentDTO> toDTOList(List<Department> department){
        List<DepartmentDTO> departmentDTOList = new ArrayList<DepartmentDTO>();
        for (Department dept: department){
            departmentDTOList.add(toDTO(dept));
        }
        return departmentDTOList;
    }

    public static DepartmentDTO toDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentId(department.getDept_id());
        departmentDTO.setDepartment_name(department.getDepartment_name());
        return departmentDTO;
    }

}
