package ninja.ytb.senpai.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ninja.ytb.senpai.model.base.OrganizationalUnit;
import ninja.ytb.senpai.models.Membership.MembershipId;

@Entity
@IdClass(MembershipId.class)
public class Membership implements Serializable {
	
	private static final long serialVersionUID = 617277742451370782L;

	@Id
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "organizational_unit")
	private OrganizationalUnit organizationalUnit;

	private Character role;

	public final User getUser() {
		return user;
	}

	public final void setUser(final User user) {
		this.user = user;
	}

	public final OrganizationalUnit getOrganizationaUnit() {
		return organizationalUnit;
	}

	public final void setOrganizationaUnit(final OrganizationalUnit organizationalUnit) {
		this.organizationalUnit = organizationalUnit;
	}

	public final Character getRole() {
		return role;
	}

	public final void setRole(final Character role) {
		this.role = role;
	}

	@Embeddable
	protected class MembershipId implements Serializable {
		private static final long serialVersionUID = -4922186818746430023L;

		@Column(name = "user")
		private UUID user;

		@Column(name = "organizational_unit")
		private UUID organizationalUnit;

		public final UUID getUser() {
			return user;
		}

		public final void setUser(final UUID user) {
			this.user = user;
		}

		public final UUID getOrganizationalUnit() {
			return organizationalUnit;
		}

		public final void setOrganizationalUnit(final UUID organizationalUnit) {
			this.organizationalUnit = organizationalUnit;
		}
	}
}
