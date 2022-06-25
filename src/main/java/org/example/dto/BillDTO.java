package org.example.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class BillDTO {
    private String body;
    private int amount;
    private int price;
}
