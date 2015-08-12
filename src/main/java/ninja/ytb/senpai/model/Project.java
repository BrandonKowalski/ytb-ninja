package ninja.ytb.senpai.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project extends GenericEntity {

	private static final long serialVersionUID = -3488046703025375071L;
	
	private String name;
	private boolean publiclyVisible;
	
	@ManyToOne
	private Organization organization;
	
	@ManyToMany
	private List<User> owners;
	
	@OneToMany(mappedBy = "project")
	private List<Team> teams;

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final boolean isPubliclyVisible() {
		return publiclyVisible;
	}

	public final void setPubliclyVisible(final boolean publiclyVisible) {
		this.publiclyVisible = publiclyVisible;
	}

	public final Organization getOrganization() {
		return organization;
	}

	public final void setOrganization(final Organization organization) {
		this.organization = organization;
	}

	public final List<User> getOwners() {
		return owners;
	}

	public final void setOwners(final List<User> owners) {
		this.owners = owners;
	}

	public final List<Team> getTeams() {
		return teams;
	}

	public final void setTeams(final List<Team> teams) {
		this.teams = teams;
	}

}
