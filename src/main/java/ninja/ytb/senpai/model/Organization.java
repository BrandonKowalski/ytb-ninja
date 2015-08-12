package ninja.ytb.senpai.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization extends GenericEntity {

	private static final long serialVersionUID = 3102447266964981637L;
	
	public Organization() {
	}
	
	private String name;
	
	@ManyToMany
	private Set<User> admins;
	
	@ManyToMany
	private Set<User> members;
	
	@OneToMany
	private Set<Project> projects;

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final Set<User> getAdmins() {
		return admins;
	}

	public final void setAdmins(final Set<User> admins) {
		this.admins = admins;
	}

	public final Set<User> getMembers() {
		return members;
	}

	public final void setMembers(final Set<User> members) {
		this.members = members;
	}

	public final Set<Project> getProjects() {
		return projects;
	}

	public final void setProjects(final Set<Project> projects) {
		this.projects = projects;
	}
	
}
