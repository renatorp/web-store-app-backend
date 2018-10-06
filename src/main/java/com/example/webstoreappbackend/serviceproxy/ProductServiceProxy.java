package com.example.webstoreappbackend.serviceproxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webstoreappbackend.vo.ProductVO;

@RibbonClient
@FeignClient(name = "web-store-product-service")
@RequestMapping("products")
public interface ProductServiceProxy {

	@GetMapping
	public List<ProductVO> findProducts();
}
