package ninja.ytb.senpai.configuration;

import javax.persistence.Entity;

import org.reflections.Reflections;

import com.google.common.collect.ImmutableList;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;

public class SepaiHibernateBundle extends HibernateBundle<SenpaiConfiguration> {
	
	public SepaiHibernateBundle() {
		this(loadEntities(), new SessionFactoryFactory());
	}

	protected SepaiHibernateBundle(ImmutableList<Class<?>> entities, SessionFactoryFactory sessionFactoryFactory) {
		super(entities, sessionFactoryFactory);
	}

	public DataSourceFactory getDataSourceFactory(SenpaiConfiguration configuration) {
        return configuration.getDatabase();
    }
	
	private static ImmutableList<Class<?>> loadEntities() {
		Reflections reflections = new Reflections("ninja.ytb");
        return ImmutableList.copyOf(reflections.getTypesAnnotatedWith(Entity.class));
	}

}
