package com.example.webstoreappbackend.serviceproxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webstoreappbackend.vo.CustomerVO;

@RibbonClient
@FeignClient(name = "web-store-customer-service")
@RequestMapping("customers")
public interface CustomerServiceProxy {

	@PutMapping
	public ResponseEntity<CustomerVO> createCustomer(@RequestBody CustomerVO customer);
	
	@GetMapping("{id}")
	public CustomerVO getCustomer(@PathVariable("id") Integer id);
}
