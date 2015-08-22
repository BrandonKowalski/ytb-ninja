package ninja.ytb.senpai.resources;

import java.net.URI;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.oauth.OAuthToken;
import ninja.ytb.senpai.services.LoginService;
import ninja.ytb.senpai.services.OAuthService;

@SenpaiResource
@Path("/oauth")
@Produces(MediaType.APPLICATION_JSON)
public class OAuthResource {

	private final Logger LOGGER = LoggerFactory.getLogger(OAuthResource.class);
	
	private final OAuthService oAuthService;
	private final LoginService loginService;
	
	@Inject
	public OAuthResource(final OAuthService oAuthService, final LoginService loginService) {
		this.oAuthService = oAuthService;
		this.loginService = loginService;
	}

	@GET
	@Path("/github")
	@UnitOfWork
	public final Response github(@QueryParam("code") final String code) {
		URI redirect = null;
		try {
			Optional<String> accessToken = oAuthService.retrieveGithubToken(code);

			if (accessToken.isPresent()) {
				OAuthToken oAuthToken = new OAuthToken(accessToken.get(), OAuthProviderType.GITHUB.getProviderName());
				loginService.login(oAuthToken);
			}
			
			redirect = new URI("/demo");

		} catch (Exception e) {
			LOGGER.error("Unable to complete OAuth Handshake", e);
		}
		return Response.seeOther(redirect).build();
	}
}
