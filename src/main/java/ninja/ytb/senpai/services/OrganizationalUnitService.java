package ninja.ytb.senpai.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Singleton;

import org.hibernate.Criteria;

import com.google.inject.Inject;

import ninja.ytb.senpai.dao.OrganizationalUnitDAO;
import ninja.ytb.senpai.model.base.OrganizationalUnit;

@Singleton
public class OrganizationalUnitService<T extends OrganizationalUnit> {
	
	private final OrganizationalUnitDAO<T> dao;
	
	@Inject
	public OrganizationalUnitService(final OrganizationalUnitDAO<T> dao) {
		this.dao = dao;
	}
	
	public T create(final T organizationalUnit) {
		T createdOrganizationalUnit = dao.upsert(organizationalUnit);
		updateSuperiorSubordinates(createdOrganizationalUnit);	
		return createdOrganizationalUnit;
	}
	
	public final List<T> read(final String namedQuery) {
		return dao.read(namedQuery);
	}
	
	public final List<T> read(final Criteria criteria) {
		return dao.read(criteria);
	}
	
	public final List<T> read(final String namedQuery, final Optional<Map<String, Object>> optionalParams) {
		return dao.read(namedQuery, optionalParams);
	}
	
	private void updateSuperiorSubordinates(T potentialSubordinate) {
		if (potentialSubordinate.getSuperior() != null) {
			T superior = dao.find(potentialSubordinate.getSuperior().getId());

			superior.getSubordinates().add(potentialSubordinate);
			dao.upsert(superior);		
		}
	}
}
