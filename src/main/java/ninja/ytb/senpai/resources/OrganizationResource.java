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
import ninja.ytb.senpai.models.Organization;
import ninja.ytb.senpai.services.OrganizationalUnitService;

@SenpaiResource
@Path("/organizations")
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationResource {
	
	private final OrganizationalUnitService<Organization> organizationService;
	
	@Inject
	public OrganizationResource(final OrganizationalUnitService<Organization> organizationService) {
		this.organizationService = organizationService;
	}
	
	@POST
	@UnitOfWork
	public final Organization createOrganization(final Organization organization) {
		return (Organization) organizationService.create(organization);
	}
	
	@GET
	@UnitOfWork
	public final List<Organization> fetchOrganizations() {
		return organizationService.read("Organizations.All");
	}

}
