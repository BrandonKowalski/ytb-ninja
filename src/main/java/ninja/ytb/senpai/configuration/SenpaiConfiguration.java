package ninja.ytb.senpai.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class SenpaiConfiguration extends Configuration {
	
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

	public final DataSourceFactory getDatabase() {
		return database;
	}

	public final void setDatabase(DataSourceFactory database) {
		this.database = database;
	}
}
