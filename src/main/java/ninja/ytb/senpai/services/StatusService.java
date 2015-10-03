package ninja.ytb.senpai.services;

import java.util.List;

import com.google.inject.Inject;

import ninja.ytb.senpai.dao.StatusDAO;
import ninja.ytb.senpai.models.Status;

public class StatusService extends AbstractService<Status> {
	
	private final StatusDAO statusDAO;
	
	@Inject
	public StatusService(final StatusDAO statusDAO) {
		this.statusDAO = statusDAO;
	}
	
	public final Status upsert(final Status status) {
		return statusDAO.upsert(status);
	}
	
	public final List<Status> retreiveStatuses() {
		return statusDAO.read("Status.All");
	}
	
}
