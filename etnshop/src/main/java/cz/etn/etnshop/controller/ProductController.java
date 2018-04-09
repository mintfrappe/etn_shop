package cz.etn.etnshop.controller;

import cz.etn.etnshop.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.etn.etnshop.service.ProductService;

import javax.annotation.Resource;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Resource(name = "productService")
	@Autowired
	private ProductService productService;

	public ProductController() {
	}

	;

	@Autowired(required = true)
	@Qualifier("productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = {"list"}, method = {RequestMethod.GET}
	)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", this.productService.listProducts());
		return "list";
	}

	@RequestMapping(value = {"/list/add"}, method = {RequestMethod.POST}
	)
	public String addProduct(@ModelAttribute("product") Product product) {
		if (product.getId() == 0) {
			this.productService.addProduct(product);
		} else {
			this.productService.updateProduct(product);
		}

		return "redirect:/list";
	}

	@RequestMapping({"/remove/{id}"})
	public String removeProduct(@PathVariable("id") int id) {
		this.productService.removeProduct(id);
		return "redirect:/list";
	}

	@RequestMapping({"edit/{id}"})
	public String editProduct(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.getProductById(id));
		model.addAttribute("listProducts", this.productService.listProducts());
		return "list";
	}

	@RequestMapping({"productdata/{id}"})
	public String productData(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.getProductById(id));
		return "productdata";
	}

}
