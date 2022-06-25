package org.example.secvices.interfaces;

import org.example.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeService extends UserDetailsService {
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    @Transactional
    public Page<Employee> findAllEmployees(int pageNumber, String sortField, String sortDirection);

    @Transactional
    public void deleteEmployeeById(int id);

    @Transactional
    public Employee findEmployeeById(int id);
}
