package com.piseth.localdatedemo.controller;

import com.piseth.localdatedemo.domain.Employee;
import com.piseth.localdatedemo.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/{id}/age")
    public Map<String, Object> getAge(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        int age = employeeService.calculateAge(id);
        return Map.of(
                "employeeId", id,
                "name", employee.getName(),
                "dateOfBirth", employee.getDateOfBirth(),
                "age", age
        );
    }

    @GetMapping("/{id}/work-duration")
    public Map<String, Object> getWorkingDuration(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        long days = employeeService.calculateWorkingDays(id);
        return Map.of(
                "employeeId", id,
                "name", employee.getName(),
                "joinDate", employee.getJoinDate(),
                "workingDays", days
        );
    }

    @GetMapping("/joined-on")
    public List<Employee> findByJoinDate(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date
    ) {
        return employeeService.findByJoinDate(date);
    }
}
