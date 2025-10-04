package org.ecom.commonutils.order.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ecom.commonutils.user.dtos.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {

    private String cartId;

    private Date createdAt;

    private UserDTO user;

    private List<CartItemDto> items = new ArrayList<>();


}
