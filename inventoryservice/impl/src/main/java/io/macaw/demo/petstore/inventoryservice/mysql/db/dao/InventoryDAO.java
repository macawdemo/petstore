package io.macaw.demo.petstore.inventoryservice.mysql.db.dao;

import java.sql.ResultSet;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.inventoryservice.mysql.db.dto.Inventory;

public class InventoryDAO extends BaseDAO<Inventory> {

	@Override
	public String getName() {
		return "INVENTORY";
	}

	@Override
	public Inventory getDto(ResultSet rs) {
		Inventory inventory = new Inventory();
		try {
			if (rs != null) {
				inventory.setItemid(rs.getString("itemid"));
				inventory.setQuantity(rs.getInt("quantity"));
			}
		} catch (Exception e) {
			// TODO log or throw exception
		}
		return inventory;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from " + getName() + " where itemid = '" + id + "'";
	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from " + getName() + " where itemid = '" + id + "'";
	}

	@Override
	public String getInsertQuery(Inventory dto) {
		return "insert into " + getName() + "(itemid,quantity) values('" + dto.getItemid() + "'," + dto.getQuantity()
				+ ")";
	}

	@Override
	public String getUpdateQuery(Inventory dto) {
		return "update " + getName() + " set quantity=" + dto.getQuantity() + " where itemid='" + dto.getItemid() + "'";
	}
}