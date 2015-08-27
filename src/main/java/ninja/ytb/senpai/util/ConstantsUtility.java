package ninja.ytb.senpai.util;

import java.net.URI;
import java.util.Locale;
import java.util.ResourceBundle;

public final class ConstantsUtility {
	
	public static final ResourceBundle ERROR_MESSAGES = 
			ResourceBundle.getBundle("ErrorMessages", Locale.ENGLISH);

	public static final String ORGANIZATION_DISCRIMINATOR = "ORGANIZATION";
	public static final String PROJECT_DISCRIMINATOR = "PROJECT";
	public static final String TEAM_DISCRIMINATOR = "TEAM";
	
	public static final String OAUTH_REALM_NAME = "OAUTH";
	
	public static final class Redirects {
		public static final URI ROOT_PAGE = URI.create("/");
		public static final URI HOME_PAGE = URI.create("/demo");
		public static final URI AUTH_ERROR = URI.create("/oauth/error");
	}
}
