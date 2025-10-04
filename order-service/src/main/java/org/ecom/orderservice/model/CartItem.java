package org.ecom.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    private String productId;

    private int quantity;

    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public CartItem(int cartItemId, String productId, int quantity, double totalPrice, Cart cart) {
        this.cartItemId = cartItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.cart = cart;
    }

    public CartItem() {
    }

    public static CartItemBuilder builder() {
        return new CartItemBuilder();
    }

    public int getCartItemId() {
        return this.cartItemId;
    }

    public String getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public static class CartItemBuilder {
        private int cartItemId;
        private String productId;
        private int quantity;
        private double totalPrice;
        private Cart cart;

        CartItemBuilder() {
        }

        public CartItemBuilder cartItemId(int cartItemId) {
            this.cartItemId = cartItemId;
            return this;
        }

        public CartItemBuilder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public CartItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItemBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public CartItemBuilder cart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public CartItem build() {
            return new CartItem(this.cartItemId, this.productId, this.quantity, this.totalPrice, this.cart);
        }

        public String toString() {
            return "CartItem.CartItemBuilder(cartItemId=" + this.cartItemId + ", productId=" + this.productId + ", quantity=" + this.quantity + ", totalPrice=" + this.totalPrice + ", cart=" + this.cart + ")";
        }
    }
}
