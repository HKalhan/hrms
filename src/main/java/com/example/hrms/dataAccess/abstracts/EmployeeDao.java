package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee , Integer> {
    Employee getById(int id);
}
