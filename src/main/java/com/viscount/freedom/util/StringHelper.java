package com.viscount.freedom.util;

import org.apache.log4j.Logger;


public final class StringHelper {	
	
	private StringHelper() {
		super();
	}

	// Logger
	private static final Logger LOG = Logger.getLogger(StringHelper.class);
	
	private static final int OFFSET_VALUE = 0xffff;
	private static final int MAXMUM_UNICODE_VALUE = 160;

	private static final String EMPTY = "";
	
	public static boolean isNotEmpty(String str) {
		if (str != null && !str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isEmpty(String str) {
		if (str != null && !str.trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean isValidIntegerString(String str) {
		try {
			Integer.parseInt(str.trim());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidLongString(String str) {
		try {
			Long.parseLong(str.trim());
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * This gives parsed string for HTML string data.
	 * 
	 * @param string
	 * @return String
	 */
	public static String parseToHtml(String string) {
		StringBuffer sb = new StringBuffer(string.length());
		try {
			// true if last char was blank
			boolean lastWasBlankChar = false;
			int len = string.length();
			char c;

			for (int i = 0; i < len; i++) {
				c = string.charAt(i);
				if (c == ' ') {
					// blank gets extra work,
					// this solves the problem you get if you replace all
					// blanks with &nbsp;, if you do that you loss
					// word breaking
					if (lastWasBlankChar) {
						lastWasBlankChar = false;
						sb.append("&nbsp;");
					} else {
						lastWasBlankChar = true;
						sb.append(' ');
					}
				} else {
					lastWasBlankChar = false;
					//
					// HTML Special Chars
					if (c == '"'){
						sb.append("&quot;");
					}else if (c == '&'){
						sb.append("&amp;");
					}else if (c == '<'){
						sb.append("&lt;");
					}else if (c == '>') {
						sb.append("&gt;");
						if (i < len - 1) {
							i++;
							c = string.charAt(i);
							while (c == ' ' || c == '\n') {
								c = string.charAt(++i);
							}
							if (c == '<') {
								sb.append("<br/>&lt;");
							} else {
								sb = unicodeSystem(sb, c);
							}
						}
					} else if (c == '\n'){
						// Handle Newline
						sb.append("<br/>");
					}else {
						sb = unicodeSystem(sb, c);
					}
				}
			}
		} catch (Exception e) {
		    LOG.error("Exception in parseToHtml method  :: ", e);
		}
		return sb.toString();
	}

	/**
	 * Returns Unicode value for given character.
	 * 
	 * @param sb
	 * @param c
	 * @return
	 * @throws Exception
	 *             StringBuffer
	 */
	private static StringBuffer unicodeSystem(StringBuffer sb, char c) throws Exception {

		int ci = OFFSET_VALUE & c;
		if (ci < MAXMUM_UNICODE_VALUE){
			// nothing special only 7 Bit
			sb.append(c);
		} else {
			// Not 7 Bit use the unicode system
			sb.append("&#");
			sb.append(Integer.valueOf(ci));
			sb.append(';');
		}
		return sb;
	}
	
	public static String getStringFromArray(String []arr, String dilimiter) {
		try {
			if (arr.length > 0) {
			    StringBuilder nameBuilder = new StringBuilder();
			    for (String n : arr) {
			        nameBuilder.append(n).append(",");
			    }
			    nameBuilder.deleteCharAt(nameBuilder.length() - 1);
			    return nameBuilder.toString();
			} else {
			    return "";
			}
		} catch (Exception e) {
			LOG.error("Exception :: ", e);
		}
		return "";
	}
}
