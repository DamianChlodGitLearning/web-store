package com.mycompanyname.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompanyname.webstore.domain.Category;
import com.mycompanyname.webstore.domain.repository.CategoryRepository;
import com.mycompanyname.webstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByCategoryId(int categoryId) {
		return categoryRepository.findByCategoryId(categoryId);
	}
	

}
