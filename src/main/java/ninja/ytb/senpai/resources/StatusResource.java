package ninja.ytb.senpai.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.models.Status;
import ninja.ytb.senpai.services.StatusService;

@SenpaiResource
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
	
	private final StatusService statusService;
	
	@Inject
	public StatusResource(final StatusService statusService) {
		this.statusService = statusService;
	}
	
	@POST
	@UnitOfWork
	public final Status createStatus(final Status status) {
		return statusService.upsert(status);
	}
	
	@GET
	@UnitOfWork
	public final List<Status> fetchStatuses() {
		return statusService.retreiveStatuses();
	}
	
}
