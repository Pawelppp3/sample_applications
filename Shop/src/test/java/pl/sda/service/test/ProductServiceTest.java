package pl.sda.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.dao.ShopperDao;
import pl.sda.model.Basket;
import pl.sda.model.Product;
import pl.sda.model.Shopper;
import pl.sda.service.ProductService;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class ProductServiceTest {

		@Autowired
		private ProductService productService;
		@Autowired
		private ShopperDao shopperDao;

		@Test
		public void shouldGetProductById() {
			Product product = productService.getById(3L);
			org.junit.Assert.assertNotNull(product);
		}

		@Test
		public void shouldGetHelloList() {
			List<Product> list = productService.getAll();
			org.junit.Assert.assertNotNull(list);
		}

		@Test
		public void testSaveBasket() {
			final Shopper shopper = shopperDao.getByLogin("aa");
			Basket basket = new Basket("aa");
			basket.getProductsIds().addAll(Arrays.asList(1L, 1L, 2L, 2L));

			productService.saveBasket(basket, shopper);
		}



}
