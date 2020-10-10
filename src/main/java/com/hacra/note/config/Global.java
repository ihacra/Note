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
	
	/** 是否使用IDE运行 */
	public final static boolean FLAG = false;
	public static String PATH_NOTE = null;
	public final static String PATH_CURRENT = System.getProperty("user.dir");
	
	/** CSS样式模板 */
	public final static String SRC_STATIC_INDEX_PATH = PATH_CURRENT + (FLAG ? "\\src\\main\\resources\\static\\template\\index.html" : "\\static\\template\\index.html");
	public final static String[] SRC_STATIC_PATHS = {
			PATH_CURRENT + (FLAG ? "\\src\\main\\resources\\static\\style\\theme.css" : "\\static\\style\\theme.css"),
			PATH_CURRENT + (FLAG ? "\\src\\main\\resources\\static\\style\\markdown.css" : "\\static\\style\\markdown.css"),
			PATH_CURRENT + (FLAG ? "\\src\\main\\resources\\static\\images\\img.png" : "\\static\\images\\img.png")
	};
	
	/** 日志文件 */
	public final static String OUT_LOG_NOTE = "note.log";
	
	/** Markdown文件后缀名 */
	public final static String SUFFIX_MARKDOWN = ".md";
	public final static String SUFFIX_HTML = ".html";
	
	/** 需排除的文件或文件夹名称 */
	public final static String[] EXCLUDE_FOLDERS = {".git", "bin", "images", "img"};
	public final static String[] EXCLUDE_FILES = {"README.md"};
}
