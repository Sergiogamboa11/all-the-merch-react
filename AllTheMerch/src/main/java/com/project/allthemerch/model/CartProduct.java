package com.project.allthemerch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Cart_Product")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	generator = "cart_product_seq")
	@SequenceGenerator(name = "cart_product_seq", 
	initialValue = 2)
	private int cartProductId;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonBackReference
	private Cart cart;

	@OneToOne
	@JoinColumn(name = "product_id")
//	@JsonManagedReference
	private Product product;

	@Column
	private int quantity;
	
	public CartProduct() {
	}
	
	public CartProduct(int cartProductId, Cart cart, Product product, int quantity) {
		super();
		this.cartProductId = cartProductId;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartProduct(Cart cart, Product product, int quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartProduct [cartProductId=" + cartProductId + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity
				+ "]";
	}

}
