package com.project.allthemerch.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.project.allthemerch.model.Artist;
import com.project.allthemerch.model.Product;

@Transactional 
public interface ProductDao extends CrudRepository<Product, Integer>{
	public List<Product> findAll();
	public void deleteByProductId(int id);
	public List<Product> findByArtist(Artist a);
	public Product findById(int id);
}
