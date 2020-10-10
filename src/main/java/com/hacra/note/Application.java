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
		if (args.length == 1) {
			NoteUtils.initData(args[0]);
			NoteUtils.initNote();
			NoteUtils.markdownToHtml();
			NoteUtils.buildCatalog();
			NoteUtils.updateLog();
		} else if (args.length == 2) {
			NoteUtils.initData(args[0]);
			NoteUtils.clear(args[0]);
			NoteUtils.clearLog();
		}
	}
}
