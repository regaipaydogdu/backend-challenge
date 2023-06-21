package com.enoca.backendchallenge.controller;

import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.request.CreateEmployeeRequest;
import com.enoca.backendchallenge.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeeList() {
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @GetMapping("/{identityNumber}")
    public ResponseEntity<EmployeeDto> getEmployeeList(@PathVariable Long identityNumber) {
        return ResponseEntity.ok(employeeService.getEmployee(identityNumber));
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return new ResponseEntity<>(employeeService.createEmployee(createEmployeeRequest), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
