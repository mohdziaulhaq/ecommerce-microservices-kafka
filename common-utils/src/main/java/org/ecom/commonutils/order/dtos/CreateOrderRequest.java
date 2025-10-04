package org.ecom.commonutils.order.dtos;

import jakarta.validation.constraints.NotBlank;

public class CreateOrderRequest {

    @NotBlank(message = "Cart ID is required")
    private String cartId;

    @NotBlank(message = "User ID is required")
    private String userId;
    private String orderStatus = "PENDING";
    private String paymentStatus = "NOT_PAID";

    @NotBlank(message = "Name is required")
    private String billingName;

    @NotBlank(message = "Address is required")
    private String billingAddress;

    @NotBlank(message = "Phone is required")
    private String billingPhone;

    public CreateOrderRequest(@NotBlank(message = "Cart ID is required") String cartId, @NotBlank(message = "User ID is required") String userId, String orderStatus, String paymentStatus, @NotBlank(message = "Name is required") String billingName, @NotBlank(message = "Address is required") String billingAddress, @NotBlank(message = "Phone is required") String billingPhone) {
        this.cartId = cartId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.billingName = billingName;
        this.billingAddress = billingAddress;
        this.billingPhone = billingPhone;
    }

    public CreateOrderRequest() {
    }

    public static CreateOrderRequestBuilder builder() {
        return new CreateOrderRequestBuilder();
    }

    public @NotBlank(message = "Cart ID is required") String getCartId() {
        return this.cartId;
    }

    public @NotBlank(message = "User ID is required") String getUserId() {
        return this.userId;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public @NotBlank(message = "Name is required") String getBillingName() {
        return this.billingName;
    }

    public @NotBlank(message = "Address is required") String getBillingAddress() {
        return this.billingAddress;
    }

    public @NotBlank(message = "Phone is required") String getBillingPhone() {
        return this.billingPhone;
    }

    public void setCartId(@NotBlank(message = "Cart ID is required") String cartId) {
        this.cartId = cartId;
    }

    public void setUserId(@NotBlank(message = "User ID is required") String userId) {
        this.userId = userId;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setBillingName(@NotBlank(message = "Name is required") String billingName) {
        this.billingName = billingName;
    }

    public void setBillingAddress(@NotBlank(message = "Address is required") String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setBillingPhone(@NotBlank(message = "Phone is required") String billingPhone) {
        this.billingPhone = billingPhone;
    }

    public static class CreateOrderRequestBuilder {
        private @NotBlank(message = "Cart ID is required") String cartId;
        private @NotBlank(message = "User ID is required") String userId;
        private String orderStatus;
        private String paymentStatus;
        private @NotBlank(message = "Name is required") String billingName;
        private @NotBlank(message = "Address is required") String billingAddress;
        private @NotBlank(message = "Phone is required") String billingPhone;

        CreateOrderRequestBuilder() {
        }

        public CreateOrderRequestBuilder cartId(@NotBlank(message = "Cart ID is required") String cartId) {
            this.cartId = cartId;
            return this;
        }

        public CreateOrderRequestBuilder userId(@NotBlank(message = "User ID is required") String userId) {
            this.userId = userId;
            return this;
        }

        public CreateOrderRequestBuilder orderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public CreateOrderRequestBuilder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public CreateOrderRequestBuilder billingName(@NotBlank(message = "Name is required") String billingName) {
            this.billingName = billingName;
            return this;
        }

        public CreateOrderRequestBuilder billingAddress(@NotBlank(message = "Address is required") String billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        public CreateOrderRequestBuilder billingPhone(@NotBlank(message = "Phone is required") String billingPhone) {
            this.billingPhone = billingPhone;
            return this;
        }

        public CreateOrderRequest build() {
            return new CreateOrderRequest(this.cartId, this.userId, this.orderStatus, this.paymentStatus, this.billingName, this.billingAddress, this.billingPhone);
        }

        public String toString() {
            return "CreateOrderRequest.CreateOrderRequestBuilder(cartId=" + this.cartId + ", userId=" + this.userId + ", orderStatus=" + this.orderStatus + ", paymentStatus=" + this.paymentStatus + ", billingName=" + this.billingName + ", billingAddress=" + this.billingAddress + ", billingPhone=" + this.billingPhone + ")";
        }
    }
}
