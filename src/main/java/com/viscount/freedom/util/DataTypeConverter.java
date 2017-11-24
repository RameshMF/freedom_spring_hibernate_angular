package com.viscount.freedom.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public final class DataTypeConverter {	
	
	private DataTypeConverter() {
		super();
	}

	// Logger
	private static final Logger LOG = Logger.getLogger(DataTypeConverter.class);

	public static String convertToString(String str) {
		if (null == str){
			str = "";
		}
		return str;
	}// End of cvtStr()

	public static int convertToInteger(String input) {
		int output = 0;
		try {
			if (input != null && !input.trim().isEmpty()) {
				output = Integer.parseInt(input);
			}
		} catch (NumberFormatException e) {
			output = 0;
			LOG.error("Exception in convertToString :: ", e);
		}
		return output;
	}// End of cvtInt()

	public static Integer initNewInteger(Integer id) {
		if (null == id) {
			id = new Integer("0");
		}
		return id;
	}

	public static Long initNewLong(Long id) {
		if (null == id) {
			id = new Long("0");
		}
		return id;
	}

	public static Double initNewDouble(Double amt) {
		if (null == amt) {
			amt = new Double("0");
		}
		return amt;
	}
	
	public static double doubleValue(Double amt) {
		if (null == amt) {
			amt = new Double("0");
		}
		return amt;
	}

	public static Boolean initNewBoolean(Boolean flag) {
		if (null == flag) {
			flag = Boolean.FALSE;
		}
		return flag;
	}

	public static Long convertToLong(String data) {
		Long id = null;
		try {
			if (null == data || data.trim().isEmpty()) {
				id = new Long("0");
			} else {
				id = Long.parseLong(data);
			}
		} catch (NumberFormatException e) {
			LOG.error("Exception in convertToLong :: ", e);
		}
		return id;
	}

	public static Double convertToDouble(String data) {
		Double id = null;
		try {
			if (null == data || data.trim().isEmpty()) {
				id = new Double("0");
			} else {
				id = Double.parseDouble(data);
			}
		} catch (NumberFormatException e) {
			LOG.error("Exception in convertToDouble :: ", e);
		}
		return id;
	}

	public static Boolean convertToBoolean(String data) {
		Boolean flag = false;
		try {
			if (null == data || data.trim().isEmpty()) {
				flag = Boolean.FALSE;
			} else {
				flag = Boolean.parseBoolean(data);
			}
		} catch (NumberFormatException e) {
			LOG.error("Exception in convertToBoolean :: ",e);
		}
		return flag;
	}

	public static Date convertToDate(String purchasedDate, String dateFormat) {
		Date date = null;
		try {
			if (StringHelper.isNotEmpty(purchasedDate)) {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
				date = sdf.parse(purchasedDate);
			}
		} catch (ParseException e) {
			LOG.error("ParseException in convertToDate :: ",e);
		}
		return date;
	}
	public static boolean isListEmpty(List<?> list) {
		if (list != null && !list.isEmpty()) {
			return false;
		}
		return true;
	}


	public static int getIntValue(Integer value){
		return value == null ? 0 : value;
	}
}
