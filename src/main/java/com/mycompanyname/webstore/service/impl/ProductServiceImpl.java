package com.mycompanyname.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompanyname.webstore.domain.Product;
import com.mycompanyname.webstore.domain.repository.ProductRepository;
import com.mycompanyname.webstore.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findByName(String name) {
		return this.productRepository.findByName(name);
	}

	@Override
	public Product findByProductId(int ProductId) {
		return this.productRepository.findByProductId(ProductId);
	}

	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product save(Product newProduct) {
		return this.productRepository.save(newProduct);
	}

}
