package org.example.secvices;

import org.example.dto.EmployeeDTO;
import org.example.model.Employee;
import org.example.model.Position;
import org.example.repository.EmployeeRepository;
import org.example.secvices.interfaces.ILoginService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
@Service
public class LoginService implements ILoginService {
    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private static Logger logger = LoggerFactory.getLogger(LoginService.class);


    public LoginService(EmployeeRepository employeeRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public boolean registration(EmployeeDTO employeeDTO, Position position) {
        if (employeeRepository.existsEmployeeByLogin(employeeDTO.getLogin())) {
            logger.warn("Can`t create user with already exists login ({})",employeeDTO.getLogin());
            return false;
        }
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        employee.setPosition(Collections.singleton(position));
        employee.setPass(passwordEncoder.encode(employeeDTO.getPass()));
        employeeRepository.save(employee);
        logger.debug("New employee {} was added", employee);
        return true;
    }
}
