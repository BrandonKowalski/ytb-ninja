package ninja.ytb.senpai.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;

import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.util.ConstantsUtility;

@SenpaiResource
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {
	
	@Inject
	public RootResource() {
	}

	@GET
	@Path("/logout")
	public final Response logout() {
		SecurityUtils.getSubject().logout();
		return Response.seeOther(ConstantsUtility.Redirects.ROOT_PAGE).build(); 
	}
}
