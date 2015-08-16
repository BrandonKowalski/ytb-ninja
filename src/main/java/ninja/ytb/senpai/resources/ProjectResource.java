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
import ninja.ytb.senpai.models.Project;
import ninja.ytb.senpai.services.OrganizationalUnitService;

@SenpaiResource
@Path("/projects")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectResource {
	
	private final OrganizationalUnitService<Project> projectService;
	
	@Inject
	public ProjectResource(final OrganizationalUnitService<Project> projectService) {
		this.projectService = projectService;
	}
	
	@POST
	@UnitOfWork
	public final Project createOrganization(final Project project) {
		return projectService.create(project);
	}
	
	@GET
	@UnitOfWork
	public final List<Project> fetchProjects() {
		return projectService.read("Projects.All");
	}

}
