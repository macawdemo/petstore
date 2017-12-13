package io.macaw.demo.petstore.userservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Credentials extends BaseDTO {

	public Credentials() {

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String userid;
	public String password;

}
