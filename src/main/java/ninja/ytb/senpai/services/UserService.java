package ninja.ytb.senpai.services;

import com.google.inject.Inject;

import ninja.ytb.senpai.dao.UserDAO;
import ninja.ytb.senpai.models.User;

public class UserService extends AbstractService<User> {
	
	private final UserDAO userDAO;
	
	@Inject
	public UserService(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public final User upsert(final User user) {
		return userDAO.upsert(user);
	}
	
	public final User createBlank() {
		return userDAO.upsert(new User());
	}

}
