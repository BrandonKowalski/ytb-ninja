package ninja.ytb.senpai;

import org.eclipse.jetty.server.session.SessionHandler;
import org.secnod.dropwizard.shiro.ShiroBundle;
import org.secnod.dropwizard.shiro.ShiroConfiguration;

import com.hubspot.dropwizard.guice.GuiceBundle;

import io.dropwizard.Application;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import ninja.ytb.senpai.configuration.GuiceModule;
import ninja.ytb.senpai.configuration.SenpaiConfiguration;
import ninja.ytb.senpai.configuration.SepaiHibernateBundle;

public class Senpai extends Application<SenpaiConfiguration> {

	private final HibernateBundle<SenpaiConfiguration> hibernateBundle;
	private final GuiceModule guiceModule;
	
	private final ShiroBundle<SenpaiConfiguration> shiro = new ShiroBundle<SenpaiConfiguration>() {
        @Override
        protected ShiroConfiguration narrow(SenpaiConfiguration configuration) {
            return configuration.getShiro();
        }
    };

	private Senpai() {
		this.hibernateBundle = new SepaiHibernateBundle();
		this.guiceModule = new GuiceModule(hibernateBundle);
	}

	public static void main(String[] args) throws Exception {
		new Senpai().run(args);
	}

	@Override
	public void initialize(final Bootstrap<SenpaiConfiguration> bootstrap) {
		bootstrap.addBundle(hibernateBundle);
		bootstrap.addBundle(shiro);
		bootstrap.addBundle(new ViewBundle<SenpaiConfiguration>());
		bootstrap.addBundle(GuiceBundle.<SenpaiConfiguration> newBuilder()
				.addModule(guiceModule)
				.setConfigClass(SenpaiConfiguration.class)
				.enableAutoConfig(getClass().getPackage().getName())
				.build());
	}

	@Override
	public void run(final SenpaiConfiguration configuration, final Environment environment) throws Exception {
		environment.getApplicationContext().setSessionHandler(new SessionHandler());
	}
}
