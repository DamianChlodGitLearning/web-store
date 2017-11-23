package com.mycompanyname.webstore.domain.repository;

import com.mycompanyname.webstore.domain.Product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	List<Product> findByName(String name);

	Product findByProductId(int productId);
	
}
