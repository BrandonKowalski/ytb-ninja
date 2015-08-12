package ninja.ytb.senpai.dao;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.AbstractDAO;
import ninja.ytb.senpai.model.Organization;

@Singleton
public class OrganizationDAO extends AbstractDAO<Organization> {

	@Inject
	public OrganizationDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public Organization create(final Organization organization) {
		return persist(organization);
	}
}
