package com.mycompanyname.webstore.service;

import java.util.List;

import com.mycompanyname.webstore.domain.Product;

public interface ProductService {

	List<Product> findAll();
	
	List<Product> findByName(String name);

	Product findByProductId(int productId);
	
	Product save(Product newProduct);
}
