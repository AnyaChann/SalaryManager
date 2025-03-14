package com.salarymanager;

import com.salarymanager.model.Employee;
import com.salarymanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        if (employeeRepository.count() == 0) {
            List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "john.doe@example.com", "Engineering", 60000, 30),
                new Employee("Jane Smith", "jane.smith@example.com", "Marketing", 55000, 28),
                new Employee("Alice Johnson", "alice.johnson@example.com", "HR", 50000, 25),
                new Employee("Bob Brown", "bob.brown@example.com", "Finance", 70000, 35),
                new Employee("Charlie Davis", "charlie.davis@example.com", "Engineering", 65000, 32),
                new Employee("Diana Evans", "diana.evans@example.com", "Marketing", 52000, 27),
                new Employee("Ethan Foster", "ethan.foster@example.com", "HR", 48000, 24),
                new Employee("Fiona Green", "fiona.green@example.com", "Finance", 72000, 36),
                new Employee("George Harris", "george.harris@example.com", "Engineering", 68000, 33),
                new Employee("Hannah White", "hannah.white@example.com", "Marketing", 53000, 29)
            );
            employeeRepository.saveAll(employees);
        }
    }
}