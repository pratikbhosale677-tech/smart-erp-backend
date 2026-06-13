package com.pratik.smart_erp.service;

import com.pratik.smart_erp.entity.Employee;
import com.pratik.smart_erp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public String deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }
    public List<Employee> searchEmployees(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }
    public Page<Employee> getEmployeesPaginated(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable);
    }
    public List<Employee> sortEmployees(String field) {
        return employeeRepository.findAll(Sort.by(field));
    }
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setaddress(employee.getaddress());
            existingEmployee.setmobileNo(employee.getmobileNo());
            existingEmployee.setexperience(employee.getexperience());
            existingEmployee.setqualification(employee.getqualification());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }
}