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

import com.project.allthemerch.model.CartProduct;
import com.project.allthemerch.service.CartProductService;

@RestController
@RequestMapping("/api/cartproducts")
@CrossOrigin
public class CartProductController {

	@Autowired
	private CartProductService cartProductService;
	
	@PostMapping
	public CartProduct createCartProduct(@RequestBody CartProduct cartProduct) {
		cartProduct.setCartProductId(0);
		return cartProductService.save(cartProduct);
	}
	
	@GetMapping
	public List<CartProduct> getCartProducts(){
		return cartProductService.findAll();
	}
	
	@GetMapping("/{id}") 
	public CartProduct getCartProductById(@PathVariable(value = "id") int cartProductId) {
		return cartProductService.findByCartProductId(cartProductId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCartProduct(@PathVariable(value = "id") int cartProductId) {
		cartProductService.delete(cartProductId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CartProduct> putCartProduct(@RequestBody CartProduct cartProduct, @PathVariable(value = "id") int cartProductId) {
		System.out.println(cartProduct.getCartProductId());
		if(cartProduct.getCartProductId() > 0 && cartProduct.getCartProductId() != cartProductId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		cartProduct.setCartProductId(cartProductId);
		return new ResponseEntity<>(cartProductService.save(cartProduct), HttpStatus.OK);
	}
	
}
