package org.ecom.orderservice.client;

import org.ecom.commonutils.product.dtos.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "${PRODUCT_SERVICE_URL}")
//@FeignClient(name = "productservice")
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    ProductDto getProduct(@PathVariable("id") String id);

}
