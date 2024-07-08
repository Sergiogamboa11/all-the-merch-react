package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.CartProduct;

@Transactional
public interface CartProductDao extends CrudRepository<CartProduct, Integer>{
	public List<CartProduct> findAll();
	public void deleteByCartProductId(int id);
	public CartProduct findById(int id);
}
