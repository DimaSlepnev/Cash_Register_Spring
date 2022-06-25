package org.example.repository;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, PagingAndSortingRepository<Employee,Long> {
    boolean existsEmployeeByLogin(@Param("login") String login);
    Employee findEmployeeByLogin(String login);

    void deleteEmployeeByEmployeeId(int id);

    Employee findEmployeeByEmployeeId(int id);

}
