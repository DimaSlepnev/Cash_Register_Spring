package org.example.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "bill")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private int billId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Warehouse product;

    @NotEmpty(message = "Body can`t be empty")
    @Column(name = "body")
    private String body;

    @Min(value = 1, message = "amount must be grater than 0")
    @Column(name = "amount")
    private int amount;

    @Min(value = 0, message = "amount can`t be with minus sign")
    @Column(name = "price")
    private int price;

    @Column(name = "confirmation")
    private boolean confirmation;

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", product=" + product +
                ", body='" + body + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", confirmation=" + confirmation +
                '}';
    }
}
