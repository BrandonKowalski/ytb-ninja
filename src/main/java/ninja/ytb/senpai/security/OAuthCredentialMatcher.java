package ninja.ytb.senpai.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class OAuthCredentialMatcher implements CredentialsMatcher {

	public boolean doCredentialsMatch(AuthenticationToken authToken, AuthenticationInfo authInfo) {
		return authToken.getCredentials().equals(authInfo.getCredentials());
	}
}
