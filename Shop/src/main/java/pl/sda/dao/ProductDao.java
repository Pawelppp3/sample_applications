package pl.sda.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.sda.model.Product;

import java.util.Optional;

@Repository
public class ProductDao extends AbstractDao<Product> {

    public ProductDao(Product t) {
        super(t);
    }

    public Optional <Product> search(Product product) {
        DetachedCriteria criteria = getDetachedCriteria();

        if (StringUtils.isNotBlank(product.getName())) {
            criteria.add(Restrictions.eq("name", product.getName()));
//
            return findFirst(criteria);
        }  else
            return Optional.empty();
    }
}

