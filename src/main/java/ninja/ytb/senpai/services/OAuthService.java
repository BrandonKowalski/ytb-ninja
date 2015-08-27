package ninja.ytb.senpai.services;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import io.kowalski.oaami.Oaami;
import ninja.ytb.senpai.security.OAuthUserToken;
import ninja.ytb.senpai.util.ConstantsUtility;

public class OAuthService {

	private final Logger LOGGER = LoggerFactory.getLogger(OAuthService.class);

	private final Oaami oaami;
	private final LoginService loginService;

	@Inject
	public OAuthService(final Oaami oaami, final LoginService loginService) {
		this.oaami = oaami;
		this.loginService = loginService;
	}

	public final Response handshake(final String tempCode, final String referer) {
		try {
			OAuthProviderType provider = oaami.refererToProvider(referer).orElseThrow(AuthenticationException::new);
			Optional<String> accessToken = oaami.retrieveToken(tempCode, provider);
			if (accessToken.isPresent()) {
				OAuthUserToken oAuthToken = new OAuthUserToken(accessToken.get(), provider.getProviderName());
				loginService.login(oAuthToken);
			}
		} catch (AuthenticationException e) {
			LOGGER.error(ConstantsUtility.ERROR_MESSAGES.getString("handeshakeError"), e);
			return Response.seeOther(ConstantsUtility.Redirects.AUTH_ERROR).build();
		}
		return Response.seeOther(ConstantsUtility.Redirects.HOME_PAGE).build();
	}
}
