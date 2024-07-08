package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.PurchaseProduct;

@Transactional
public interface PurchaseProductDao extends CrudRepository<PurchaseProduct, Integer>{
	public List<PurchaseProduct> findAll();
	public void deleteByPurchaseProductId(int id);
	public PurchaseProduct findById(int id);
}
