package com.example.restapi.Controller;

import com.example.restapi.Model.Employee;
import com.example.restapi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService empService;


    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee emp){
        return empService.createEmployee(emp);
    }

    @GetMapping(value = "/employees")
    public List<Employee> getEmployees(){
        return empService.getEmployees();
    }

    @PutMapping(value = "/employees/{empId}")
    public Employee editEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails){
        return empService.updateEmployee(id, empDetails );
    }

    @DeleteMapping(value = "/employees/{empId}")
    public void deleteEmployee(@PathVariable(value = "empId") Long id){
        empService.deleteEmployee(id);
    }


}

