package com.salarymanager.repository;

import com.salarymanager.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNameContainingOrEmailContainingOrDepartmentContaining(String name, String email, String department, Pageable pageable);
}