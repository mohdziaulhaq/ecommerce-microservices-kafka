package org.ecom.productservice.service;

import org.ecom.productservice.dto.PageableResponse;
import org.ecom.productservice.dto.ProductDto;

import java.util.UUID;

public interface ProductService {

    //create
    ProductDto createProduct(ProductDto productDto);
    //update
    ProductDto updateProduct(ProductDto productDto, UUID productId);
    //delete
    void deleteProduct(UUID productId);
    //get single
    ProductDto getProduct(UUID productId);
    //get all
    PageableResponse<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, String sortDir);
    // get all : live
    PageableResponse<ProductDto> getAllLiveProducts(int pageNumber, int pageSize, String sortBy, String sortDir);
    //search
    PageableResponse<ProductDto> searchProducts(String subTitle,int pageNumber, int pageSize, String sortBy, String sortDir);

    //create product with category
//    ProductDto createProductWithCategory(ProductDto productDto, String categoryId);
//
//    ProductDto updateCategory(String productId, String categoryId);
//
//    PageableResponse<ProductDto> getAllProductsWithCategory(String categoryId,int pageNumber, int pageSize, String sortBy, String sortDir);
}
