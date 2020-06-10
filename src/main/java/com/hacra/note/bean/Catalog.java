package com.hacra.note.bean;

import java.util.ArrayList;
import java.util.List;

import com.hacra.note.utils.StringUtils;

/**
 * Catalog
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public class Catalog {
	
	private String name;
	private String path;
	private String shortName;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.shortName = StringUtils.getFileName(name);
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

	public String getShortName() {
		return shortName;
	}
	
	public String showInfo() {
		return path;
	}

	@Override
	public String toString() {
		return "Catalog [directory=" + directory + ", shortName=" + shortName + ", path=" + path + "]";
	}
}
