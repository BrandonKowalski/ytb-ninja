package ninja.ytb.senpai.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import io.kowalski.oaami.models.OaamiToken;
import ninja.ytb.senpai.dao.AccessTokenDAO;
import ninja.ytb.senpai.models.AccessToken;
import ninja.ytb.senpai.models.User;

public class AccessTokenService {
	
	private final Logger LOGGER = LoggerFactory.getLogger(AccessTokenService.class);
	
	private final UserService userService;
	private final AccessTokenDAO accessTokenDAO;
	
	@Inject
	public AccessTokenService(final UserService userService, final AccessTokenDAO accessTokenDAO) {
		this.userService = userService;
		this.accessTokenDAO = accessTokenDAO;
	}
	
	public final Optional<AccessToken> retrieveAccessToken(final OaamiToken token) {
		Optional<AccessToken> accessToken = Optional.empty();
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("token", token.accessToken);
		params.put("provider", token.provider.providerName);
		
		Optional<List<AccessToken>> optionalAccessToken = 
				Optional.ofNullable(accessTokenDAO.read("AccessToken.RetrieveByToken", Optional.of(params)));
		
		if (optionalAccessToken.isPresent() && !optionalAccessToken.get().isEmpty()) {
			LOGGER.info("Found existing access token");
			accessToken = Optional.of(optionalAccessToken.get().get(0));
		} else {
			LOGGER.info("No existing access token. Creating AT & new User.");
			
			User newUser = userService.createBlank();
			
			AccessToken at = new AccessToken(token.accessToken, token.provider.providerName, newUser);
			
			accessToken = Optional.of(accessTokenDAO.upsert(at));
		}
		
		return accessToken;
	}
}
