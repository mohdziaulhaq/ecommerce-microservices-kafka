package org.ecom.orderservice.service;

import org.ecom.commonutils.order.dtos.CreateOrderRequest;
import org.ecom.commonutils.order.dtos.OrderDto;
import org.ecom.commonutils.pagination.PageableResponse;

import java.util.List;

public interface OrderService {
    //create order
    OrderDto createOrder(CreateOrderRequest request);
    //remove order
    void removeOrder(String orderId);
    //get orders of user
    List<OrderDto> getOrdersOfUser(String userId);
    //get orders
    PageableResponse<OrderDto> getOrders(int pageNumber, int pageSize, String sortBy, String sortDir);

    OrderDto updateOrder(OrderDto order, String orderId);
}
