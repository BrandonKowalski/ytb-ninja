package ninja.ytb.senpai.services;

import java.util.Optional;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;

import ninja.ytb.senpai.oauth.GithubOAuthConfig;
import ninja.ytb.senpai.util.ConstantsUtility;

public class OAuthService {

	private final Logger LOGGER = LoggerFactory.getLogger(OAuthService.class);
	
	private final GithubOAuthConfig config;

	@Inject
	public OAuthService(final Provider<GithubOAuthConfig> configProvider) {
		this.config = configProvider.get();
	}

	public final Optional<String> retrieveGithubToken(final String tempCode) {
		String accessToken = null;
		try {
			OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
			OAuthClientRequest request = OAuthClientRequest.tokenProvider(OAuthProviderType.GITHUB)
					.setGrantType(GrantType.AUTHORIZATION_CODE).setClientId(config.getClientID())
					.setClientSecret(config.getSecretID())
					.setRedirectURI(ConstantsUtility.GITHUB_REDIRECT_URL)
					.setCode(tempCode).buildQueryMessage();

			GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);

			accessToken = oAuthResponse.getAccessToken();

		} catch (OAuthSystemException | OAuthProblemException e) {
			LOGGER.error("Unable to retreive authentication token from Github");
		}
		return Optional.of(accessToken);
	}

	public final Optional<OAuthResourceResponse> makeBearerRequest(final String accessToken, final String apiEndpoint,
			final String httpMethod) {
		OAuthResourceResponse resourceResponse = null;
		try {

			OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

			OAuthClientRequest bearerClientRequest = new OAuthBearerClientRequest(apiEndpoint)
					.setAccessToken(accessToken).buildQueryMessage();

			resourceResponse = oAuthClient.resource(bearerClientRequest, httpMethod,
					OAuthResourceResponse.class);
		} catch (OAuthSystemException | OAuthProblemException e) {
			LOGGER.error("Unable to retreive authentication token from Github");
		}
		return Optional.of(resourceResponse);
	}
}
