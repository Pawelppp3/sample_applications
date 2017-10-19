package pl.sda.dao;

import org.springframework.stereotype.Repository;
import pl.sda.model.JoinOrdersAndProduct;

@Repository
public class JoinOrdersAndProductDao extends AbstractDao<JoinOrdersAndProduct> {

        protected JoinOrdersAndProductDao(JoinOrdersAndProduct joinOrdersAndProduct) {
            super(joinOrdersAndProduct);
        }
}
