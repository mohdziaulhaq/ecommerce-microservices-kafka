package org.ecom.orderservice.controller;

import org.ecom.commonutils.order.dtos.AddItemToCartRequest;
import org.ecom.commonutils.order.dtos.CartDto;
import org.ecom.orderservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;


    @PostMapping("/{username}")
    public ResponseEntity<CartDto> addItemToCart(
            @PathVariable String username,
            @RequestBody AddItemToCartRequest request) {
        CartDto cartDto = cartService.addItemToCart(username,request);
        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<CartDto> GetAllItemsFromCart(
//            @PathVariable String userId) {
//        CartDto cartDto = cartService.getCart(userId);
//        return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{userId}/items/{itemId}")
//    public ResponseEntity<ApiResponseMessage> removeItemFromCart(
//            @PathVariable String userId,
//            @PathVariable int itemId
//    ){
//        cartService.removeItemFromCart(userId,itemId);
//        ApiResponseMessage response = ApiResponseMessage.builder().message("Removed item from Cart").success(true).status(HttpStatus.OK).build();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<ApiResponseMessage> clearCart(
//            @PathVariable String userId
//    ){
//        cartService.clearCart(userId);
//        ApiResponseMessage response = ApiResponseMessage.builder().message("Cart cleared").success(true).status(HttpStatus.OK).build();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
