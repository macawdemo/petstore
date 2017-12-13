package io.macaw.demo.petstore.productsservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Product  extends BaseDTO {
	
	public Product(){
		};
		public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		private String productid;
		private String category;
		private String name;
		private String description;
	}
	
	
