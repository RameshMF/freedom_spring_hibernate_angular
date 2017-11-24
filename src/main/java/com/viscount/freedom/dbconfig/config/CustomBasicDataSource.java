package com.viscount.freedom.dbconfig.config;

import java.io.IOException;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.codec.Base64;

import sun.misc.BASE64Decoder;

public class CustomBasicDataSource extends DriverManagerDataSource{

	public CustomBasicDataSource() {
        super();
    }

	@Override
	public String getPassword() {
		String password = super.getPassword();
		return decode(password);
	}
	
    private static String decode(final String password) {
    	BASE64Decoder base64Decoder = new BASE64Decoder();
        String decodedPassword = null;
        try {
            decodedPassword = new String(base64Decoder.decodeBuffer(password));
        } catch (IOException e) {
            e.printStackTrace();
        }       
        return decodedPassword;
    }
}
