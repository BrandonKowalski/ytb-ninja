package ninja.ytb.senpai.util;

import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.JwtContext;
import org.jose4j.keys.HmacKey;

public class JWTTest {

	public static void main(String[] args) throws InvalidJwtException {
		
		String pubKey = "\nMIIDJjCCAg6gAwIBAgIIU/nzIOmlc6YwDQYJKoZIhvcNAQEFBQAwNjE0MDIGA1UE\nAxMrZmVkZXJhdGVkLXNpZ25vbi5zeXN0ZW0uZ3NlcnZpY2VhY2NvdW50LmNvbTAe\nFw0xNTA4MjUxNTI4MzRaFw0xNTA4MjcwNDI4MzRaMDYxNDAyBgNVBAMTK2ZlZGVy\nYXRlZC1zaWdub24uc3lzdGVtLmdzZXJ2aWNlYWNjb3VudC5jb20wggEiMA0GCSqG\nSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC5+aEV9knwP1NkgaqVZ+lWUD1V+0B0Rain\nvUbjGeg8LpGTtEg4cbk/n21Wp0D+4g2A7OpZ3gNkOLJqPBlT5KjHAZSN+uKMGyB7\n5SX8dPBUzSTACiuLNKb3v76t16szdv0rORq0mqLOYgbsObsDTpRIxYaVJ5Mqz9Fg\nMUYztBladxBW+0Ji79cl+5zQMJrU/IAXPCYGsSWK/S1kSiBZSJ6fQdD3lj4QmvFv\n4KAq3t93eB8jTAAm2D6HtDJlZfhQfxp7dWd95Rmnp2DtIuzB83FzZbtR1ODA5qiS\nTHNE2rmqbMhPoLP68yOX8x/pVouvt7hjfnu/BTOqH2iiX4MOUSNXAgMBAAGjODA2\nMAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQMMAoGCCsG\nAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQAvN6kXWa+KjEFLIRbOmJgTSMENePJo\nIwygvFi+g8tPAU428GxznIS51oATnAcqkK4fMNdMvonGwCkW0wWuijfGLT5XJwDL\nas5MqkZV3IbYG5XwMjXqObN4vUhUEyQy5WTeYFA19yBPj8FMQ2sj3ZKtuUl7JIEX\n882J2oJzsL026nC6p3p49jkCMwiHjq6rremveSzjEOBpFjjyv3KYCPnUx9aoiRGb\nef2KcX0CyPAd0PD/kRDJScahcE9VbpdnQRJ9RUYlZlERFBg/ez7WTVlZfY3lZIo7\nwlzQQlmMaeaJa8UW8ItF2hYpo6xxVa339jt+Dem3+eWBXepwruMaEKi6\n";
		
		JwtConsumer jwtConsumer = new JwtConsumerBuilder()
	            .setRequireSubject() // the JWT must have a subject claim
	            .setExpectedIssuer("accounts.google.com") // whom the JWT needs to have been issued by
	            .setExpectedAudience("219289209550-gccet6uh1nr5252ssik3mp99ktep410p.apps.googleusercontent.com") // to whom the JWT is intended for
	            .setVerificationKey(new RSAS(pubKey.getBytes()))
	            .build();

		JwtContext ctx = jwtConsumer.process("eyJhbGciOiJSUzI1NiIsImtpZCI6ImU1MmY2OGE2YzFkMDRkMTQ1MWM4NDM3YzMxOWVkMWViMjQyNWYzYTIifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXRfaGFzaCI6InFieEJ3ZXBmck1SWnNGMEtJblpCTnciLCJhdWQiOiIyMTkyODkyMDk1NTAtZ2NjZXQ2dWgxbnI1MjUyc3NpazNtcDk5a3RlcDQxMHAuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDM5NTYzMTI0NTEzNjQwMjQ3NDEiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXpwIjoiMjE5Mjg5MjA5NTUwLWdjY2V0NnVoMW5yNTI1MnNzaWszbXA5OWt0ZXA0MTBwLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiaGQiOiJrb3dhbHNraS5pbyIsImVtYWlsIjoiYnJhbmRvbkBrb3dhbHNraS5pbyIsImlhdCI6MTQ0MDU1NTU5NSwiZXhwIjoxNDQwNTU5MTk1fQ.OwLup3Xh4TzfzbemHarzs6IWpRv-nryxZYW2ozxMQzbstDlebZnn9w-plVYLnO1dL8BPh-axKTT7hgE7dW-FKXuRmY303XzzatElIvLLTMevfKWToDYQvuFy1exs-rz30SJmLz-xbVdzXoMYWJnY17EMP5KiFpqr2EbZnyqXBQgLAQHjL2Ic0JWFm26sJO6Iwgiv9mV_oEl9i1IFLnxXNFnDfji1z3J_Lu70DP7RPUiZ50LzzKDMt1ruOa-UV5tfxgwRVObPUlfiAsAGOfrPEdJw_7TQ5I3YyhX5R_4Jl6IYgvtyIC0VEvHtKIlIG2_4ROasLlUbaCG1hLzw8dsWtw");
		System.out.println(ctx.getJwtClaims().getClaimValue("sub"));
	}

}
