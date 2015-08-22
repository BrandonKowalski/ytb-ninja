package ninja.ytb.senpai.oauth;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationToken;

import ninja.ytb.senpai.models.AccessToken;
import ninja.ytb.senpai.models.User;

public class OAuthToken implements AuthenticationToken, Serializable {
	
	private static final long serialVersionUID = -7962430369433372803L;
	
	public final String accessToken;
	public final String tokenProvider;
	
	public User user;
	
	public OAuthToken(final String accessToken, final String tokenProvider) {
		this.accessToken = accessToken;
		this.tokenProvider = tokenProvider;
	}
	
	public OAuthToken(final AccessToken accessToken) {
		this(accessToken.getToken(), accessToken.getProvider());
	}
	
	public final String getAccessToken() {
		return accessToken;
	}

	public final String getTokenProvider() {
		return tokenProvider;
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(final User user) {
		this.user = user;
	}

	@Override
	public Object getCredentials() {
		return getAccessToken();
	}

	@Override
	public Object getPrincipal() {
		return getUser();
	}
}
