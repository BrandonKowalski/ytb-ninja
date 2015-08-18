package ninja.ytb.senpai.oauth;

import java.io.Serializable;

public class OAuthToken implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final String accessToken;
	public final String tokenProvider;
	public OAuthToken(final String accessToken, final String tokenProvider) {
		this.accessToken = accessToken;
		this.tokenProvider = tokenProvider;
	}
	
	public final String getAccessToken() {
		return accessToken;
	}

	public final String getTokenProvider() {
		return tokenProvider;
	}
}
