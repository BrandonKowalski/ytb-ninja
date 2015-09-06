package ninja.ytb.senpai.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.secnod.dropwizard.shiro.ShiroConfiguration;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.kowalski.oaami.OaamiProvider;
import io.kowalski.oaami.config.OAuthConfig;

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
    @JsonProperty("oauth")
    private Map<OaamiProvider, OAuthConfig> oauthProviders = new HashMap<OaamiProvider, OAuthConfig>();

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

	public final Map<OaamiProvider, OAuthConfig> getOauthProviders() {
		return oauthProviders;
	}

	public final void setOauthProviders(final Map<OaamiProvider, OAuthConfig> oauthProviders) {
		this.oauthProviders = oauthProviders;
	}
}
