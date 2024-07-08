package com.project.allthemerch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.model.Product;
import com.project.allthemerch.repo.ProductDao;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public Product save(Product product) {
		return productDao.save(product);
	}
	
	public List<Product> findAll() {
		return productDao.findAll();
	}
	
	public Product findByProductId(int id) {
		return productDao.findById(id);
	}
	
	public List<Product> findByArtist(Artist a) {
		return productDao.findByArtist(a);
	}
	
	public void delete(int id) {
		productDao.deleteByProductId(id);
	}

}
