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
	public final static String PATH_NOTE = "F:\\Note";
	public final static String PATH_CURRENT = System.getProperty("user.dir");
	
	/** CSS样式模板 */
	public final static String[] SRC_STATIC_PATH = {
			PATH_CURRENT + "\\src\\main\\resources\\static\\style\\theme.css",
			PATH_CURRENT + "\\src\\main\\resources\\static\\style\\markdown.css",
			PATH_CURRENT + "\\src\\main\\resources\\static\\template\\index.html",
			PATH_CURRENT + "\\src\\main\\resources\\static\\images\\file.png",
			PATH_CURRENT + "\\src\\main\\resources\\static\\images\\file2.png",
			PATH_CURRENT + "\\src\\main\\resources\\static\\images\\folder.png",
			PATH_CURRENT + "\\src\\main\\resources\\static\\images\\folder2.png"
	};
	
	/** 本地CSS样式 */
	public final static String OUT_LOG_NOTE = "note.log";
	public final static String OUT_HTML_CATALOG = "catalog.html";
	
	/** Markdown文件后缀名 */
	public final static String SUFFIX_MARKDOWN = ".md";
	public final static String SUFFIX_HTML = ".html";
	
	/** 需排除的文件或文件夹名称 */
	public final static String[] EXCLUDE_FOLDERS = {".git", "images", "img"};
	public final static String[] EXCLUDE_FILES = {"README.md"};
}
