package com.dean.test;

public class ChartDataObject {
	
	private String category;
	private String title;
	private double value;

	public ChartDataObject(String title, double value, String category) {
		this.title = title;
		this.value = value;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

}
