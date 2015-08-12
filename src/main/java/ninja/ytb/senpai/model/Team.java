package ninja.ytb.senpai.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team extends GenericEntity {

	private static final long serialVersionUID = 7412914772548256588L;
	
	private String name;
	private boolean publiclyVisible;
	
	@ManyToMany
	private List<User> leads;
	
	@ManyToMany
	private List<User> members;
	
	@ManyToOne
	private Project project;

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

	public final List<User> getLeads() {
		return leads;
	}

	public final void setLeads(final List<User> leads) {
		this.leads = leads;
	}

	public final List<User> getMembers() {
		return members;
	}

	public final void setMembers(List<User> members) {
		this.members = members;
	}

	public final Project getProject() {
		return project;
	}

	public final void setProject(final Project project) {
		this.project = project;
	}

}
