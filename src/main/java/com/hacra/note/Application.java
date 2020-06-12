package com.hacra.note;

import java.util.List;

import com.hacra.note.bean.Catalog;
import com.hacra.note.utils.DateUtils;
import com.hacra.note.utils.LogUtils;
import com.hacra.note.utils.NoteUtils;

/**
 * Note
 * 
 * @author Hacra
 * @date 2020-06-09
 */
public class Application {
	
	public static void main(String[] args) {
		NoteUtils.initNote();
		NoteUtils.markdownToHtml();
		NoteUtils.buildCatalog();
		NoteUtils.updateLog();

		LogUtils.info(Application.class, DateUtils.formatDate(NoteUtils.getLastModifyDate(), DateUtils.DATE_TIME_PATTERN));
		LogUtils.info(Application.class, NoteUtils.NOTE_LOG.toString());
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
