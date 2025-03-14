package com.salarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salarymanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}