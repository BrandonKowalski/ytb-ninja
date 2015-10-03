package ninja.ytb.senpai.services;

import java.util.Optional;

import javax.ws.rs.core.Response;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import io.kowalski.oaami.Oaami;
import io.kowalski.oaami.OaamiProvider;
import io.kowalski.oaami.models.OaamiToken;
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

	public final Response handshake(final String tempCode, final OaamiProvider provider) {
		LOGGER.error("Start handshake");
		try {
			Optional<OaamiToken> token = oaami.retrieveToken(tempCode, provider);
			
			if (token.isPresent()) {
				// Optional<OaamiUserInfo> userInfo = new GoogleService().retrieveUserInfo(token.get());
				// if (userInfo.isPresent()) {
				// token.get().userInfo = userInfo;
				// }
				loginService.login(token.get());
			}
		} catch (AuthenticationException e) {
			LOGGER.error(ConstantsUtility.ERROR_MESSAGES.getString("handeshakeError"), e);
			return Response.seeOther(ConstantsUtility.Redirects.AUTH_ERROR).build();
		}
		LOGGER.error("End handshake");
		return Response.seeOther(ConstantsUtility.Redirects.HOME_PAGE).build();
	}
}
