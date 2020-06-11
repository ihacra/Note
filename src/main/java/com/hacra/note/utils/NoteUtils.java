package com.hacra.note.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hacra.note.bean.Catalog;
import com.hacra.note.config.Global;

/**
 * NoteUtils
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public final class NoteUtils {

	private final static StringBuilder CATALOG_HTML = new StringBuilder(1024);
	public final static StringBuilder NOTE_LOG = new StringBuilder(1024);
	
	/**
	 * 初始化项目
	 */
	public static void init() {
		String themePath = Global.NOTE_PATH + "\\" + Global.CSS_THEME;
		String markdownPath = Global.NOTE_PATH + "\\" + Global.CSS_MARKDOWN;
		String indexPath = Global.NOTE_PATH + "\\" + Global.HTML_INDEX;
		try {
			File srcfile = null;
			File outFile = new File(themePath);
			if (!outFile.exists()) {
				srcfile = new File(Global.SRC_THEME_PATH);
				Files.copy(srcfile.toPath(), outFile.toPath());
			}
			outFile = new File(markdownPath);
			if (!outFile.exists()) {
				srcfile = new File(Global.SRC_MARKDOWN_PATH);
				Files.copy(srcfile.toPath(), outFile.toPath());
			}
			outFile = new File(indexPath);
			if (!outFile.exists()) {
				srcfile = new File(Global.SRC_INDEX_PATH);
				Files.copy(srcfile.toPath(), outFile.toPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取日志中最后编译日期
	 * @param path
	 * @return
	 */
	public static Date getLastModifyDate() {
		File logFile = new File(Global.NOTE_PATH + "\\" + Global.LOG_NAME);
		String content = FileUtils.readFile(logFile); 
		if (content != null && content.length() >= DateUtils.DATE_TIME_PATTERN.length()) {
			String regex = "^[\\d]{4}-[\\d]{2}-[\\d]{2}\\s[\\d]{2}:[\\d]{2}:[\\d]{2}$";
			content = content.substring(0, DateUtils.DATE_TIME_PATTERN.length());
			if (content.matches(regex)) {
				return DateUtils.parseDate(content, DateUtils.DATE_TIME_PATTERN);
			}
		}
		return new Date(0);
	}
	
	/**
	 * 查找Markdown文件
	 * @param path 
	 * @return
	 */
	public static List<Catalog> match(String path) {
		return match(path, 0);
	}
	
	/**
	 * 查找Markdown文件
	 * @param path 
	 * @return
	 */
	public static List<Catalog> match(String path, int level) {
		List<Catalog> catalogList = new ArrayList<Catalog>(32);
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File det : files) {
					String name = det.getName();
					if (det.isDirectory()) {
						if (!StringUtils.contains(name, Global.EXCLUDE_FOLDERS)) {
							List<Catalog> detList = match(det.getAbsolutePath(), level+1);
							if (!detList.isEmpty()) {
								Catalog catalog = new Catalog(true);
								catalog.setLevel(level);
								catalog.setName(name);
								catalog.setDetList(detList);
								catalogList.add(catalog);
							}
						}
					} else {
						if (StringUtils.sameFileType(name, Global.MARKDOWN_SUFFIX) && !StringUtils.contains(name, Global.EXCLUDE_FILES)) {
							Catalog catalog = new Catalog(false);
							catalog.setLevel(level);
							catalog.setName(name);
							catalog.setPath(det.getPath());
							catalogList.add(catalog);
						}
					}
				}
			}
		}
		return catalogList;
	}
	
	/**
	 * 获取目录html
	 * @return
	 */
	public static String getCatalogHtml() {
		String prefix = "<link rel='stylesheet' type='text/css' href='theme.css'><ul>";
		String suffix = "</ul>";
		return prefix + CATALOG_HTML.toString() + suffix;
	}
	
	/**
	 * 添加目录内容html
	 * @param value
	 */
	public static void appendCatalogHtml(String value) {
		CATALOG_HTML.append(value);
	}
}
