package pl.sda.dao;

import org.springframework.stereotype.Repository;
import pl.sda.model.Orders;

@Repository
public class OrdersDao extends AbstractDao<Orders> {

    protected OrdersDao(Orders orders) {
        super(orders);
    }
}
