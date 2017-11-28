package com.mycompanyname.webstore.service;

import java.util.List;

import com.mycompanyname.webstore.domain.Category;

public interface CategoryService {

	List<Category> findAll();

	Category findByCategoryId(int categoryId);
}
