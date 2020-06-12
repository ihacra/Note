package com.hacra.note.bean;

import java.util.ArrayList;
import java.util.List;

import com.hacra.note.config.Global;
import com.hacra.note.utils.StringUtils;

/**
 * Catalog
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public class Catalog {
	
	private int level;
	private String name;
	private String path;
	private boolean directory;
	private List<Catalog> detList = new ArrayList<>();
	
	public Catalog() {}
	
	public Catalog(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public Catalog(boolean directory) {
		this.directory = directory;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<Catalog> getDetList() {
		return detList;
	}

	public void setDetList(List<Catalog> detList) {
		this.detList = detList;
	}

	public boolean isDirectory() {
		return directory;
	}

	public void setDirectory(boolean directory) {
		this.directory = directory;
	}
	
	public String showInfo() {
		return path;
	}

	public String getShortName() {
		return StringUtils.getFileName(name);
	}
	
	public String getShortPath() {
		return StringUtils.substringByPrefix(Global.PATH_NOTE + "\\", path);
	}

	@Override
	public String toString() {
		return "Catalog [level=" + level + ", directory=" + directory + ", name=" + name + ", path=" + path
				+ "]";
	}
}
