package com.project.allthemerch.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@OneToOne
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	@Column
	private String name;
	
	@Column
	private String type;
	
	@Column
	private int stock;
	
	@Column
	private LocalDate restockDate;

	@Column
	private String description;
	
	@Column
	private String image;
	
	@Column
	private double price;
	
	public Product() {
	}

	public Product(int productId, Artist artist, String name, String type, int stock, LocalDate restockDate, String description, String image,
			double price) {
		super();
		this.productId = productId;
		this.artist = artist;
		this.name = name;
		this.type = type;
		this.stock = stock;
		this.restockDate = restockDate;
		this.description = description;
		this.image = image;
		this.price = price;
	}
	
	public Product(Artist artist, String name, String type, int stock, LocalDate restockDate, String description, String image,
			double price) {
		super();
		this.artist = artist;
		this.name = name;
		this.type = type;
		this.stock = stock;
		this.restockDate = restockDate;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public LocalDate getRestockDate() {
		return restockDate;
	}

	public void setRestockDate(LocalDate restockDate) {
		this.restockDate = restockDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", artist=" + artist + ", name=" + name + ", type=" + type + ", stock="
				+ stock + ", restockDate=" + restockDate + ", description=" + description + ", image=" + image
				+ ", price=" + price + "]";
	}

}
