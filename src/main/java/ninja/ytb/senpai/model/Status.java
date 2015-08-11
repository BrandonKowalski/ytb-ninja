package ninja.ytb.senpai.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
	
	public Status() {
	}
	
	@Id
	public long id;
	
	@ElementCollection(targetClass=String.class)
	public List<String> yesterday;
	
	@ElementCollection(targetClass=String.class)
	public List<String> today;
	
	@ElementCollection(targetClass=String.class)
	public List<String> blockers;
	
	public final long getId() {
		return id;
	}
	
	public final void setId(final long id) {
		this.id = id;
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
