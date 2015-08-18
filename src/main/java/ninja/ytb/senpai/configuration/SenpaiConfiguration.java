package ninja.ytb.senpai.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.secnod.dropwizard.shiro.ShiroConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import ninja.ytb.senpai.oauth.GithubOAuthConfig;

public class SenpaiConfiguration extends Configuration {
	
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();
    
    @Valid
    @NotNull
    @JsonProperty("shiro")
    private ShiroConfiguration shiro = new ShiroConfiguration();
    
    @Valid
    @NotNull
    @JsonProperty("github")
    private GithubOAuthConfig githubConfig = new GithubOAuthConfig();

	public final DataSourceFactory getDatabase() {
		return database;
	}

	public final void setDatabase(final DataSourceFactory database) {
		this.database = database;
	}

	public final ShiroConfiguration getShiro() {
		return shiro;
	}

	public final void setShiro(final ShiroConfiguration shiro) {
		this.shiro = shiro;
	}

	public final GithubOAuthConfig getGithubConfig() {
		return githubConfig;
	}

	public final void setGithubConfig(final GithubOAuthConfig githubConfig) {
		this.githubConfig = githubConfig;
	}
}
