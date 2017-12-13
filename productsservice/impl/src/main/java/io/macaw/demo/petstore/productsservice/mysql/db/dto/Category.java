package io.macaw.demo.petstore.productsservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Category extends BaseDTO {

	public Category() {
		
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String categoryid;
	private String name;
	private String description;
}
