package com.viscount.freedom.util;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class FieldVerifier {
	
	/**
	 * This method check for null object and return empty string
	 * @param object
	 * @return {@link String}
	 */
	public static String checkNull(Object object){
		String value = "";
		if(object != null){
			value = object.toString();
		}
		return value;
	}

	/**
	 * This method check long long value
	 * @param value
	 * @return {@link Long}
	 */
	public static Long checkLong(String value) {
		if(value == null)
			return null;
		return Long.valueOf(value);
	}
	
	/**
	 * THis method is used to check null value for setting non null long value to preparedStatement
	 * @param preparedStatement
	 * @param index
	 * @param value
	 * @throws SQLException
	 */
	public static void setLongValue(final PreparedStatement preparedStatement, int index, Long value) throws SQLException{
		if(value == null){
			preparedStatement.setNull(index, Types.BIGINT);
		} else {
			preparedStatement.setLong(index, value);	
		}
	}
	
	/**
	 * This method is used to get current sql date
	 * @return {@link Date}
	 */
	public static Date getCurrentDate() {
		return new Date(Calendar.getInstance().getTimeInMillis());
	}
	
	/**
	 * This method is used encode password of user using BCryptPasswordEncoder
	 * @return {@link String}
	 */
	public static String passwordEncoder(String password){
		String encryptedPasssword = null;
		if(password != null){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			encryptedPasssword = passwordEncoder.encode(password);
		}
		return encryptedPasssword;	
	}
	
	public static String passwordDecoder(String password){
		String encryptedPasssword = null;
		if(password != null){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			encryptedPasssword = passwordEncoder.encode(password);
		}
		return encryptedPasssword;	
	}
	
	public static void main(String[] args){

		System.out.println(getCurrentDate());
	
	}
}
