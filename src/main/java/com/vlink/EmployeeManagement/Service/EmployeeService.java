package com.vlink.EmployeeManagement.Service;

import com.vlink.EmployeeManagement.Entity.Employee;
import com.vlink.EmployeeManagement.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Employee createEmployee(Employee employee) { return repository.save(employee); }
    public Employee getEmployeeById(Long id) { return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found")); }
    public List<Employee> getAllEmployees() { return repository.findAll(); }

    @Transactional
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setDepartment(updatedEmployee.getDepartment());
        return repository.save(employee);
    }

    @Transactional
    public void deleteEmployee(Long id) { repository.deleteById(id); }
}
