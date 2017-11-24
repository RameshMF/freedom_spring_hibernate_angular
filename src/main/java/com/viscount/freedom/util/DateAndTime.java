package com.viscount.freedom.util;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * DateAndTime is the Date and Time manipulation utility.
 * 
 * @author Aloha
 * 
 */
public class DateAndTime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constants
	 */
	public static final String GMT = "GMT";
	public static final String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

	/**
	 * Returns Current Date And Time in String format.
	 * 
	 * @return String
	 */
	public String getCurrentDateAndTime() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		return dateFormat.format(date);
	}

	/**
	 * Returns Previous Date And Time For given Hours value in String format.
	 * 
	 * @param hours
	 * @return String
	 */
	public String getPreviousDateAndTimeForHours(int hours) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, -hours);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Returns Previous Date And Time For given Day value in String format.
	 * 
	 * @param day
	 * @return String
	 */
	public String getPreviousDateAndTimeForDay(int day) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -day);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Returns Previous Date And Time For given Day value in String format.
	 * 
	 * @param day
	 * @return String
	 */
	public String getPreviousDateForDay(int day) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -day);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Returns Previous Month Date For given months value in String format.
	 * 
	 * @param months
	 * @return String
	 */
	public String getPreviousMonthDate(int months) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -months);
		return dateFormat.format(cal.getTime());
	}

	/**
	 * Returns Previous Month Date For given months value in String format.
	 * 
	 * @param months
	 * @return String
	 */
	public String getNewTimeByHour(int months) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, months);
		return dateFormat.format(cal.getTime());
	}

	
	
	public static String getDateAsString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		return dateFormat.format(date);
	}
	
	public static String getDateAndTimeAsString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		return dateFormat.format(date);
	}
	
	/**
	 * Returns Current Date in String format.
	 * 
	 * @return String
	 */
	public String getCurrentDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		return dateFormat.format(date);
	}
	
	
	public String getCurrentDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		return dateFormat.format(date);
	}

	/**
	 * Returns Current Date in String format.
	 * 
	 * @return String
	 */
	public String getCurrDate() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
		return dateFormat.format(date);
	}

	/**
	 * Returns date String in Date format.
	 * 
	 * @param value
	 * @param fromFormat
	 * @param toFormat
	 * @return String
	 */
	public static String convertToDate(String value, String fromFormat, String toFormat) {
		DateFormat toDateFormat = new SimpleDateFormat(toFormat);
		DateFormat fromDateFormat = new SimpleDateFormat(fromFormat);
		try {
			Date date = fromDateFormat.parse(value);
			value = toDateFormat.format(date);
		} catch (Exception e) {
			value = "";
		}
		return value;
	}

	public static String getCurrentDateInGMTFormat() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss z");
		dateFormat.setTimeZone(TimeZone.getTimeZone(GMT));
		return dateFormat.format(date);
	}

	public static String getDateInGMTFormat(String dateStr, String dateFormatStr) {
		DateFormat dateFormat = new SimpleDateFormat(dateFormatStr);
		Date date = null;
		try {
			date = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			return dateStr;
		}
		dateFormat.setTimeZone(TimeZone.getTimeZone(GMT));
		return dateFormat.format(date);
	}

	public String getPreviousDateAndTimeForDay(int day, Date date) {

		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -day);
		return dateFormat.format(cal.getTime());
	}

	public String getPreviousMonth(int months, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -months);
		return dateFormat.format(cal.getTime());
	}

	public String getPreviousMonthDate(int months, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -months);
		return dateFormat.format(cal.getTime());
	}
}
