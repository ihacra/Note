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
		Global.NOTE_PATH = "F:\\Note";
		
		NoteUtils.init();
		Date lastModifyDate = NoteUtils.getLastModifyDate();
		List<Catalog> catalogList = NoteUtils.match(Global.NOTE_PATH);
		StringBuilder noteLog = MarkdownUtils.markdownToHtml(catalogList, lastModifyDate.getTime());

		System.out.println(DateUtils.formatDate(lastModifyDate, DateUtils.DATE_TIME_PATTERN));
		System.out.println(noteLog.toString());
	}
	
	public static void print(List<Catalog> catalogList) {
		for (Catalog catalog : catalogList) {
			System.out.println(catalog.toString());
			if (!catalog.getDetList().isEmpty()) {
				print(catalog.getDetList());
			}
		}
	}
}
