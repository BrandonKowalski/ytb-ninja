package ninja.ytb.senpai.services;

import java.util.Optional;

import com.google.inject.Inject;

import ninja.ytb.senpai.models.AccessToken;
import ninja.ytb.senpai.models.User;
import ninja.ytb.senpai.oauth.OAuthToken;

public class LoginService {
	
	private final UserService userService;
	private final AccessTokenService accessTokenService;
	
	@Inject
	public LoginService(final UserService userService, final AccessTokenService accessTokenService) {
		this.userService = userService;
		this.accessTokenService = accessTokenService;
	}
	
	public final User login(final OAuthToken oAuthToken) {
		
		User user = null;
		Optional<AccessToken> optionalAccessToken = accessTokenService.retrieveAccessToken(oAuthToken);
		
		if (optionalAccessToken.isPresent()) {
			user = optionalAccessToken.get().getUser();
		}
		
		return user;
	}
}
