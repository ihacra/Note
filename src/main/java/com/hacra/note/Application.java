package com.hacra.note;

import com.hacra.note.config.Global;
import com.hacra.note.utils.NoteUtils;

/**
 * Note
 * 
 * @author Hacra
 * @date 2020-06-09
 */
public class Application {
	
	public static void main(String[] args) {
		if (args.length == 1) {
			NoteUtils.initNote(args[0]);
			NoteUtils.markdownToHtml();
			NoteUtils.buildCatalog();
			NoteUtils.updateLog();
		} else if (args.length == 2) {
			NoteUtils.clear(args[0]);
			NoteUtils.updateLog();
		} else if (Global.FLAG) {
			NoteUtils.initNote(null);
			NoteUtils.markdownToHtml();
			NoteUtils.buildCatalog();
			NoteUtils.updateLog();
		}
	}
}
