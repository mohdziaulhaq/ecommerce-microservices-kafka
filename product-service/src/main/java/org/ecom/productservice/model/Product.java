package org.ecom.productservice.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;

    private String productName;

    @Column(length = 10000)
    private String description;

    private double price;

    private double discountedPrice;

    private long quantityAvailable;

    private Date dateAdded;

    private boolean live;

    private boolean inStock;

    private String productImageName;

    public Product(UUID productId, String productName, String description, double price, double discountedPrice, long quantityAvailable, Date dateAdded, boolean live, boolean inStock, String productImageName) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.discountedPrice = discountedPrice;
        this.quantityAvailable = quantityAvailable;
        this.dateAdded = dateAdded;
        this.live = live;
        this.inStock = inStock;
        this.productImageName = productImageName;
    }

    public Product() {
    }

    public UUID getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public long getQuantityAvailable() {
        return this.quantityAvailable;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public boolean isLive() {
        return this.live;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public String getProductImageName() {
        return this.productImageName;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public void setQuantityAvailable(long quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
}
