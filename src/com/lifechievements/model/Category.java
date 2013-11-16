package com.lifechievements.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String title = "";
	private String icon = "";
	private List<Achievement> children = new ArrayList<Achievement>();
	private List<Category> subCat = new ArrayList<Category>();

	public Category(String title, String icon, List<Achievement> children,
			List<Category> subCat) {
		this.title = title;
		this.icon = icon;
		this.children = children;
		this.subCat = subCat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Achievement> getChildren() {
		return children;
	}

	public void setChildren(List<Achievement> children) {
		this.children = children;
	}

	public List<Category> getSubCat() {
		return subCat;
	}

	public void setSubCat(List<Category> subCat) {
		this.subCat = subCat;
	}
	
	public String toString(){
		String result = "";
		//TODO toString en récursif pour les achievements+subCat
		return result;
	}
}
