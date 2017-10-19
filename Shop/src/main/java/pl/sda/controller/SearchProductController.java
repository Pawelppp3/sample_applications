package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.model.*;
import pl.sda.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class SearchProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "searchProductForm.do", method = RequestMethod.GET)
	public ModelAndView newProductForm() {
		ModelAndView mav = new ModelAndView("searchProductPage");
		Product product = new Product();

		mav.getModelMap().put("searchProduct", product);
		return mav;
	}

	@RequestMapping(value = "searchProduct.do", method = RequestMethod.POST)
	public ModelAndView find(@ModelAttribute("searchProduct") Product product, HttpServletRequest request) {

			Product productSearched = productService.search(product).get();
			ModelAndView mav = new ModelAndView("resultProductPage");
			request.getSession().setAttribute("searchedProduct", productSearched);

		return mav;
	}
}
