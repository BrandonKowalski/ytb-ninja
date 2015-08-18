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
import ninja.ytb.senpai.models.Team;
import ninja.ytb.senpai.services.OrganizationalUnitService;

@SenpaiResource
@Path("/teams")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
	
	private final OrganizationalUnitService<Team> teamService;
	
	@Inject
	public TeamResource(final OrganizationalUnitService<Team> teamService) {
		this.teamService = teamService;
	}
	
	@POST
	@UnitOfWork
	public final Team createOrganization(final Team team) {
		return teamService.create(team);
	}
	
	@GET
	@UnitOfWork
	public final List<Team> fetchProjects() {
		return teamService.read("Team.All");
	}
}
