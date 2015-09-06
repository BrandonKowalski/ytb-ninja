package ninja.ytb.senpai.views;

import com.google.inject.Singleton;

import io.dropwizard.views.View;

@Singleton
public class LoginView extends View {
	
	public LoginView() {
		super("login.mustache");
	}

}
