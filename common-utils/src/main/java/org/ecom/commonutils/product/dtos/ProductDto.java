package org.ecom.commonutils.product.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.ecom.commonutils.product.dtos.validator.CreateProductValidationGroup;

import java.util.Date;

public class ProductDto {

    private String productId;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(groups = CreateProductValidationGroup.class, message = "Product description is required")
    private String description;

    @NotNull
    private double price;

    private double discountedPrice;

    private long quantityAvailable;

    private Date dateAdded;

    private boolean live;

    private boolean inStock;

    private String productImageName;

    public ProductDto(String productId, String productName, String description, double price, double discountedPrice, long quantityAvailable, Date dateAdded, boolean live, boolean inStock, String productImageName) {
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

    public ProductDto() {
    }

    public String getProductId() {
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

    public void setProductId(String productId) {
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

    public String toString() {
        return "ProductDto(productId=" + this.getProductId() + ", productName=" + this.getProductName() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", discountedPrice=" + this.getDiscountedPrice() + ", quantityAvailable=" + this.getQuantityAvailable() + ", dateAdded=" + this.getDateAdded() + ", live=" + this.isLive() + ", inStock=" + this.isInStock() + ", productImageName=" + this.getProductImageName() + ")";
    }

//    private CategoryDto category;
}
