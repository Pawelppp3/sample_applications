package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.OrdersDao;
import pl.sda.dao.ProductDao;
import pl.sda.model.*;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrdersDao ordersDao;

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public Product getById(Long id) {
        return productDao.getById(id);
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delete(Long id) {
        productDao.delete(id);
    }

    public Optional <Product> search(Product product) {
        return productDao.search(product);
    }

    public List<Product> getProduct(List<Long> productsIds) {

        List<Product> productList = new ArrayList<>();
        productsIds.forEach(i -> productList.add(productDao.getById(i)));

        return productList;
    }

    public void saveBasket(Basket basket, Shopper shopper) {
        Orders orders = new Orders();

        orders.setShoppers(shopper);
        List<Product> products = getProduct(basket.getProductsIds());

        Map<Product, Integer> productIntegerMap = productCount(products);
        List<JoinOrdersAndProduct> joinOrdersAndProducts = new ArrayList<>();

        for (Map.Entry<Product, Integer> e: productIntegerMap.entrySet()) {
            JoinOrdersAndProduct tabjoin = new JoinOrdersAndProduct();
            tabjoin.setProduct(e.getKey());
            tabjoin.setQuantity(e.getValue());
            tabjoin.setOrders(orders);
            joinOrdersAndProducts.add(tabjoin);
        }
        orders.setQuantity(basket.getProductsIds().size());
        orders.setJoinOrdersAndProducts(joinOrdersAndProducts);
        ordersDao.save(orders);
    }
    private Map<Product, Integer> productCount(List<Product> products) {

        int cunter = 0;
        Map<Product, Integer> mapa = new HashMap<>();
        for (Product p : products) {
            cunter = 0;
            for (Product k : products) {
                if (p.getId().equals(k.getId())) {
                    cunter++;
                }
            }
            mapa.put(p, cunter);
        }
        return mapa;
    }

    public List<String> showProducts (Basket basket) {

        List<Product> products = getProduct(basket.getProductsIds());
        Map<Product, Integer> productMap = productCount(products);
        List<String> listCart = new ArrayList<>();

        for (Map.Entry<Product, Integer> e : productMap.entrySet()) {
            String inscription;
            inscription = e.getKey().getCategory().toString() + " " + e.getKey().getClothing().toString()
                    + " by " + e.getKey().getName().toString() + ", size " + e.getKey().getSize().toString()
                    + ", Qty:" + e.getValue();
            listCart.add(inscription);
        } return listCart;
    }
}
