package com.hacra.note.utils;

import java.io.File;
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

	private static Date LAST_MODIFY_DATE = null;
	private final static StringBuilder CATALOG_HTML = new StringBuilder(1024);
	private final static StringBuilder NOTE_LOG = new StringBuilder(1024);
	
	/**
	 * 初始化项目
	 */
	public static void initNote() {
		File logFile = new File(Global.PATH_NOTE + "\\" + Global.OUT_LOG_NOTE);
		String content = FileUtils.readFile(logFile); 
		if (content != null && content.length() >= DateUtils.DATE_TIME_PATTERN.length()) {
			String regex = "^[\\d]{4}-[\\d]{2}-[\\d]{2}\\s[\\d]{2}:[\\d]{2}:[\\d]{2}$";
			content = content.substring(0, DateUtils.DATE_TIME_PATTERN.length());
			if (content.matches(regex)) {
				LAST_MODIFY_DATE = DateUtils.parseDate(content, DateUtils.DATE_TIME_PATTERN);
			}
		}
		if (LAST_MODIFY_DATE == null) {
			LAST_MODIFY_DATE = new Date(0);
			for (String srcPath : Global.SRC_STATIC_PATH) {
				FileUtils.copy(srcPath, Global.PATH_NOTE + "\\" + StringUtils.getFileNameSuffix(srcPath));
			}
		}
		LogUtils.info(NoteUtils.class, "上传编译时间：" + DateUtils.formatDate(LAST_MODIFY_DATE, DateUtils.DATE_TIME_PATTERN));
	}
	
	/**
	 * 获取日志中最后编译日期
	 * @param path 
	 * @return
	 */
	private static List<Catalog> match(String path) {
		return match(path, 0);
	}
	
	/**
	 * 查找Markdown文件
	 * @param path 
	 * @return
	 */
	private static List<Catalog> match(String path, int level) {
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
						if (StringUtils.sameFileType(name, Global.SUFFIX_MARKDOWN) && !StringUtils.contains(name, Global.EXCLUDE_FILES)) {
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
	 * 将最后修改日期lastModifyDate之后的修改文件编译为html
	 * @param catalogList
	 */
	public static void markdownToHtml() {
		List<Catalog> catalogList = match(Global.PATH_NOTE);
		MarkdownUtils.markdownToHtml(catalogList, LAST_MODIFY_DATE.getTime());
	}
	
	/**
	 * 创建目录文件
	 */
	public static void buildCatalog() {
		if (NOTE_LOG.length() > 0) {
			String prefix = "<link rel='stylesheet' type='text/css' href='theme.css'>"
					+ "<script>window.onload=function(){var b=document.getElementsByTagName('a');if(b!=null){b[0].click()}};function show(f){var e=document.getElementsByClassName('active');for(var d=0;d<e.length;d++){e[d].className='file'}f.className='active'}</script><ul>";
			String suffix = "</ul>";
			File catalogFile = new File(Global.PATH_NOTE + "\\" + Global.OUT_HTML_CATALOG);
			FileUtils.writer(catalogFile, prefix + CATALOG_HTML.toString() + suffix);
		}
	}

	/**
	 * 更新日志
	 */
	public static void updateLog() {
		File noteLogFile = new File(Global.PATH_NOTE + "\\" + Global.OUT_LOG_NOTE);
		String content = DateUtils.getDate(DateUtils.DATE_TIME_PATTERN) + "\n" + NOTE_LOG.toString();
		FileUtils.writer(noteLogFile, content);
	}
	
	/**
	 * 添加目录内容html
	 * @param value
	 */
	public static void appendCatalogHtml(String value) {
		CATALOG_HTML.append(value);
	}
	
	/**
	 * 添加日志内容
	 * @param value
	 */
	public static void appendNoteLog(String value) {
		NOTE_LOG.append(value);
	}
}
