package org.ecom.orderservice.model;

import jakarta.persistence.*;

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

    public OrderItem(int orderItemId, int quantity, double totalPrice, String productId, Order order) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productId = productId;
        this.order = order;
    }

    public OrderItem() {
    }

    public static OrderItemBuilder builder() {
        return new OrderItemBuilder();
    }

    public int getOrderItemId() {
        return this.orderItemId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public String getProductId() {
        return this.productId;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static class OrderItemBuilder {
        private int orderItemId;
        private int quantity;
        private double totalPrice;
        private String productId;
        private Order order;

        OrderItemBuilder() {
        }

        public OrderItemBuilder orderItemId(int orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public OrderItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public OrderItemBuilder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public OrderItemBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this.orderItemId, this.quantity, this.totalPrice, this.productId, this.order);
        }

        public String toString() {
            return "OrderItem.OrderItemBuilder(orderItemId=" + this.orderItemId + ", quantity=" + this.quantity + ", totalPrice=" + this.totalPrice + ", productId=" + this.productId + ", order=" + this.order + ")";
        }
    }
}
