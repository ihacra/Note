package com.hacra.note.config;

/**
 * Global
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public final class Global {
	
	/** 项目路径 */
	public static String NOTE_PATH = System.getProperty("user.dir");
	public final static String CURRENT_PATH = NOTE_PATH;
	
	/** CSS样式模板 */
	public final static String SRC_THEME_PATH = CURRENT_PATH + "\\src\\main\\resources\\static\\style\\theme.css";
	public final static String SRC_MARKDOWN_PATH = CURRENT_PATH + "\\src\\main\\resources\\static\\style\\markdown.css";
	
	/** 本地CSS样式 */
	public final static String LOG_NAME = "note.log";
	public final static String CSS_THEME = "theme.css";
	public final static String CSS_MARKDOWN = "markdown.css";
	
	/** Markdown文件后缀名 */
	public final static String MARKDOWN_SUFFIX = ".md";
	public final static String HTML_SUFFIX = ".html";
	
	/** 需排除的文件或文件夹名称 */
	public final static String[] EXCLUDE_FOLDERS = {".git", "images", "img"};
	public final static String[] EXCLUDE_FILES = {"README.md"};
}
