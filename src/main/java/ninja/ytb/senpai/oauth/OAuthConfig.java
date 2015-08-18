package ninja.ytb.senpai.oauth;

public abstract class OAuthConfig {

	private String clientID;
	private String secretID;
	
	public final String getClientID() {
		return clientID;
	}
	public final void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public final String getSecretID() {
		return secretID;
	}
	public final void setSecretID(String secretID) {
		this.secretID = secretID;
	}	
}
