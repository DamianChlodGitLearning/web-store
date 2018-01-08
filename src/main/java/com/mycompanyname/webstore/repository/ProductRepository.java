package com.mycompanyname.webstore.repository;

import com.mycompanyname.webstore.domain.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();

	List<Product> findByName(String name);

	@SuppressWarnings("unchecked")
	Product save(Product newProduct);

	@Query("select p, c, m from Product p join p.category c join p.manufacturer m where p.productId= :productId")
	List<Object[]> findProductCategoryandManufacturerByProductId(@Param("productId") int productId);

}
