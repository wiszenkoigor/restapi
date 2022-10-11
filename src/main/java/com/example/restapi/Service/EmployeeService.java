package com.example.restapi.Service;

import com.example.restapi.Model.Employee;
import com.example.restapi.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepository;

    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }

    public void deleteEmployee(Long empId) {
        empRepository.deleteById(empId);
    }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee e = empRepository.findById(empId).get();
        e.setFirstName(employeeDetails.getFirstName());
        e.setLastName(employeeDetails.getLastName());
        e.setEmailId(employeeDetails.getEmailId());

        return empRepository.save(e);
    }
}
