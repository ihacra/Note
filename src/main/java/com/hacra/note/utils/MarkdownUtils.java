package com.hacra.note.utils;

import java.io.File;
import java.util.List;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import com.hacra.note.bean.Catalog;
import com.hacra.note.config.Global;

/**
 * MarkdownUtils
 * 
 * @author Hacra
 * @date 2020-06-10
 */
public final class MarkdownUtils {
	
	private final static Parser PARSER = Parser.builder().build();
	private final static HtmlRenderer HTML_RENDERER = HtmlRenderer.builder().build();

	/**
	 * 将最后修改日期lastModifyDate之后的修改文件编译为html
	 * @param catalogList
	 * @param lastModifyDate
	 */
	public static StringBuilder markdownToHtml(List<Catalog> catalogList, long lastModifyTime) {
		StringBuilder noteLog = new StringBuilder(catalogList.size()<<5);
		for (Catalog catalog : catalogList) {
			if (catalog.isDirectory()) {
				noteLog.append(markdownToHtml(catalog.getDetList(), lastModifyTime));
			} else {
				File file = new File(catalog.getPath());
				if (file.exists() && file.lastModified() >= lastModifyTime) {
					markdownToHtml(file, catalog.getShortName());
					noteLog.append(catalog.showInfo()).append("\n");
				}
			}
		}
		return noteLog;
	}
	
	/**
	 * 将Markdown文件转为Html文件
	 * @param file
	 */
	private static void markdownToHtml(File file, String name) {
		String md = FileUtils.readFile(file);
		String html = HTML_RENDERER.render(PARSER.parse(md));
		StringBuilder stringBuilder = new StringBuilder(html.length() + 1024);
		stringBuilder.append("<html><head><title>")
			.append(name)
			.append("</title><link rel='stylesheet' type='text/css' href='file:///")
			.append(Global.NOTE_PATH).append("\\").append(Global.CSS_MARKDOWN)
			.append("'></head><body><div id='write'>")
			.append(html)
			.append("</div></body></html>");
		File htmlFile = new File(StringUtils.replaceSuffix(file.getPath(), Global.HTML_SUFFIX));
		FileUtils.writer(htmlFile, stringBuilder.toString());
	}
}
