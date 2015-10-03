package ninja.ytb.senpai.services;

import ninja.ytb.senpai.model.base.GenericEntity;

public abstract class AbstractService<T extends GenericEntity> {
	
	public abstract T upsert(final T entity);

}
