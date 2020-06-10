/**
 * 
 */
package com.hacra.note.utils;

/**
 * StringUtils
 * 
 * @author Hacra
 * @date 2020-06-10
 */
public class StringUtils {
	
	/**
	 * 字符串str是否包含在数组strs中
	 * @param str
	 * @param strs
	 * @return
	 */
	public static boolean contains(String str, String[] strs) {
		if (str == null) {
			return false;
		}
		for (String s : strs) {
			if (str.equals(s)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断文件名称name的后缀是否是suffix
	 * @param name
	 * @param suffix
	 * @return
	 */
	public static boolean sameFileType(String name, String suffix) {
		return name != null && suffix.equals(getFileSuffix(name));
	}
	
	/**
	 * 获取文件名name中的名称（去除后缀名）
	 * @param name
	 * @return
	 */
	public static String getFileName(String name) {
		if (name == null) {
			return null;
		}
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name;
		} else {
			return name.substring(0, index);
		}
	}
	
	/**
	 * 获取文件名name中的后缀名
	 * @param name
	 * @return
	 */
	public static String getFileSuffix(String name) {
		if (name == null) {
			return null;
		}
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return null;
		} else {
			return name.substring(index).toLowerCase();
		}
	}
	
	/**
	 * 替换文件路径path的后缀名
	 * @param path
	 * @param suffix
	 * @return
	 */
	public static String replaceSuffix(String path, String suffix) {
		if (path == null) {
			return null;
		}
		int index = path.lastIndexOf(".");
		return index == -1 ? path : path.substring(0, index) + suffix;
	}
}
