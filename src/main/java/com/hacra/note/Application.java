package com.hacra.note;

import java.util.Date;
import java.util.List;

import com.hacra.note.bean.Catalog;
import com.hacra.note.config.Global;
import com.hacra.note.utils.DateUtils;
import com.hacra.note.utils.MarkdownUtils;
import com.hacra.note.utils.NoteUtils;

/**
 * Note
 * 
 * @author Hacra
 * @date 2020-06-09
 */
public class Application {
	
	public static void main(String[] args) {
		Global.NOTE_PATH = "E:\\Note";
		
		NoteUtils.init();
		Date lastModifyDate = NoteUtils.getLastModifyDate();
		List<Catalog> catalogList = NoteUtils.match(Global.NOTE_PATH);
		MarkdownUtils.markdownToHtml(catalogList, lastModifyDate.getTime());

		System.out.println(DateUtils.formatDate(lastModifyDate, DateUtils.DATE_TIME_PATTERN));
		System.out.println(NoteUtils.NOTE_LOG.toString());
		print(catalogList);		
		System.out.println(NoteUtils.getCatalogHtml().toString());
	}
	
	public static void print(List<Catalog> catalogList) {
		for (Catalog catalog : catalogList) {
			System.out.println(catalog.toString());
			if (!catalog.getDetList().isEmpty()) {
				print(catalog.getDetList());
			}
		}
	}
	
	public static void print2(List<Catalog> catalogList) {
		for (Catalog catalog : catalogList) {
			for (int i = 0; i < catalog.getLevel(); i++) {
				System.out.print("+ ");
			}
			System.out.println(catalog.getName());
			if (!catalog.getDetList().isEmpty()) {
				print2(catalog.getDetList());
			}
		}
	}
}
