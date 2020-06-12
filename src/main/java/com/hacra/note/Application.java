package com.hacra.note;

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
	}
}
