package com.project.allthemerch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_product")
public class PurchaseProduct {

	@Id
	@Column(name="purchase_product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseProductId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="purchase_id")
	private Purchase purchase;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="purchase_price")
	private double purchase_price;

	public PurchaseProduct() {
		
	}

	public PurchaseProduct(int purchaseProductId, Purchase purchase, Product product, int quantity, double purchase_price) {
		this.purchaseProductId = purchaseProductId;
		this.purchase = purchase;
		this.product = product;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}
	
	public PurchaseProduct(Purchase purchase, Product product, int quantity, double purchase_price) {
		this.purchase = purchase;
		this.product = product;
		this.quantity = quantity;
		this.purchase_price = purchase_price;
	}

	public int getPurchaseProductId() {
		return purchaseProductId;
	}

	public void setPurchaseProductId(int purchaseProductId) {
		this.purchaseProductId = purchaseProductId;
	}

	public Purchase getPurchases() {
		return purchase;
	}

	public void setPurchases(Purchase purchase) {
		this.purchase = purchase;
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

	public double getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}

	@Override
	public String toString() {
		return "PurchaseProduct [purchaseProductId=" + purchaseProductId + ", purchase=" + purchase + ", product=" + product
				+ ", quantity=" + quantity + ", purchase_price=" + purchase_price + "]";
	}
	
}
