package org.example.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class EmployeeDTO {
    private String firstName;
    private String secondName;
    private String login;
    private String pass;
}
