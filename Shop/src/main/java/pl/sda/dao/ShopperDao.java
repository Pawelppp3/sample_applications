package pl.sda.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pl.sda.model.Shopper;
import pl.sda.model.User;

import java.util.List;

@Repository
public class ShopperDao extends AbstractDao<Shopper>{

    protected ShopperDao(Shopper shopper) {
        super(shopper);
    }

    public Shopper getByLogin(String login) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("login", login));
        List<User> list = getHibernateTemplate().findByCriteria(dc);

        User user = list.stream()
                .findFirst()
                .orElse(null);
        return user.getShopperS();
    }
}
