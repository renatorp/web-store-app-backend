package com.example.webstoreappbackend.serviceproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.webstoreappbackend.vo.CartItemVO;
import com.example.webstoreappbackend.vo.CartVO;

@RibbonClient
@FeignClient(name = "web-store-cart-service")
public interface CartServiceProxy {

	@PutMapping("carts/{cartId}/items")
	ResponseEntity<CartItemVO> addItem(@PathVariable("cartId") Integer cartId, @RequestBody CartItemVO item);
	
	@GetMapping("customers/{customerId}/cart")
	CartVO getCartByCustomer(@PathVariable("customerId") Integer customerId);
}
