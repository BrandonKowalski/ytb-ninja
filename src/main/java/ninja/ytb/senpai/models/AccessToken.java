package ninja.ytb.senpai.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import ninja.ytb.senpai.model.base.GenericEntity;

@NamedQueries({
    @NamedQuery(name = "AccessToken.RetrieveByToken", query = "SELECT at FROM AccessToken at WHERE token = :token AND provider = :provider AND active = true")
})

@Entity
@Table(name = "access_token")
public class AccessToken extends GenericEntity {

	private static final long serialVersionUID = -5371398165910126114L;

	public AccessToken() {
	}
	
	@ManyToOne
	private User user;
	
	private String token;
	private String provider;

	public final User getUser() {
		return user;
	}
	
	public final void setUser(final User user) {
		this.user = user;
	}
	
	public final String getToken() {
		return token;
	}
	
	public final void setToken(final String token) {
		this.token = token;
	}
	
	public final String getProvider() {
		return provider;
	}
	
	public final void setProvider(final String provider) {
		this.provider = provider;
	}
}
