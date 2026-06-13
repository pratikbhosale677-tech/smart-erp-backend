package com.pratik.smart_erp.department.service;

import com.pratik.smart_erp.department.entity.Department;
import com.pratik.smart_erp.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentRepository departmentRepository) {

        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(
            Department department) {

        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));
    }

    @Override
    public void deleteDepartment(Long id) {

        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(
            Long id,
            Department department) {

        Department existing = departmentRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found"));

        existing.setName(department.getName());
        existing.setCode(department.getCode());

        return departmentRepository.save(existing);
    }
}