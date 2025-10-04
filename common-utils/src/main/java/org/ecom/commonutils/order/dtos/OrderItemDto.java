package org.ecom.commonutils.order.dtos;

import lombok.*;
import org.ecom.commonutils.product.dtos.ProductDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDto {

    private int orderItemId;

    private int quantity;

    private double totalPrice;

    private ProductDto product;
}
