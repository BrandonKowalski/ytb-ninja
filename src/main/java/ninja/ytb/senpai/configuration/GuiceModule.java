package ninja.ytb.senpai.configuration;

import java.util.Map;

import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import io.dropwizard.hibernate.HibernateBundle;
import io.kowalski.oaami.config.OAuthConfig;
import ninja.ytb.senpai.inject.SessionFactoryProvider;

@Singleton
public class GuiceModule extends AbstractModule {

	private final HibernateBundle<SenpaiConfiguration> hibernateBundle;

	public GuiceModule(final HibernateBundle<SenpaiConfiguration> hibernateBundle) {
		this.hibernateBundle = hibernateBundle;
	}

	@Override
	protected void configure() {
		bind(new TypeLiteral<HibernateBundle<SenpaiConfiguration>>() {
		}).annotatedWith(Names.named("HibernateBundle")).toInstance(hibernateBundle);

		bind(SessionFactory.class).toProvider(SessionFactoryProvider.class);
	}

	@Provides
	public Map<String, OAuthConfig> providesSomethingThatNeedsConfiguration(SenpaiConfiguration configuration) {
		return configuration.getOauthProviders();
	}
}
