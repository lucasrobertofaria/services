package br.gov.prodemge.service.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;

public class JWTUtil {

	private static String key = "SECRET_TOKEN";
	private static Algorithm algorithm = Algorithm.HMAC256(key);
	private static int TIME_EXPIRATION_MINUTES = 1 * 60;
	private static int TIME_EXPIRATION_MILISECONDS = 1000 * TIME_EXPIRATION_MINUTES;

	public static final String TOKEN_HEADER = "Authentication";

	public static String create(String subject) {
		JWTCreator.Builder builder = com.auth0.jwt.JWT.create();
		builder.withJWTId(subject);
		builder.withExpiresAt(new Date(new Date().getTime() + TIME_EXPIRATION_MILISECONDS));
		return builder.sign(algorithm);

	}

	public static String decode(String token) {
		return JWT.decode(token).getId();
	}

	public static boolean validate(String token) {
		JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(TIME_EXPIRATION_MINUTES).build();
		try {
		if (verifier.verify(token) != null)
			return true;
		else
			return false;
		}catch (TokenExpiredException e) {
			//token expirado
			return false;
		}
	}
}
