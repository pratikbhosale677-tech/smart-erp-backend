package com.pratik.smart_erp.controller;

import com.pratik.smart_erp.entity.Employee;
import com.pratik.smart_erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // =========================
    // ADMIN ONLY - CREATE EMPLOYEE
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // =========================
    // ADMIN + USER - GET ALL EMPLOYEES
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // =========================
    // ADMIN + USER - GET EMPLOYEE BY ID
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // =========================
    // ADMIN ONLY - DELETE EMPLOYEE
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }

    // =========================
    // ADMIN + USER - SEARCH EMPLOYEES
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name) {
        return employeeService.searchEmployees(name);
    }

    // =========================
    // ADMIN ONLY - UPDATE EMPLOYEE
    // =========================
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    // =========================
    // ADMIN + USER - PAGINATION
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(
            @RequestParam int page,
            @RequestParam int size) {

        return employeeService.getEmployeesPaginated(page, size);
    }

    // =========================
    // ADMIN + USER - SORT
    // =========================
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/sort")
    public List<Employee> sortEmployees(@RequestParam String field) {
        return employeeService.sortEmployees(field);
    }
}