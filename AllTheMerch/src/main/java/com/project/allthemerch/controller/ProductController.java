package com.project.allthemerch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.allthemerch.model.Product;
import com.project.allthemerch.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		product.setProductId(0);
		return productService.save(product);
	}
	
	@GetMapping
	public List<Product> getProducts() {
		return productService.findAll();
	}

	@GetMapping("/{id}") 
	public Product getCustomersByid(@PathVariable(value = "id") int productId) {
		return productService.findByProductId(productId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable(value = "id") int productId) {
		productService.delete(productId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> putProduct(@RequestBody Product product, @PathVariable(value = "id") int productId) {
		System.out.println(product.getProductId());
		if(product.getProductId() > 0 && product.getProductId() != productId) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		product.setProductId(productId);
		return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
	}
}
