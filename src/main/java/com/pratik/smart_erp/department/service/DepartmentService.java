package com.pratik.smart_erp.department.service;

import com.pratik.smart_erp.department.entity.Department;
import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    void deleteDepartment(Long id);

    Department updateDepartment(
            Long id,
            Department department
    );
}