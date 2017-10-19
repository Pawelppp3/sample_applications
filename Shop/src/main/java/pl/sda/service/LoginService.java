package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.dao.UserDao;
import pl.sda.model.UserRoleType;

@Service
public class LoginService {
	
	@Autowired
	private UserDao userDao;
	
	public UserRoleType loginByRole(String login, String password) {

		String passwordfromDB = userDao.getPasswordByLogin(login);

		if (passwordfromDB != null && passwordfromDB.equals(password)) {
			return userDao.getRoleByLogin(login);
		} else {
			return UserRoleType.NONE;
		}
	}
}
