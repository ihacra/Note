package com.hacra.note.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Catalog
 * 
 * @author Hacra
 * @version 2020/06/09
 */
public class Catalog {
	
	private String name;
	private String path;
	private List<Catalog> detList = new ArrayList<>();
	
	public Catalog() {}
	
	public Catalog(String name, String path) {
		this.name = name;
		this.path = path;
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

	@Override
	public String toString() {
		return "Catalog [name=" + name + ", path=" + path + "]";
	}
}
