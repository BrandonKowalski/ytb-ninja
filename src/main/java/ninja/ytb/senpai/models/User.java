package ninja.ytb.senpai.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ninja.ytb.senpai.model.base.GenericEntity;
import ninja.ytb.senpai.oauth.OAuthToken;

@Entity
@Table(name = "siteuser")
public class User extends GenericEntity {

	private static final long serialVersionUID = 7743759966492135059L;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String username;
	
	private String fullname;
	
	@OneToMany(mappedBy = "user")
	private Collection<Membership> memberships;
	
	private boolean locked;
	
	@JsonIgnore
	@Transient
	private OAuthToken oAuthToken;

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String email) {
		this.email = email;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(final String username) {
		this.username = username;
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

	public final boolean isLocked() {
		return locked;
	}

	public final void setLocked(final boolean locked) {
		this.locked = locked;
	}

	public final OAuthToken getoAuthToken() {
		return oAuthToken;
	}

	public final void setoAuthToken(final OAuthToken oAuthToken) {
		this.oAuthToken = oAuthToken;
	}
}
