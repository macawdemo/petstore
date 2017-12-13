package io.macaw.demo.petstore.userservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Bannerdata extends BaseDTO  {
	public Bannerdata() {
		
	}
	public String getFavcategory() {
		return favcategory;
	}
	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}
	public String getBannername() {
		return bannername;
	}
	public void setBannername(String bannername) {
		this.bannername = bannername;
	}
	
	private String favcategory;
	private String bannername;
}
