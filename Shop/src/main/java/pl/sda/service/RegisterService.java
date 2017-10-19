package pl.sda.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.dao.ShopperDao;
import pl.sda.dao.UserDao;
import pl.sda.model.Shopper;
import pl.sda.model.User;
import pl.sda.model.UserRoleType;

@Service
public class RegisterService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShopperDao shopperDao;

    public boolean newUser(User user, Shopper shopper) {

        if (StringUtils.isBlank(user.getLogin()) ||
                StringUtils.isBlank(user.getPassword()) ||
                userDao.loginExists(user.getLogin())) {
            return false;
        }
        user.setUserRoleType(UserRoleType.USER);
        shopperDao.save(shopper);
        userDao.save(user);
        return true;
    }
}
