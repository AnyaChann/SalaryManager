package com.salarymanager.controller;

import com.salarymanager.model.Employee;
import com.salarymanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(Model model, @RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "page", defaultValue = "0") int page,
                                @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employeePage;
        if (keyword != null && !keyword.isEmpty()) {
            employeePage = employeeService.searchEmployees(keyword, pageable);
        } else {
            employeePage = employeeService.getAllEmployees(pageable);
        }
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("keyword", keyword);
        return "employees";
    }

    @GetMapping("/search")
    @ResponseBody
    public Page<Employee> searchEmployees(@RequestParam("keyword") String keyword,
                                          @RequestParam(value = "page", defaultValue = "0") int page,
                                          @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeService.searchEmployees(keyword, pageable);
    }

    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}