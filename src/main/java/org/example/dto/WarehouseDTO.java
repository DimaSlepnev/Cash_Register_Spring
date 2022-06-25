package org.example.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class WarehouseDTO {
    private String product;
    private int amount;
}
