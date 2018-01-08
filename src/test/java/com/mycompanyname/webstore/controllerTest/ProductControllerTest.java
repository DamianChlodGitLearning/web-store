package com.mycompanyname.webstore.controllerTest;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.ui.ExtendedModelMap;
import com.mycompanyname.webstore.controller.ProductController;
import com.mycompanyname.webstore.domain.Product;
import com.mycompanyname.webstore.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	ProductService productService;

	@InjectMocks
	ProductController productController;

	@Mock
	List<Product> productsList = new ArrayList<Product>();

	@Mock
	BindingResult result;

	// ExtendedModelMap extends ModelMap and implements Model (bridge between
	// ModelMap and Model)
	@Spy
	Model model = new ExtendedModelMap();

	@Test
	public void list() {
		when(productService.findAll()).thenReturn(productsList);
		Assert.assertEquals(productController.list(model), "products");
		Assert.assertEquals(model.asMap().get("products"), productsList);
		verify(productService, atLeastOnce()).findAll();
	}

}
