package com.viraj.sample.service;

import com.viraj.sample.entity.Employee;
import com.viraj.sample.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setEmployeeName("John Doe");
        employee.setEmployeeDescription("IT");
    }

    @Test
    void saveEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee savedEmployee = employeeService.saveEmployee(employee);

        assertNotNull(savedEmployee);
        assertEquals("John Doe", savedEmployee.getEmployeeName());
    }

    @Test
    void updateEmployee() {
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);

        Employee updatedEmployee = employeeService.updateEmployee(employee);

        assertNotNull(updatedEmployee);
        assertEquals("John Doe", updatedEmployee.getEmployeeName());
    }

    @Test
    void getAllEmployees() {
        List<Employee> employeeList = Arrays.asList(employee);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(1, employees.size());
        assertEquals("John Doe", employees.get(0).getEmployeeName());
    }

    @Test
    void getEmployee() {
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee fetchedEmployee = employeeService.getEmployee(1L);

        assertNotNull(fetchedEmployee);
        assertEquals("John Doe", fetchedEmployee.getEmployeeName());
    }

    @Test
    void deleteEmployee() {
        Mockito.doNothing().when(employeeRepository).deleteById(1L);

        assertDoesNotThrow(() -> employeeService.deleteEmployee(1L));

        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(1L);
    }
}
