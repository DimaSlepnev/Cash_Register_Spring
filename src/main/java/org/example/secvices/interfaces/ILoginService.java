package org.example.secvices.interfaces;

import org.example.dto.EmployeeDTO;
import org.example.model.Position;
import org.springframework.transaction.annotation.Transactional;

public interface ILoginService {
    @Transactional
    public boolean registration(EmployeeDTO employeeDTO, Position position);
}
