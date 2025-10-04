package org.ecom.orderservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;

    //PENDING, DISPATCHED, DELIVERED
    private String orderStatus;

    //NOT PAID, PAID
    private String paymentStatus;
    private String billingName;
    private String billingPhone;
    private String billingAddress;

    private double orderAmount;
    private Date orderedDate;

    private Date expectedDeliveryDate;

    private Date deliveryDate;

    private String userId;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(String orderId, String orderStatus, String paymentStatus, String billingName, String billingPhone, String billingAddress, double orderAmount, Date orderedDate, Date expectedDeliveryDate, Date deliveryDate, String userId, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.billingName = billingName;
        this.billingPhone = billingPhone;
        this.billingAddress = billingAddress;
        this.orderAmount = orderAmount;
        this.orderedDate = orderedDate;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.deliveryDate = deliveryDate;
        this.userId = userId;
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getBillingName() {
        return this.billingName;
    }

    public String getBillingPhone() {
        return this.billingPhone;
    }

    public String getBillingAddress() {
        return this.billingAddress;
    }

    public double getOrderAmount() {
        return this.orderAmount;
    }

    public Date getOrderedDate() {
        return this.orderedDate;
    }

    public Date getExpectedDeliveryDate() {
        return this.expectedDeliveryDate;
    }

    public Date getDeliveryDate() {
        return this.deliveryDate;
    }

    public String getUserId() {
        return this.userId;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public void setBillingPhone(String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static class OrderBuilder {
        private String orderId;
        private String orderStatus;
        private String paymentStatus;
        private String billingName;
        private String billingPhone;
        private String billingAddress;
        private double orderAmount;
        private Date orderedDate;
        private Date expectedDeliveryDate;
        private Date deliveryDate;
        private String userId;
        private List<OrderItem> orderItems;

        OrderBuilder() {
        }

        public OrderBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public OrderBuilder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public OrderBuilder billingName(String billingName) {
            this.billingName = billingName;
            return this;
        }

        public OrderBuilder billingPhone(String billingPhone) {
            this.billingPhone = billingPhone;
            return this;
        }

        public OrderBuilder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public OrderBuilder orderAmount(double orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public OrderBuilder orderedDate(Date orderedDate) {
            this.orderedDate = orderedDate;
            return this;
        }

        public OrderBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public OrderBuilder deliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public OrderBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public OrderBuilder orderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Order build() {
            return new Order(this.orderId, this.orderStatus, this.paymentStatus, this.billingName, this.billingPhone, this.billingAddress, this.orderAmount, this.orderedDate, this.expectedDeliveryDate, this.deliveryDate, this.userId, this.orderItems);
        }

        public String toString() {
            return "Order.OrderBuilder(orderId=" + this.orderId + ", orderStatus=" + this.orderStatus + ", paymentStatus=" + this.paymentStatus + ", billingName=" + this.billingName + ", billingPhone=" + this.billingPhone + ", billingAddress=" + this.billingAddress + ", orderAmount=" + this.orderAmount + ", orderedDate=" + this.orderedDate + ", expectedDeliveryDate=" + this.expectedDeliveryDate + ", deliveryDate=" + this.deliveryDate + ", userId=" + this.userId + ", orderItems=" + this.orderItems + ")";
        }
    }
}
