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
	
	/**
	 * 截取前缀prefix后的内容
	 * @param prefix
	 * @param value
	 * @return
	 */
	public static String substringByPrefix(String prefix, String value) {
		if (prefix != null && value != null && value.startsWith(prefix)) {
			return value.substring(prefix.length());
		}
		return value;
	}
	
	/**
	 * 获取path2相对于path1的相对路径
	 * @param path1
	 * @param path2
	 * @return
	 */
	public static String relativePath(String path1, String path2) {
		StringBuilder stringBuilder = new StringBuilder(path2.length());
		if (path1 != null && path2 != null && path2.startsWith(path1)) {
			int count = getCount(path2, '\\') - getCount(path1, '\\') - 1;
			for (int i = 0; i < count; i++) {
				stringBuilder.append("..\\");
			}
			stringBuilder.append(path2.substring(path2.lastIndexOf("\\") + 1));
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 获取在path1处的name文件在path2处的相对路径
	 * @param path1
	 * @param path2
	 * @param name
	 * @return
	 */
	public static String relativePath(String path1, String path2, String name) {
		StringBuilder stringBuilder = new StringBuilder(path2.length());
		if (path1 != null && path2 != null && path2.startsWith(path1)) {
			int count = getCount(path2, '\\') - getCount(path1, '\\') - 1;
			for (int i = 0; i < count; i++) {
				stringBuilder.append("..\\");
			}
			stringBuilder.append(name);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 统计字符串中字符c出现的次数
	 * @param value
	 * @param c
	 * @return
	 */
	public static int getCount(String value, char v) {
		int count = 0;
		for (int i = 0; i < value.length(); i++) {
			if (v == value.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
