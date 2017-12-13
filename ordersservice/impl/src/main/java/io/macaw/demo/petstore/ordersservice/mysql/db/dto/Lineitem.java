package io.macaw.demo.petstore.ordersservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Lineitem  extends BaseDTO {
	public Lineitem() {
		
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getLinenum() {
		return linenum;
	}
	public void setLinenum(int linenum) {
		this.linenum = linenum;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	private String orderid;
	private int linenum;
	private String itemid;
	private int quantity;
	private Double unitprice;
	

}
