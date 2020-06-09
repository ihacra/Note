package com.hacra.note;

import java.util.List;

import com.hacra.note.bean.Catalog;
import com.hacra.note.utils.NoteUtils;

/**
 * Note
 * 
 * @author Hacra
 * @date 2020-06-09
 */
public class Application {

	public final static int OFFSET = 1;
	public final static String PATH = "F:\\Note";
	
	public static void main(String[] args) {
		NoteUtils.init();
		List<Catalog> catalogList = NoteUtils.match(OFFSET);
		print(catalogList);
		
		
//		String md = "# �ύ����";
//		
//		Parser parser = Parser.builder().build();
//		Node node = parser.parse(md);
//		HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
//		String html = htmlRenderer.render(node);
//		
//		System.out.println(html);
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
