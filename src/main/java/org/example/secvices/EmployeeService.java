package org.example.secvices;

import org.example.dto.EmployeeDTO;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.repository.EmployeeRepository;
import org.example.secvices.interfaces.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findEmployeeByLogin(username);
        if (employee == null) {
            logger.warn("User with login {} was`t found", username);
            throw new UsernameNotFoundException("User not found");
        } else {
            logger.debug("Found user with login {}", username);
        }
        return employee;
    }

    @Override
    @Transactional
    public Page<Employee> findAllEmployees(int pageNumber, String sortField, String sortDirection) {
        logger.info("Find employees on page: {}, sorted field: {}, sorted direction: {}", pageNumber, sortField, sortDirection);
        Sort sort = Sort.by(sortField);
        sort = (sortDirection.equals("ASC")) ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1, 5, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployeeById(int id) {
        logger.debug("Employee with id {} was removed", id);
        employeeRepository.deleteEmployeeByEmployeeId(id);
    }

    @Override
    public Employee findEmployeeById(int id) {
        logger.info("Try to find employee with id {}", id);
        return employeeRepository.findEmployeeByEmployeeId(id);
    }


}
