package com.nutrispec.nutrispecapp.resources;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.DatatypeConverter;

import com.nutrispec.nutrispecapp.JWTAuthentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/users")
public class Login {
	
    
    
    @Context
    private UriInfo uriInfo;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@QueryParam("login") String login,
    								@QueryParam("password") String password) {

        try {

            // Authenticate the user using the credentials provided

            //authenticate(login, password);

            // Issue a token for the user

            String token = issueToken(login);

            // Return the token on the response

            return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {

            return Response.status(Response.Status.UNAUTHORIZED).build();

        }

    }

    private String issueToken(String login) {
    	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("c2VjcmV0");//this has to be base-64 encoded, it reads 'secret' if we de-encoded it
    	Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, signingKey)
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .compact();

        return jwtToken;

    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
    @GET
    @Path("/jwt")
    @JWTAuthentication
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }

}
