package ninja.ytb.senpai;

import org.reflections.Reflections;

import com.google.common.collect.ImmutableList;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ninja.ytb.senpai.annotations.SenpaiResource;
import ninja.ytb.senpai.configuration.SenpaiConfiguration;
import ninja.ytb.senpai.configuration.SepaiHibernateBundle;

public class Senpai extends Application<SenpaiConfiguration> {

	public static void main(String[] args) throws Exception {
		new Senpai().run(args);
	}
	
    @Override
    public void initialize(final Bootstrap<SenpaiConfiguration> bootstrap) {
       bootstrap.addBundle(new SepaiHibernateBundle());
    }
	
	@Override
	public void run(final SenpaiConfiguration configuration, final Environment environment) throws Exception {	
		bindResources(environment);
	}
	
	private static void bindResources(final Environment environment) {
		Reflections reflections = new Reflections("ninja.ytb.senpai");
        ImmutableList<Class<?>> resources = ImmutableList.copyOf(reflections.getTypesAnnotatedWith(SenpaiResource.class));
        for (Class<?> resource : resources) {
        	environment.jersey().register(resource);
        }    
	}
}
