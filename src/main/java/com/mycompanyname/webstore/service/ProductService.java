package com.mycompanyname.webstore.service;

import java.util.List;

import com.mycompanyname.webstore.domain.Product;

public interface ProductService {

	List<Product> findAll();

	List<Product> findByName(String name);

	Product save(Product newProduct);
	
	List<Object[]> findProductCategoryandManufacturerByProductId(int productId);
}
