package com.dean.test;

import java.util.List;

public class Wrapper {
	
	private Long id; 
	private String name;
	private List<Object> objects;
	
	
	public Wrapper(Long id, String name, List<Object> objects) {
		this.id = id;
		this.name = name;
		this.objects = objects;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getObjects() {
		return objects;
	}
	public void setObjects(List<Object> objects) {
		this.objects = objects;
	}
	
	
	

}
