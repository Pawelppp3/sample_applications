package pl.sda.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class AbstractDao<T>  extends HibernateDaoSupport {
	
	private T t;
	
	protected AbstractDao(T t) {
		this.t = t;
	}

	public List<T> getAll()	{
		return findByCriteria(getDetachedCriteria());
	}

	public void save(T obj) {
		getHibernateTemplate().save(obj);
	}
	
	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}
	
	public void delete(Long id) {
		getHibernateTemplate().delete(getById(id));
	}

	public T getById(Long id) {
		DetachedCriteria criteria = getDetachedCriteria();
		criteria.add(Restrictions.eq("id", id));

		return findFirst(criteria)
				.orElse(null);
	}

	protected DetachedCriteria getDetachedCriteria() {
		return DetachedCriteria.forClass(t.getClass());
	}

	protected List<T> findByCriteria(DetachedCriteria criteria) {
		return getHibernateTemplate().findByCriteria(criteria);
	}

	protected Optional<T> findFirst(DetachedCriteria criteria) {
		return findByCriteria(criteria)
				.stream()
				.findFirst();
	}
}
