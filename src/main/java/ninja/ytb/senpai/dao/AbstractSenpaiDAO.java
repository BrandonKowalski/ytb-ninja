package ninja.ytb.senpai.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import io.dropwizard.hibernate.AbstractDAO;

public abstract class AbstractSenpaiDAO<T, I extends Serializable> extends AbstractDAO<T> {

	public AbstractSenpaiDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public T upsert(final T entity) {
		return persist(entity);
	}

	public final List<T> read(final String namedQuery) {
		return list(namedQuery(namedQuery));
	}
	
	public final List<T> read(final Criteria criteria) {
		return list(criteria);
	}

	public final List<T> read(final String namedQuery, final Optional<Map<String, Object>> optionalParams) {
		Query query = super.namedQuery(namedQuery);
		if (optionalParams.isPresent()) {
			Map<String, Object> params = (Map<String, Object>) optionalParams.get();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				query.setParameter(param.getKey(), param.getValue());
			}
		}
		return list(query);
	}

	public final T find(final I id) {
		return super.get(id);
	}
	
	
	
}
