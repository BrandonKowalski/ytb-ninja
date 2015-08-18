package ninja.ytb.senpai.dao;

import java.util.UUID;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import ninja.ytb.senpai.models.User;

@Singleton
public class UserDAO extends AbstractSenpaiDAO<User, UUID> {

	@Inject
	public UserDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
