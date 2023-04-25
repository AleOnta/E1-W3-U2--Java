package com.api_rest.auth.configuration;

import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Converter
@Slf4j
public class BuildingCodeConverter implements AttributeConverter<String, String> {

	private static final String ALGORITHM = "AES/CFB/PKCS5Padding";
	private static final byte[] KEY = "MySuperSecretKey".getBytes(); 
	
	@Override
	public String convertToDatabaseColumn(String attribute) {
		Key key = new SecretKeySpec(KEY, "AES");
		
		try {
			Cipher cy = Cipher.getInstance(ALGORITHM);
			cy.init(Cipher.ENCRYPT_MODE, key);
			return Base64.getEncoder().encodeToString(cy.doFinal(attribute.getBytes()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		Key key = new SecretKeySpec(KEY, "AES");
		
		try {
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			return new String (c.doFinal(Base64.getDecoder().decode(dbData.getBytes())));
		} catch (Exception e) {
			log.error("error while trying decrypting Building security code");
			log.error("current state of code: " + dbData);
			throw new RuntimeException(e);
		}
	}

}
