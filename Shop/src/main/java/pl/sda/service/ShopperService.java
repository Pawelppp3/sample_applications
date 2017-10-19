package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.ShopperDao;
import pl.sda.model.Shopper;

@Service
public class ShopperService {

    @Autowired
    private ShopperDao shopperDao;

    public Shopper getByLogin(String login) {
        return shopperDao.getByLogin(login);
    }
}
