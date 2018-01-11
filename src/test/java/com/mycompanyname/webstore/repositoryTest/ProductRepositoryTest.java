package com.mycompanyname.webstore.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import com.mycompanyname.webstore.domain.Category;
import com.mycompanyname.webstore.domain.Manufacturer;
import com.mycompanyname.webstore.domain.Product;
import com.mycompanyname.webstore.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void should_find_all_Products() {
		Product p1 = new Product();

		Category categoryForP1 = new Category();
		categoryForP1.setName("category_1 test");

		entityManager.persist(categoryForP1);

		Manufacturer manufacturerForP1 = new Manufacturer();
		manufacturerForP1 = new Manufacturer();
		manufacturerForP1.setName("manufacturer_1 test");

		entityManager.persist(manufacturerForP1);

		p1.setName("name_1 test");
		p1.setCategory(categoryForP1);
		p1.setCondition("condition_1 test");
		p1.setDescription("decription_1 test");
		p1.setDiscontinued(true);
		p1.setUnitPrice(new BigDecimal(500));
		p1.setManufacturer(manufacturerForP1);
		p1.setUnitsInOrder(50);
		p1.setUnitsInStock(10);

		Product p2 = new Product();

		Category categoryForP2 = new Category();
		categoryForP2.setName("category_2 test");

		entityManager.persist(categoryForP2);

		Manufacturer manufacturerForP2 = new Manufacturer();
		manufacturerForP2 = new Manufacturer();
		manufacturerForP2.setName("manufacturer_2 test");

		entityManager.persist(manufacturerForP2);

		p2.setName("name_2 test");
		p2.setCategory(categoryForP2);
		p2.setCondition("condition_2 test");
		p2.setDescription("decription_2 test");
		p2.setDiscontinued(true);
		p2.setUnitPrice(new BigDecimal(700));
		p2.setManufacturer(manufacturerForP2);
		p2.setUnitsInOrder(30);
		p2.setUnitsInStock(15);

		entityManager.persist(p1);
		entityManager.persist(p2);

		Iterable<Product> products = productRepository.findAll();

		assertThat(products).hasSize(2).contains(p1, p2);
	}

}
