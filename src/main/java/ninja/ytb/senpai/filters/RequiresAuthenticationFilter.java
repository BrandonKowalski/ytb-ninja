package ninja.ytb.senpai.filters;

import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.shiro.SecurityUtils;

import ninja.ytb.senpai.annotations.RequiresAuthentication;
import ninja.ytb.senpai.util.ConstantsUtility;

@Provider
@RequiresAuthentication
public class RequiresAuthenticationFilter implements ContainerRequestFilter {
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			throw new WebApplicationException(ConstantsUtility.ERROR_MESSAGES.getString("authenticateRequired"),
					Response.Status.UNAUTHORIZED);
		}
	}
}
