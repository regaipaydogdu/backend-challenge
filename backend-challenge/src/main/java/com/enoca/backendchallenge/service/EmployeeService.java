package com.enoca.backendchallenge.service;

import com.enoca.backendchallenge.dto.EmployeeDto;
import com.enoca.backendchallenge.dto.request.CreateEmployeeRequest;
import com.enoca.backendchallenge.exception.AlreadyExistsException;
import com.enoca.backendchallenge.exception.NotFoundException;
import com.enoca.backendchallenge.model.Company;
import com.enoca.backendchallenge.model.Employee;
import com.enoca.backendchallenge.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.enoca.backendchallenge.dto.mapper.EmployeeDtoConverter.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final CompanyService companyService;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyService companyService) {
        this.employeeRepository = employeeRepository;
        this.companyService = companyService;
    }

    public List<EmployeeDto> getEmployeeList() {
        return mapEmployeeListToEmployeeDtoList(employeeRepository.findAll());
    }

    public EmployeeDto getEmployee(Long identityNumber) {
        return mapEmployeeToEmployeeDto(employeeRepository.findEmployeeByIdentityNumber(identityNumber)
                .orElseThrow(() -> new NotFoundException("Employee Not Found.")));
    }

    public EmployeeDto createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Optional<Employee> employee = employeeRepository.findEmployeeByIdentityNumber(createEmployeeRequest.getIdentityNumber());

        if (employee.isPresent())
            throw new AlreadyExistsException("Employee Already Exists.");

        Company company = companyService.findCompanyById(createEmployeeRequest.getCompanyId());
        Employee mappedEmployee = mapEmployeeDtoToEmployee(createEmployeeRequest, company);

        return mapEmployeeToEmployeeDto(employeeRepository.save(mappedEmployee));
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = findEmployeeById(id);
        Company company = companyService.getCompanyByName(employeeDto.getCompanyName());

        Employee updatedEmployee = new Employee(
                employee.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getIdentityNumber(),
                company
        );

        return mapEmployeeToEmployeeDto(employeeRepository.save(updatedEmployee));
    }

    public void deleteEmployeeById(Long id) {
        findEmployeeById(id);
        employeeRepository.deleteById(id);
    }

    protected Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee Not Found."));
    }
}
