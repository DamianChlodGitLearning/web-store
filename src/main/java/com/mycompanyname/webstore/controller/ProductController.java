package com.mycompanyname.webstore.controller;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.mycompanyname.webstore.domain.Product;
import com.mycompanyname.webstore.service.CategoryService;
import com.mycompanyname.webstore.service.ManufacturerService;
import com.mycompanyname.webstore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ManufacturerService manufacturerService;

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}

	@RequestMapping("/product")
	public String getProductById(Model model, @RequestParam("id") int productId) {

		model.addAttribute("product",
				productService.findProductCategoryandManufacturerByProductId(productId).get(0)[0]);
		model.addAttribute("category",
				productService.findProductCategoryandManufacturerByProductId(productId).get(0)[1]);
		model.addAttribute("manufacturer",
				productService.findProductCategoryandManufacturerByProductId(productId).get(0)[2]);
		return "product";
	}

	@RequestMapping(value = "/add")
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		model.addAttribute("categorySet", categoryService.findAll());
		model.addAttribute("manufacturerSet", manufacturerService.findAll());

		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult result,
			HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"Próba wi¹zania niedozwolonych pól:" + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		newProduct.setCategory(categoryService.findByCategoryId(newProduct.getCategory().getCategoryId()));
		newProduct.setManufacturer(
				manufacturerService.findByManufacturerId(newProduct.getManufacturer().getManufacturerId()));
		newProduct.setUnitsInOrder(0);
		newProduct.setDiscontinued(false);
		Product savedProduct = productService.save(newProduct);

		MultipartFile productImage = newProduct.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(
						new File(rootDirectory + "resources\\images\\" + savedProduct.getProductId() + ".png"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}

		return "redirect:/products";
	}

	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
}
