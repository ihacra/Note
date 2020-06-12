package com.hacra.note.config;

/**
 * Global
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public final class Global {
	
	/** 日志输出级别 {0=none, 1=info}*/
	public final static int LOG_LEVEL = 1;
	
	/** 项目路径 */
	public static String PATH_NOTE = "E:\\Note";
	public final static String PATH_CURRENT = System.getProperty("user.dir");
	
	/** CSS样式模板 */
	public final static String SRC_THEME_PATH = PATH_CURRENT + "\\src\\main\\resources\\static\\style\\theme.css";
	public final static String SRC_MARKDOWN_PATH = PATH_CURRENT + "\\src\\main\\resources\\static\\style\\markdown.css";
	public final static String SRC_INDEX_PATH = PATH_CURRENT + "\\src\\main\\resources\\static\\template\\index.html";
	
	/** 本地CSS样式 */
	public final static String OUT_LOG_NAME = "note.log";
	public final static String OUT_CSS_THEME = "theme.css";
	public final static String OUT_CSS_MARKDOWN = "markdown.css";
	public final static String OUT_HTML_INDEX = "index.html";
	public final static String OUT_HTML_CATALOG = "catalog.html";
	
	/** Markdown文件后缀名 */
	public final static String SUFFIX_MARKDOWN = ".md";
	public final static String SUFFIX_HTML = ".html";
	
	/** 需排除的文件或文件夹名称 */
	public final static String[] EXCLUDE_FOLDERS = {".git", "images", "img"};
	public final static String[] EXCLUDE_FILES = {"README.md"};
}
