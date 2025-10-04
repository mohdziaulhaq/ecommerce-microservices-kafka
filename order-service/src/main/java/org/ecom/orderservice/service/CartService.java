package org.ecom.orderservice.service;

//import com.zia.electronix.express.dtos.AddItemToCartRequest;
//import com.zia.electronix.express.dtos.CartDto;

import org.ecom.commonutils.order.dtos.AddItemToCartRequest;
import org.ecom.commonutils.order.dtos.CartDto;

public interface CartService {
    // add items to cart
    //case1: if cart is not available for the user then we create it to add items
    // case2: card is available: add items to cart

    CartDto addItemToCart(String userId, AddItemToCartRequest request);
//    void removeItemFromCart(String userId,int cartItemId);
//    void clearCart(String userId);
//    CartDto getCart(String userId);
}
