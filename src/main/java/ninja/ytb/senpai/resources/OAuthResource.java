package ninja.ytb.senpai.resources;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.services.OAuthService;

@SenpaiResource
@Path("/oauth")
@Produces(MediaType.APPLICATION_JSON)
public class OAuthResource {

	private final OAuthService oAuthService;

	@Inject
	public OAuthResource(final OAuthService oAuthService) {
		this.oAuthService = oAuthService;
	}

	@GET
	@UnitOfWork
	public final Response handshake(@QueryParam("code") final String code, final @HeaderParam("referer") String referer) {
		return oAuthService.handshake(code, referer);
	}
}
