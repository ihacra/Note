package com.hacra.note.utils;

import com.hacra.note.config.Global;

/**
 * LogUtils
 * 
 * @author Hacra
 * @date 2020-06-12
 */
public class LogUtils {
	
	private final static int LOG_INFO = 1;
	private final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";

	/**
	 * 输出日志信息
	 * @param message
	 */
	public static void info(Class<?> clazz, String message) {
		if (Global.LOG_LEVEL >= LOG_INFO) {
			String prefix = DateUtils.getDate(DATE_TIME_PATTERN) + " INFO [" + clazz.getName() + "] - ";
			System.out.println(prefix + message);
		}
	}
}
