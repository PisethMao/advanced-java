package com.piseth.localdatedemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Employee {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;

    public Employee(Long id, String name, LocalDate dateOfBirth, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
    }

}
