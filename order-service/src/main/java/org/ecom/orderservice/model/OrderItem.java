package org.ecom.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    private int quantity;

    private double totalPrice;

    private String productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
