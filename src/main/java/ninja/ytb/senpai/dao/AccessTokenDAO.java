package ninja.ytb.senpai.dao;

import java.util.UUID;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import ninja.ytb.senpai.models.AccessToken;

@Singleton
public class AccessTokenDAO extends AbstractSenpaiDAO<AccessToken, UUID> {

	@Inject
	public AccessTokenDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
