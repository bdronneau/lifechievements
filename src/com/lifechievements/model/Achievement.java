package com.lifechievements.model;

public class Achievement {

	private int id = 0;
	private String icon = "";
	private String title = "";
	private String description = "";

	public Achievement(int id, String icon, String title, String description) {
		this.id = id;
		this.icon = icon;
		this.title = title;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
