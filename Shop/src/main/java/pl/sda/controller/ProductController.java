package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.sda.dao.OrdersDao;
import pl.sda.model.*;
import pl.sda.service.ProductService;
import pl.sda.service.ShopperService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ShopperService shopperService;
    @Autowired
    private OrdersDao ordersDao;


    @RequestMapping(value = "product.do")
    public String products(Model model) {
        List<Product> list = productService.getAll();

        model.addAttribute("ALL_PRODUCT", list);
        return "product";
    }

    @RequestMapping(value = "newProductForm.do", method = RequestMethod.GET)
    public ModelAndView newProductForm() {
        ModelAndView mav = new ModelAndView("newProductPage");
        Product product = new Product();

        List<String> listCategories = Stream.of(Category.values())
                .map(c -> c.name())
                .collect(Collectors.toList());
        mav.getModelMap().put("categories", listCategories);


        List<String> listClothing = Stream.of(Clothing.values())
                .map(c -> c.name())
                .collect(Collectors.toList());
        mav.getModelMap().put("clothings", listClothing);

        List<String> listSize = Stream.of(Size.values())
                .map(c -> c.name())
                .collect(Collectors.toList());
        mav.getModelMap().put("sizes", listSize);

        mav.getModelMap().put("newProduct", product);
        return mav;
    }

    @RequestMapping(value = "saveProduct.do", method = RequestMethod.POST)
    public String create(@ModelAttribute("newProduct") Product product, @ModelAttribute("category") String category,
                         @ModelAttribute("clothing") String clothing, @ModelAttribute("size") String size) {
        product.setCategory(Category.valueOf(category));
        product.setClothing(Clothing.valueOf(clothing));
        product.setSize(Size.valueOf(size));
        productService.save(product);
        return "redirect:product.do";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("editProduct");
        Product product = productService.getById(id);
        mav.addObject("editProduct", product);
        return mav;
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String update(@ModelAttribute("editProduct") Product product) {
        productService.update(product);
        return "redirect:product.do";
    }

    @RequestMapping(value = "deleteProduct.do")
    public String deleteProduct(@RequestParam("id") Long id) {
        productService.delete(id);
        return "redirect:product.do";
    }

    @RequestMapping(value = "shopper.do", method = RequestMethod.GET)
    public String viewShopper(Model model, HttpServletRequest request) {
        List<Product> list = productService.getAll();
        Object exp = request.getSession().getAttribute("login");
        model.addAttribute("ALL_PRODUCT", list);
        return "shopper";
    }

    @RequestMapping(value = "Buy.do", method = RequestMethod.GET)
    public String addToBucket(@RequestParam("id") Long id, HttpServletRequest request) {

        Basket basket = (Basket) request.getSession().getAttribute("basket");
        basket.getProductsIds().add(id);
        request.getSession().setAttribute("basket", basket);
        return "redirect:shopper.do";
    }

    @RequestMapping(value = "BuyR.do", method = RequestMethod.GET)
    public ModelAndView addToBucketR(@RequestParam("id") Long id, HttpServletRequest request) {

        Basket basket = (Basket) request.getSession().getAttribute("basket");
        basket.getProductsIds().add(id);
        request.getSession().setAttribute("basket", basket);
        ModelAndView modelAndView = new ModelAndView("resultProductPage");

        modelAndView.getModelMap().put("searchProduct", request.getSession().getAttribute("searchProduct"));

        return modelAndView;
    }

    @RequestMapping(value = "buyNow.do", method = RequestMethod.GET)
    public String buyNow(HttpServletRequest request) {

        Basket basket = (Basket) request.getSession().getAttribute("basket");
        Shopper shopper = shopperService.getByLogin((String) request.getSession().getAttribute("login"));

        productService.saveBasket(basket, shopper);

//        request.getSession().setAttribute("basket", new Basket((String) request.getSession().getAttribute("login")));

        return "redirect:showProductFromCart.do";
    }

    @RequestMapping(value = "buyProductNow.do", method = RequestMethod.GET)
    public ModelAndView goTo(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("buyProductNow");
        Basket basket = (Basket) request.getSession().getAttribute("basket");
        request.getSession().setAttribute("BUYED_PRODUCT", productService.getProduct(basket.getProductsIds()));
        return mav;
    }

    @RequestMapping(value = "deleteProductFromCart.do", method = RequestMethod.GET)
    public String deleteProductFromCart(@RequestParam("id") Long id, HttpServletRequest request) {

        Basket basket = (Basket) request.getSession().getAttribute("basket");
        basket.getProductsIds().remove((Long) id);
        request.getSession().setAttribute("BUYED_PRODUCT", productService.getProduct(basket.getProductsIds()));
        return "redirect:buyProductNow.do";
    }

    @RequestMapping(value = "showProductFromCart.do", method = RequestMethod.GET)
    public ModelAndView showProductFromCart(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("summaryPageForShopping");
        Basket basket = (Basket) request.getSession().getAttribute("basket");
        int counter = basket.getSize();
        request.getSession().setAttribute("counter", counter);
        request.getSession().setAttribute("PRODUCT_CART", productService.showProducts(basket));
        request.getSession().setAttribute("basket", new Basket((String) request.getSession().getAttribute("login")));

        return mav;
    }
}
