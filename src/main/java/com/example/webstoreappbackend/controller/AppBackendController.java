package com.example.webstoreappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webstoreappbackend.service.OrderService;
import com.example.webstoreappbackend.serviceproxy.CartServiceProxy;
import com.example.webstoreappbackend.serviceproxy.CustomerServiceProxy;
import com.example.webstoreappbackend.serviceproxy.OrderServiceProxy;
import com.example.webstoreappbackend.serviceproxy.ProductServiceProxy;
import com.example.webstoreappbackend.vo.CartItemVO;
import com.example.webstoreappbackend.vo.CartVO;
import com.example.webstoreappbackend.vo.CustomerVO;
import com.example.webstoreappbackend.vo.OrderRequestVO;
import com.example.webstoreappbackend.vo.OrderVO;
import com.example.webstoreappbackend.vo.ProductVO;

@RestController
@RequestMapping("app")
public class AppBackendController {

	@Autowired
	private ProductServiceProxy productProxy;

	@Autowired
	private CustomerServiceProxy customerProxy;

	@Autowired
	private CartServiceProxy cartProxy;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderServiceProxy orderProxy;

	@GetMapping("products")
	public List<ProductVO> findProducts() {
		return productProxy.findProducts();
	}

	@PutMapping("customers")
	public ResponseEntity<CustomerVO> registerCustomer(@RequestBody CustomerVO customer) {
		return customerProxy.createCustomer(customer);
	}

	@PutMapping("customers/{customerId}/cart/item")
	public ResponseEntity<CartItemVO> addProductToCart(@RequestBody CartItemVO item, @PathVariable("customerId") Integer customerId) {
		CustomerVO customer = customerProxy.getCustomer(customerId);
		CartVO cart = cartProxy.getCartByCustomer(customer.getId());
		return cartProxy.addItem(cart.getId(), item);
	}

	@PostMapping("customers/{customerId}/order")
	public ResponseEntity<OrderVO> placeOrder(@PathVariable("customerId") Integer customerId, @RequestBody OrderRequestVO requestBody) {
		
		CartVO cart = cartProxy.getCartByCustomer(customerId);
		
		OrderVO order = orderService.createOrderFromCart(cart, customerId, requestBody);
		
		return orderProxy.createOrder(order);
		
	}
}
