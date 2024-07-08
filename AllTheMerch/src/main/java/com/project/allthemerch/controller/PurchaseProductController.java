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

import com.project.allthemerch.model.PurchaseProduct;
import com.project.allthemerch.service.PurchaseProductService;

@RestController
@RequestMapping("/api/controllers")
@CrossOrigin
public class PurchaseProductController {

	@Autowired
	private PurchaseProductService purchaseProductService;
	
	@PostMapping
	public PurchaseProduct createPurchaseProduct(@RequestBody PurchaseProduct purchaseProduct) {
		purchaseProduct.setPurchaseProductId(0);
		return purchaseProductService.save(purchaseProduct);
	}
	
	@GetMapping
	public List<PurchaseProduct> getPurchaseProducts(){
		return purchaseProductService.findAll();
	}
	
	@GetMapping("/{id}") 
	public PurchaseProduct getPurchaseProductById(@PathVariable(value = "id") int purchaseProductId) {
		return purchaseProductService.findByPurchaseProductId(purchaseProductId);
	}
	
	@DeleteMapping("/{id}")
	public void deletePurchaseProduct(@PathVariable(value = "id") int purchaseProductId) {
		purchaseProductService.delete(purchaseProductId);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseProduct> purPurchaseProduct(@RequestBody PurchaseProduct purchaseProduct, @PathVariable(value = "id") int purchaseProductId) {
		System.out.println(purchaseProduct.getPurchaseProductId());
		if(purchaseProduct.getPurchaseProductId() > 0 && purchaseProduct.getPurchaseProductId() != purchaseProductId) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		purchaseProduct.setPurchaseProductId(purchaseProductId);
		return new ResponseEntity<>(purchaseProductService.save(purchaseProduct), HttpStatus.OK);
	}
	
}
