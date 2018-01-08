package com.mycompanyname.webstore.service.implTest;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mycompanyname.webstore.domain.Product;
import com.mycompanyname.webstore.repository.ProductRepository;
import com.mycompanyname.webstore.service.impl.ProductServiceImpl;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Mock
	List<Product> productsList = new ArrayList<Product>();

	@Test
	public void findAll() {
		when(productRepository.findAll()).thenReturn(productsList);
		Assert.assertEquals(productServiceImpl.findAll(), productsList);
		verify(productRepository, atLeastOnce()).findAll();
	}

}
