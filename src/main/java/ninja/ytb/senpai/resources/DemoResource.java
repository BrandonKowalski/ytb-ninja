package ninja.ytb.senpai.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;

import com.google.inject.Inject;

import ninja.ytb.senpai.annotations.RequiresAuthentication;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.models.User;

@SenpaiResource
@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {
	
	@Inject
	public DemoResource() {
	}
	
	@GET
	@RequiresAuthentication
	public final User getCurrentUser() {	
		return (User) SecurityUtils.getSubject().getPrincipal();
	}
}
