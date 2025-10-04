package org.ecom.orderservice.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    private String cartId;

    private Date createdAt;

    private String userId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();


    public Cart(String cartId, Date createdAt, String userId, List<CartItem> items) {
        this.cartId = cartId;
        this.createdAt = createdAt;
        this.userId = userId;
        this.items = items;
    }

    public Cart() {
    }

    public static CartBuilder builder() {
        return new CartBuilder();
    }

    public String getCartId() {
        return this.cartId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getUserId() {
        return this.userId;
    }

    public List<CartItem> getItems() {
        return this.items;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public static class CartBuilder {
        private String cartId;
        private Date createdAt;
        private String userId;
        private List<CartItem> items;

        CartBuilder() {
        }

        public CartBuilder cartId(String cartId) {
            this.cartId = cartId;
            return this;
        }

        public CartBuilder createdAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public CartBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public CartBuilder items(List<CartItem> items) {
            this.items = items;
            return this;
        }

        public Cart build() {
            return new Cart(this.cartId, this.createdAt, this.userId, this.items);
        }

        public String toString() {
            return "Cart.CartBuilder(cartId=" + this.cartId + ", createdAt=" + this.createdAt + ", userId=" + this.userId + ", items=" + this.items + ")";
        }
    }
}
