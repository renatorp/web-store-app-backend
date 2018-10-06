package com.example.webstoreappbackend.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.webstoreappbackend.vo.CartItemVO;
import com.example.webstoreappbackend.vo.CartVO;
import com.example.webstoreappbackend.vo.OrderItemVO;
import com.example.webstoreappbackend.vo.OrderRequestVO;
import com.example.webstoreappbackend.vo.OrderVO;

@Service
public class OrderService {

	public OrderVO createOrderFromCart(CartVO cart, Integer customerId, OrderRequestVO requestBody) {
		OrderVO order = new OrderVO();
		
		order.setAddress(requestBody.getAddress());
		order.setCustomerId(customerId);
		order.setCartId(cart.getId());
		order.setItems(new ArrayList<>());
		
		for (CartItemVO cartItem : cart.getItems()) {
			OrderItemVO item = new OrderItemVO();
			item.setProductId(cartItem.getProductId());
			item.setQuantity(cartItem.getQuantity());
			order.getItems().add(item);
		}
		
		return order;
	}

}
