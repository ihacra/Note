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
	private final static StringBuilder NOTE_LOG = new StringBuilder(1024);

	/**
	 * 输出日志信息
	 * @param message
	 */
	public static void info(Class<?> clazz, String message) {
		if (Global.LOG_LEVEL >= LOG_INFO) {
			message = DateUtils.getDate(DATE_TIME_PATTERN) + " INFO [" + clazz.getName() + "] - " + message;
			NOTE_LOG.append(message).append("\n");
			System.out.println(message);
		}
	}
	
	/**
	 * 获取日志内容
	 */
	public static String getNoteLog() {
		return NOTE_LOG.toString();
	}
}
