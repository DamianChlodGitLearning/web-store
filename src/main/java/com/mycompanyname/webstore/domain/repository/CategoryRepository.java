package com.mycompanyname.webstore.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycompanyname.webstore.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	Category findByCategoryId(int categoryId);
	
}
