package ninja.ytb.senpai.util;

public final class ConstantsUtility {
	
	public static final String GITHUB_REDIRECT_URL = "http://localhost:8080/oauth/github";

	public static final String ORGANIZATION_DISCRIMINATOR = "ORGANIZATION";
	public static final String PROJECT_DISCRIMINATOR = "PROJECT";
	public static final String TEAM_DISCRIMINATOR = "TEAM";
	
	public static final String ENTITY_ID_FIELD_NAME = "id";
	
	public static final String OAUTH_REALM_NAME = "OAUTH";
	
	public final class OAuthEndpoints {
		public static final String GITHUB_API_ROOT = "https://api.github.com";
		public static final String GITHUB_API_USER_EMAILS = GITHUB_API_ROOT + "/user/emails";	
	}
}
