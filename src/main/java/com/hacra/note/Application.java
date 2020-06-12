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
		if (args.length > 0) {
			Global.PATH_NOTE = args[0];
			NoteUtils.initNote();
			NoteUtils.markdownToHtml();
			NoteUtils.buildCatalog();
			NoteUtils.updateLog();
		}
	}
}
