package ninja.ytb.senpai.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "siteuser")
public class User extends GenericEntity {

	private static final long serialVersionUID = 7743759966492135059L;
	
	@Column(unique = true)
	private String email;
	
	private String fullname;
	
	@OneToMany
	private Set<Organization> organizations;

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String email) {
		this.email = email;
	}

	public final String getFullname() {
		return fullname;
	}

	public final void setFullname(final String fullname) {
		this.fullname = fullname;
	}

	public final Set<Organization> getOrganizations() {
		return organizations;
	}

	public final void setOrganizations(final Set<Organization> organizations) {
		this.organizations = organizations;
	}

}
