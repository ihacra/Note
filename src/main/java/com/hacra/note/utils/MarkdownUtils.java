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
	public static void markdownToHtml(List<Catalog> catalogList, long lastModifyTime) {
		for (Catalog catalog : catalogList) {
			if (catalog.isDirectory()) {
				NoteUtils.appendCatalogHtml("<li class='folder'>");
				NoteUtils.appendCatalogHtml(catalog.getName());
				NoteUtils.appendCatalogHtml("<ul>");
				markdownToHtml(catalog.getDetList(), lastModifyTime);
				NoteUtils.appendCatalogHtml("</ul></li>");
			} else {
				File file = new File(catalog.getPath());
				if (file.exists()) {
					if (file.lastModified() >= lastModifyTime) {
						markdownToHtml(file, catalog);
						NoteUtils.NOTE_LOG.append(catalog.showInfo()).append("\n");
					}
					NoteUtils.appendCatalogHtml("<li><a class='file' target='showframe' href='");
					NoteUtils.appendCatalogHtml(StringUtils.replaceSuffix(catalog.getShortPath(), Global.SUFFIX_HTML));
					NoteUtils.appendCatalogHtml("' onclick='show(this)'>");
					NoteUtils.appendCatalogHtml(catalog.getShortName());
					NoteUtils.appendCatalogHtml("</a></li>");
				}
			}
		}
	}
	
	/**
	 * 将Markdown文件转为Html文件
	 * @param file
	 */
	private static void markdownToHtml(File file, Catalog catalog) {
		String md = FileUtils.readFile(file);
		String html = HTML_RENDERER.render(PARSER.parse(md));
		StringBuilder stringBuilder = new StringBuilder(html.length() + 1024);
		stringBuilder.append("<html><head><title>")
			.append(StringUtils.getFileName(catalog.getName()))
			.append("</title><link rel='stylesheet' type='text/css' href='")
			.append(StringUtils.relativePath(Global.PATH_NOTE, catalog.getPath(), Global.OUT_CSS_MARKDOWN))
			.append("'></head><body><div id='write'>")
			.append(html)
			.append("</div></body></html>");
		File htmlFile = new File(StringUtils.replaceSuffix(file.getPath(), Global.SUFFIX_HTML));
		FileUtils.writer(htmlFile, stringBuilder.toString());
	}
}
