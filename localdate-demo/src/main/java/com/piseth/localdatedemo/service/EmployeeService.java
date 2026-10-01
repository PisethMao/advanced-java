package com.piseth.localdatedemo.service;

import com.piseth.localdatedemo.domain.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EmployeeService {
    private final Map<Long, Employee> employees = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Employee create(Employee employee) {
        long id = idGenerator.incrementAndGet();
        employee.setId(id);
        if (employee.getJoinDate() == null) {
            employee.setJoinDate(LocalDate.now());
        }
        employees.put(id, employee);
        return employee;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    public Employee findById(Long id) {
        Employee employee = employees.get(id);
        if (employee == null) {
            throw new ResponseStatusException(NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    public int calculateAge(Long id) {
        Employee employee = findById(id);
        LocalDate birthday = employee.getDateOfBirth();
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today).getYears();
    }

    public long calculateWorkingDays(Long id) {
        Employee employee = findById(id);
        LocalDate joinDate = employee.getJoinDate();
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(joinDate, today);
    }

    public List<Employee> findByJoinDate(LocalDate date) {
        return employees.values().stream()
                .filter(employee -> employee.getJoinDate().equals(date)).toList();
    }
}
