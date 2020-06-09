package com.hacra.note.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.hacra.note.Application;
import com.hacra.note.bean.Catalog;
import com.hacra.note.config.Global;

/**
 * NoteUtils
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public final class NoteUtils {

	/**
	 * 初始化项目
	 */
	public static void init() {
		String themePath = Application.PATH + "\\" + Global.CSS_THEME;
		String markdownPath = Application.PATH + "\\" + Global.CSS_MARKDOWN;
		try {
			File srcfile = new File(Global.SRC_THEME_PATH);
			File outFile = new File(themePath);
			if (!outFile.exists()) {
				Files.copy(srcfile.toPath(), outFile.toPath());
			}
			srcfile = new File(Global.SRC_MARKDOWN_PATH);
			outFile = new File(markdownPath);
			if (!outFile.exists()) {
				Files.copy(srcfile.toPath(), outFile.toPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查找Markdown文件
	 * @param Offset 
	 * @return
	 */
	public static List<Catalog> match(int Offset) {
		List<Catalog> catalogList = new ArrayList<Catalog>(32);
		Catalog catalog1 = new Catalog("a", "/a");
		List<Catalog> list = new ArrayList<Catalog>(32);
		list.add(new Catalog("a1", "/a/1"));
		list.add(new Catalog("a2", "/a/2"));
		list.add(new Catalog("a3", "/a/3"));
		catalog1.setDetList(list);
		catalogList.add(catalog1);
		catalog1 = new Catalog("b", "/b");
		list = new ArrayList<Catalog>(32);
		list.add(new Catalog("b1", "/b/1"));
		list.add(new Catalog("b2", "/b/2"));
		list.add(new Catalog("b3", "/b/3"));
		catalog1.setDetList(list);
		catalogList.add(catalog1);
		return catalogList;
	}
}
