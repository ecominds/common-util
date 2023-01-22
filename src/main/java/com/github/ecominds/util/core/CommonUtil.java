/**
 * @author	: Rajiv Kumar
 * @project	: common-util
 * @since	: 0.0.1
 * @date	: 07-Jan-2023
 */
package com.github.ecominds.util.core;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Common utility method class
 */
public class CommonUtil {
	
	/**
	 * Checks for empty string with null check
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String... str){
		if(str == null){
			return true;
		}
		for(String s : str){
			if(s == null || s.trim().length() == 0 || "null".equalsIgnoreCase(s)){
				return true;
			}
		}
		return false;
	}
	
	public static String trim(String str){
		return trim(str, "");
	}
	
	public static String trim(String str, String defVal){
		if(str == null){
			return defVal;
		}
		return str.trim();
	}
	private static final String REGEX_NUMBER = "[0-9]+";
	public static String trimNum(String numStr){
		numStr = trim(numStr);
		if(numStr.matches(REGEX_NUMBER)){
			return numStr;
		}
		return "-1";
	}
	
	public static int toInt(String numStr){
		return Integer.parseInt(trimNum(numStr));
	}
	
	public static long toLong(String numStr){
		return Long.parseLong(trimNum(numStr));
	}
	
	public static double toDouble(String numStr){
		return Double.parseDouble(trimNum(numStr));
	}

	@SuppressWarnings("unchecked")
	public static <T> T load(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ClassLoader myClassLoader = ClassLoader.getSystemClassLoader();
		@SuppressWarnings("rawtypes")
		Class myClass = myClassLoader.loadClass(className);
		return (T)myClass.getDeclaredConstructor().newInstance();
	}
	
	public static <T extends Number> int[] toIntArray(List<T> col){
		int[] arr = new int[col.size()];
		int tmpIndex = 0;
		for(T val : col){
			arr[tmpIndex++] = val.intValue();
		}
		return arr;
	}
	
	public static String toByteCount(long bytes){
		return toByteCount(bytes, true);
	}
	
	public static String toByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	
	public static <T> boolean hasElement(List<T> col){
		if(col == null || col.size() == 0){
			return false;
		}
		return true;
	}
}