package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.CartProduct;
import com.project.allthemerch.repo.CartProductDao;

@Service
public class CartProductService {

	@Autowired
	private CartProductDao cartProductDao;
	
	public CartProduct save(CartProduct cartProduct) {
		return cartProductDao.save(cartProduct);
	}
	
	public List<CartProduct> findAll(){
		return cartProductDao.findAll();
	}
	
	public void delete(int id) {
		cartProductDao.deleteByCartProductId(id);
	}
	
	public CartProduct findByCartProductId(int id) {
		return cartProductDao.findById(id);
	}
	
}
