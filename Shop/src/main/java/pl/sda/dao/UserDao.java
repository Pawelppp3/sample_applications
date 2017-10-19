package pl.sda.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pl.sda.model.User;
import pl.sda.model.UserRoleType;

import java.util.List;

@Repository
public class UserDao extends AbstractDao<User> {

	protected UserDao(User t) {
		super(t);
	}

	public User getUserByLoginAndPassword(String login, String password) {
		DetachedCriteria dc = getDetachedCriteria();
		dc.add(Restrictions.eq("login", login));
		dc.add(Restrictions.eq("password", password));

		return findFirst(dc)
				.orElse(null);
	}
	
	public String getPasswordByLogin(String login) {
		DetachedCriteria dc = getDetachedCriteria();
		dc.add(Restrictions.eq("login", login));

		return findFirst(dc)
				.map(u -> u.getPassword())
				.orElse(null);
	}

	public UserRoleType getRoleByLogin(String login) {
		DetachedCriteria dc = getDetachedCriteria();
		dc.add(Restrictions.eq("login", login));

		return findFirst(dc)
				.map(u -> u.getUserRoleType())
				.get();
	}

	public void deleteByLogin(String login) {
		DetachedCriteria dc = getDetachedCriteria();
		dc.add(Restrictions.eq("login", login));

		findFirst(dc)
				.ifPresent(u -> delete(u.getId()));
	}

	public boolean loginExists(String login) {
		DetachedCriteria dc = getDetachedCriteria();
		dc.add(Restrictions.eq("login", login));
		return findFirst(dc).isPresent();
	}
}
