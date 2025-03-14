package com.salarymanager.repository;

import com.salarymanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingOrEmailContainingOrDepartmentContaining(String name, String email, String department);
}