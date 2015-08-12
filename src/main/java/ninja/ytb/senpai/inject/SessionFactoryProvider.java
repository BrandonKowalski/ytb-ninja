package ninja.ytb.senpai.inject;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import io.dropwizard.hibernate.HibernateBundle;
import ninja.ytb.senpai.configuration.SenpaiConfiguration;

@Singleton
public class SessionFactoryProvider implements Provider<SessionFactory> {

	private final HibernateBundle<SenpaiConfiguration> hibernateBundle;
	
	@Inject
	public SessionFactoryProvider(@Named("HibernateBundle") final HibernateBundle<SenpaiConfiguration> hibernateBundle) {
		this.hibernateBundle = hibernateBundle;
	}
	
	public final SessionFactory get() {
		return hibernateBundle.getSessionFactory();
	}
}
