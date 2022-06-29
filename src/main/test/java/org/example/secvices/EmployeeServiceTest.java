package org.example.secvices;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @Test
    void loadUserByUsername() {
        String login = "login";
        Employee employee = new Employee();
        employee.setLogin(login);
        doReturn(employee).when(employeeRepository).findEmployeeByLogin(login);
        UserDetails employee1 = employeeService.loadUserByUsername(login);
        verify(employeeRepository,times(1)).findEmployeeByLogin(login);
    }

    @Test
    void findAllEmployees() {
        List<Employee> employees = new ArrayList();
        doReturn(employees).when(employeeRepository).findAll();
        List<Employee> employeeList = employeeRepository.findAll();
        verify(employeeRepository,times(1)).findAll();
    }

    @Test
    void deleteEmployeeById() {
        doNothing().when(employeeRepository).deleteEmployeeByEmployeeId(0);
        employeeRepository.deleteEmployeeByEmployeeId(0);
        verify(employeeRepository,times(1)).deleteEmployeeByEmployeeId(0);
    }

    @Test
    void findEmployeeById() {
        Employee employee = new Employee();
        doReturn(employee).when(employeeRepository).findEmployeeByEmployeeId(0);
        Employee employee1 = employeeService.findEmployeeById(0);
        verify(employeeRepository,times(1)).findEmployeeByEmployeeId(0);
    }
}