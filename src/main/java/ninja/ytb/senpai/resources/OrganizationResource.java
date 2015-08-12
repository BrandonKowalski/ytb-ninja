package ninja.ytb.senpai.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.inject.Inject;

import io.dropwizard.hibernate.UnitOfWork;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.dao.OrganizationDAO;
import ninja.ytb.senpai.model.Organization;

@SenpaiResource
@Path("/organization")
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationResource {
	
	private final OrganizationDAO dao;
	
	@Inject
	public OrganizationResource(final OrganizationDAO dao) {
		this.dao = dao;
	}
	
	@POST
	@UnitOfWork
	public final Organization createOrganization(final Organization organization) {
		return dao.create(organization);
	}

}
