package io.macaw.demo.petstore.inventoryservice.mysql.db.dto;

import io.macaw.db.mysql.utils.BaseDTO;

public class Inventory extends BaseDTO {
	public Inventory() {

	}

	private String itemid;
	private long quantity;

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity2) {
		this.quantity = quantity2;
	}

	public interface FieldLengthSpec {

		public static long ITEMID_LENGHT = 80;
		public static int QUANTITY_LENGTH = 10;

	}
}
