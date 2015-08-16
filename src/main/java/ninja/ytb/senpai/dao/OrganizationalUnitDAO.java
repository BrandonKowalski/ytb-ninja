package ninja.ytb.senpai.dao;

import java.util.UUID;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import ninja.ytb.senpai.model.base.OrganizationalUnit;

@Singleton
public class OrganizationalUnitDAO<T extends OrganizationalUnit> extends AbstractSenpaiDAO<T, UUID> {

	@Inject
	public OrganizationalUnitDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
