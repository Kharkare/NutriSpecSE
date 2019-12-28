package com.nutrispec.nutrispecapp;

import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Priority;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Provider
@JWTAuthentication
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("c2VjcmV0");//this has to be base-64 encoded, it reads 'secret' if we de-encoded it
    	Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
    	
        // Get the HTTP Authorization header from the request
    	
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Extract the token from the HTTP Authorization header

        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {

            // Validate the token

            Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);

            System.out.println("#### valid token : " + token);

        } catch (Exception e) {

        	System.out.println("#### invalid token : " + token);

            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());

        }

	}

}
