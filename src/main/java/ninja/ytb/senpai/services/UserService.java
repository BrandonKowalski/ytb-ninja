package ninja.ytb.senpai.services;

import com.google.inject.Inject;

import ninja.ytb.senpai.dao.UserDAO;
import ninja.ytb.senpai.models.User;

public class UserService {
	
	private final UserDAO userDAO;
	
	@Inject
	public UserService(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public final User createUser() {
		return userDAO.upsert(new User());
	}

}
