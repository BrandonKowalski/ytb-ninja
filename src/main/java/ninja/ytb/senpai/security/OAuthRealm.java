package ninja.ytb.senpai.security;

import java.util.Collections;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import ninja.ytb.senpai.models.User;
import ninja.ytb.senpai.oauth.OAuthToken;
import ninja.ytb.senpai.util.ConstantsUtility;

public class OAuthRealm extends AuthorizingRealm {

	@Override
	public boolean supports(final AuthenticationToken token) {
		return token instanceof OAuthToken;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		User user = (User) token.getPrincipal();

		if (user == null) {
			throw new UnknownAccountException("User doesn't exist in local database");
		} else if (!user.isActive()) {
			throw new LockedAccountException("This account is inactive. Please contact your univFeed administrator.");
		} else if (user.isLocked()) {
			throw new LockedAccountException("This account is locked. Please contact your univFeed administrator.");
		}

		SimplePrincipalCollection principles = new SimplePrincipalCollection();
		principles.add(user, ConstantsUtility.OAUTH_REALM_NAME);
		return new SimpleAuthenticationInfo(principles, token.getCredentials());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		return new SimpleAuthorizationInfo(Collections.emptySet());
	}
}
