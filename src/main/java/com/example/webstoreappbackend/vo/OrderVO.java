package com.example.webstoreappbackend.vo;

import java.util.List;

public class OrderVO {

	private List<OrderItemVO> items;

	private Integer customerId;

	private Integer cartId;

	private String address;

	public List<OrderItemVO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemVO> items) {
		this.items = items;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

}
