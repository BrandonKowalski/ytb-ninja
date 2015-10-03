package ninja.ytb.senpai.models;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import ninja.ytb.senpai.model.base.GenericEntity;

@NamedQueries({ @NamedQuery(name = "Status.All", query = "SELECT s FROM Status s") })

@Entity
@Table(name = "status")
public class Status extends GenericEntity {

	private static final long serialVersionUID = -8544400401302390885L;

	@ManyToOne
	private User user;

	@ManyToOne
	private Project project;

	private LocalDateTime submittedOn;
	private LocalDateTime statusDate;
	private LocalDateTime lastEdited;

	@OneToMany(targetEntity = Yesterday.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Yesterday> yesterdays;

	@OneToMany(targetEntity = Today.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Today> todays;

	@OneToMany(targetEntity = Blocker.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Blocker> blockers;

	public Status() {

	}

	@PrePersist
	private void prePersist() {
		final LocalDateTime now = LocalDateTime.now();
		if (this.getId() == null) {
			submittedOn = now;
		}
		lastEdited = now;
	}

	public final User getUser() {
		return user;
	}

	public final void setUser(final User user) {
		this.user = user;
	}

	public final Project getProject() {
		return project;
	}

	public final void setProject(final Project project) {
		this.project = project;
	}

	public final LocalDateTime getSubmittedOn() {
		return submittedOn;
	}

	public final void setSubmittedOn(final LocalDateTime submittedOn) {
		this.submittedOn = submittedOn;
	}

	public final LocalDateTime getStatusDate() {
		return statusDate;
	}

	public final void setStatusDate(final LocalDateTime statusDate) {
		this.statusDate = statusDate;
	}

	public final LocalDateTime getLastEdited() {
		return lastEdited;
	}

	public final void setLastEdited(final LocalDateTime lastEdited) {
		this.lastEdited = lastEdited;
	}

	public final Collection<Yesterday> getYesterdays() {
		return yesterdays;
	}

	public final void setYesterdays(final Collection<Yesterday> yesterdays) {
		this.yesterdays = yesterdays;
	}

	public final Collection<Today> getTodays() {
		return todays;
	}

	public final void setTodays(final Collection<Today> todays) {
		this.todays = todays;
	}

	public final Collection<Blocker> getBlockers() {
		return blockers;
	}

	public final void setBlockers(final Collection<Blocker> blockers) {
		this.blockers = blockers;
	}
}
