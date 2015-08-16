package ninja.ytb.senpai.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ninja.ytb.senpai.model.base.GenericEntity;

@Entity
@Table(name = "siteuser")
public class User extends GenericEntity {

	private static final long serialVersionUID = 7743759966492135059L;
	
	@Column(unique = true)
	private String email;
	
	private String fullname;
	
	@OneToMany(mappedBy = "user")
	private Collection<Membership> memberships;

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

	public final Collection<Membership> getMemberships() {
		return memberships;
	}

	public final void setMemberships(final Collection<Membership> memberships) {
		this.memberships = memberships;
	}
}
