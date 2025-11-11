package org.ecom.orderservice.client;

import org.ecom.commonutils.user.dtos.UserInfoResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface UserServiceClient {

    @GetExchange("/internal/users/{id}")
    UserInfoResponse getUserInfo(@PathVariable("id") Long userId);
}
