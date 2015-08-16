package ninja.ytb.senpai.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ninja.ytb.senpai.model.base.GenericEntity;

@Entity
@Table(name = "status")
public class Status extends GenericEntity {

	private static final long serialVersionUID = -8544400401302390885L;

	public Status() {
	}
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Team team;
	
	private LocalDateTime submittedOn;
	private LocalDateTime statusDate;
	private LocalDateTime lastEdited;
	
	@ElementCollection(targetClass=String.class)
	private List<String> yesterday;
	
	@ElementCollection(targetClass=String.class)
	private List<String> today;
	
	@ElementCollection(targetClass=String.class)
	private List<String> blockers;

	public final User getUser() {
		return user;
	}

	public final void setUser(final User user) {
		this.user = user;
	}

	public final Team getTeam() {
		return team;
	}

	public final void setTeam(final Team team) {
		this.team = team;
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

	public final List<String> getYesterday() {
		return yesterday;
	}

	public final void setYesterday(final List<String> yesterday) {
		this.yesterday = yesterday;
	}

	public final List<String> getToday() {
		return today;
	}

	public final void setToday(final List<String> today) {
		this.today = today;
	}

	public final List<String> getBlockers() {
		return blockers;
	}

	public final void setBlockers(final List<String> blockers) {
		this.blockers = blockers;
	}
}
