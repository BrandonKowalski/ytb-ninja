package ninja.ytb.senpai.dao;

import java.util.UUID;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;

import ninja.ytb.senpai.models.Status;

public class StatusDAO extends AbstractSenpaiDAO<Status, UUID> {

	@Inject
	public StatusDAO(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
