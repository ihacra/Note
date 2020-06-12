package com.hacra.note.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DateUtils
 * 
 * @author Hacra
 * @date 2020-06-10
 */
public class DateUtils {
	
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date newDate() {
		return new Date();
	}
	
	/**
	 * 获取当前日期字符串
	 * @param pattern
	 * @return
	 */
	public static String getDate(String pattern) {
		return formatDate(newDate(), pattern);
	}
	
	/**
	 * 字符串转日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String date, String pattern){
		DateFormat format = new SimpleDateFormat(pattern);  
		try {
			return format.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 日期转字符串
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern){
		DateFormat format = new SimpleDateFormat(pattern);  
		return format.format(date);
	}
	
	/**
	 * 获取日期date加上offset天数的日期
	 * @param date
	 * @param offset
	 * @return
	 */
	public static Date addDays(Date date, int offset){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTime(date);
		cal.add(Calendar.DATE, offset);
		return cal.getTime();
	}
}
