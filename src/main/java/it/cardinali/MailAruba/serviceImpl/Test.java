package it.cardinali.MailAruba.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String uno = "F9F60A2118920C7E0AA5424B5EE1AA72972D5B161C245A9C487E35C812A8A837"; 
		
		Test t = new Test();
		
		if(uno.equalsIgnoreCase(t.testaHash())) {
			System.out.println("ciaoooooooo");
		}
		
	}

	
	
	
	private String testaHash() throws NoSuchAlgorithmException {
		String originalString ="ri345rio";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(
		  originalString.getBytes(StandardCharsets.UTF_8));
		String sha256hex = new String(Hex.encode(hash));
		System.out.println(sha256hex);
		return sha256hex;
	}
	
}
