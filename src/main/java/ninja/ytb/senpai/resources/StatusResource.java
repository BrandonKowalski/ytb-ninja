package ninja.ytb.senpai.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import ninja.ytb.senpai.annotations.SenpaiResource;

@SenpaiResource
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
	
	public StatusResource() {
		
	}
	
	@GET
    @Timed
    public String sayHello() {
        return new String("Hello world");
    }
}
