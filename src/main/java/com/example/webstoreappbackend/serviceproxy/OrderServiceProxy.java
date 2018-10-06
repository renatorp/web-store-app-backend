package com.example.webstoreappbackend.serviceproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webstoreappbackend.vo.OrderVO;

@RibbonClient
@FeignClient(name = "web-store-order-service")
@RequestMapping("orders")
public interface OrderServiceProxy {

	@PostMapping
	public ResponseEntity<OrderVO> createOrder(@RequestBody OrderVO orderRequest);
}
