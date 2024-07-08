package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.PurchaseProduct;
import com.project.allthemerch.repo.PurchaseProductDao;

@Service
public class PurchaseProductService {
	
	@Autowired
	private PurchaseProductDao purchaseProductDao;
	
	public PurchaseProduct save(PurchaseProduct purchaseProduct) {
		return purchaseProductDao.save(purchaseProduct);
	}
	
	public List<PurchaseProduct> findAll(){
		return purchaseProductDao.findAll();
	}
	
	public void delete(int id) {
		purchaseProductDao.deleteByPurchaseProductId(id);
	}
	
	public PurchaseProduct findByPurchaseProductId(int id) {
		return purchaseProductDao.findById(id);
	}

}
