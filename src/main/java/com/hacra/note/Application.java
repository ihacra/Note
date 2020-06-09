package com.hacra.note;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * Note
 * 
 * @author Hacra
 * @date 2020-06-09
 */
public class Application {

	public static void main(String[] args) {
		String md = "# �ύ����\r\n" + 
				"\r\n" + 
				"1. `git status`���鿴��ǰ״̬\r\n" + 
				"2. `git add .`����ӵ����ػ�����\r\n" + 
				"3. `git commit -m ��ע�͡�`���ύ�����زֿ�\r\n" + 
				"4. `git pull origin master`����ȡԶ�̵ĸ���\r\n" + 
				"5. `git push origin master`���ύ��Զ�ֿ̲�\r\n" + 
				"\r\n" + 
				"# ���´���\r\n" + 
				"\r\n" + 
				"1. `git remote -v`���鿴Զ�̷�֧\r\n" + 
				"2. `git fetch origin master:temp`����ȡԶ�����°汾������temp��֧��\r\n" + 
				"3. `git diff temp`���Ƚϱ��زֿ���temp��֧������\r\n" + 
				"4. `git merge temp`���ϲ�temp��֧�����زֿ�\r\n" + 
				"5. `git branch -d temp`��ɾ������temp��֧\r\n" + 
				"\r\n" + 
				"# ���Ǵ���\r\n" + 
				"\r\n" + 
				"1. `git fetch --all`����ȡԶ�ֿ̲����и���\r\n" + 
				"2. `git reset --hard origin/master`�����Ǳ��زֿ�ͬ������\r\n" + 
				"3. `git pull origin master`����ȡԶ�̵ĸ���\r\n" + 
				"\r\n" + 
				"# �鿴��־\r\n" + 
				"\r\n" + 
				"1. `git log`���鿴������־\r\n" + 
				"2. `git log -n`���鿴���n����־\r\n" + 
				"3. `git shortlog`���鿴�ύ�����û�������ע��\r\n" + 
				"4. `git shortlog -sn`���鿴�ύ�����û�����������\r\n" + 
				"\r\n" + 
				"# Զ�̵�ַ\r\n" + 
				"\r\n" + 
				"1. `git remote -v`���鿴Զ�ֿ̲�����\r\n" + 
				"2. `git remote get-url origin`����ȡ������Զ�ֿ̲��ַ\r\n" + 
				"3. `git remote set-url origin https://.../xxx.git `�����ù�����Զ�ֿ̲��ַ\r\n" + 
				"4. `git remote rm origin`��ɾ�����زֿ������Զ�ֿ̲�\r\n" + 
				"5. `git remote add origin https://.../xxx.git`������µ�Զ�ֿ̲��ַ\r\n" + 
				"\r\n" + 
				"# �����˻�\r\n" + 
				"\r\n" + 
				"1. `git config user.name`���鿴�û���\r\n" + 
				"2. `git config user.email`���鿴����\r\n" + 
				"3. `git config --global user.name ��xxx��`������ȫ���û���\r\n" + 
				"4. `git config --global user.email ��xxx@qq.com��`������ȫ������\r\n" + 
				"\r\n" + 
				"---\r\n" + 
				"\r\n" + 
				"![Git](images/Gitʹ��.webp)\r\n" + 
				"\r\n" + 
				"![Git](images/Git����.webp)";
		
		Parser parser = Parser.builder().build();
		Node node = parser.parse(md);
		HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();
		String html = htmlRenderer.render(node);
		
		System.out.println(html);
	}
}
