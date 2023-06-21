package com.enoca.backendchallenge.dto.mapper;

import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.request.CreateEmployeeRequest;
import com.enoca.backendchallenge.model.Company;
import com.enoca.backendchallenge.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeDtoConverter {
    public static Employee mapEmployeeDtoToEmployee(CreateEmployeeRequest employeeRequest, Company company) {
        return new Employee(
                employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getIdentityNumber(),
                company
        );
    }

    public static List<EmployeeDto> mapEmployeeListToEmployeeDtoList(List<Employee> employeeList) {
        return employeeList.stream().map(EmployeeDtoConverter::mapEmployeeToEmployeeDto).collect(Collectors.toList());
    }

    public static EmployeeDto mapEmployeeToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getIdentityNumber(),
                employee.getCompanyId().getName()
        );
    }
}
