package org.ecom.commonutils.order.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDto {

    private String orderId;

    //PENDING, DISPATCHED, DELIVERED
    private String orderStatus = "PENDING";

    //NOT PAID, PAID
    private String paymentStatus = "NOT_PAID";

    private String billingName;

    private String billingPhone;

    private String billingAddress;

    private double orderAmount;

    private Date orderedDate;

    private Date expectedDeliveryDate;

    private Date deliveryDate;

    //    private UserDto user;
    private List<OrderItemDto> orderItems = new ArrayList<>();

    public OrderDto(String orderId, String orderStatus, String paymentStatus, String billingName, String billingPhone, String billingAddress, double orderAmount, Date orderedDate, Date expectedDeliveryDate, Date deliveryDate, List<OrderItemDto> orderItems) {
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
        this.orderItems = orderItems;
    }

    public OrderDto() {
    }

    public static OrderDtoBuilder builder() {
        return new OrderDtoBuilder();
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

    public List<OrderItemDto> getOrderItems() {
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

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        return "OrderDto(orderId=" + this.getOrderId() + ", orderStatus=" + this.getOrderStatus() + ", paymentStatus=" + this.getPaymentStatus() + ", billingName=" + this.getBillingName() + ", billingPhone=" + this.getBillingPhone() + ", billingAddress=" + this.getBillingAddress() + ", orderAmount=" + this.getOrderAmount() + ", orderedDate=" + this.getOrderedDate() + ", expectedDeliveryDate=" + this.getExpectedDeliveryDate() + ", deliveryDate=" + this.getDeliveryDate() + ", orderItems=" + this.getOrderItems() + ")";
    }

    public static class OrderDtoBuilder {
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
        private List<OrderItemDto> orderItems;

        OrderDtoBuilder() {
        }

        public OrderDtoBuilder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderDtoBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public OrderDtoBuilder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public OrderDtoBuilder billingName(String billingName) {
            this.billingName = billingName;
            return this;
        }

        public OrderDtoBuilder billingPhone(String billingPhone) {
            this.billingPhone = billingPhone;
            return this;
        }

        public OrderDtoBuilder billingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public OrderDtoBuilder orderAmount(double orderAmount) {
            this.orderAmount = orderAmount;
            return this;
        }

        public OrderDtoBuilder orderedDate(Date orderedDate) {
            this.orderedDate = orderedDate;
            return this;
        }

        public OrderDtoBuilder expectedDeliveryDate(Date expectedDeliveryDate) {
            this.expectedDeliveryDate = expectedDeliveryDate;
            return this;
        }

        public OrderDtoBuilder deliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public OrderDtoBuilder orderItems(List<OrderItemDto> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderDto build() {
            return new OrderDto(this.orderId, this.orderStatus, this.paymentStatus, this.billingName, this.billingPhone, this.billingAddress, this.orderAmount, this.orderedDate, this.expectedDeliveryDate, this.deliveryDate, this.orderItems);
        }

        public String toString() {
            return "OrderDto.OrderDtoBuilder(orderId=" + this.orderId + ", orderStatus=" + this.orderStatus + ", paymentStatus=" + this.paymentStatus + ", billingName=" + this.billingName + ", billingPhone=" + this.billingPhone + ", billingAddress=" + this.billingAddress + ", orderAmount=" + this.orderAmount + ", orderedDate=" + this.orderedDate + ", expectedDeliveryDate=" + this.expectedDeliveryDate + ", deliveryDate=" + this.deliveryDate + ", orderItems=" + this.orderItems + ")";
        }
    }
}
