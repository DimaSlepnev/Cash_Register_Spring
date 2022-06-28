package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
@Setter
@Getter
@EqualsAndHashCode(of = {"productId"})
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="product_id")
    private int productId;

    @Column(name ="product")
    private String product;

    @Column(name ="amount")
    private int amount;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Override
    public String toString() {
        return "Warehouse{" +
                "productId=" + productId +
                ", product='" + product + '\'' +
                ", amount=" + amount +
                ", employee=" + employee +
                '}';
    }
}
