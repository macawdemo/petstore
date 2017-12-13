package io.macaw.demo.petstore.productsservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.productsservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.productsservice.mysql.db.dto.Item;

public class ItemDAO extends BaseDAO<Item> {

	@Override
	public String getName() {
		return "ITEM";
	}

	@Override
	public Item getDto(ResultSet rs) {
		Item item = new Item();
		try {
			item.setItemid(rs.getString("itemid"));
			item.setProductid(rs.getString("productid"));
			item.setSupplierid(rs.getString("supplierid"));
			item.setListprice(rs.getDouble("listprice"));
			item.setUnitcost(rs.getDouble("unitcost"));
			item.setStatus(rs.getString("status"));
			item.setAttr1(rs.getString("attr1"));
			item.setAttr2(rs.getString("attr2"));
			item.setAttr3(rs.getString("attr3"));
			item.setAttr4(rs.getString("atrr4"));
			item.setAttr5(rs.getString("attr5"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
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
	public String getInsertQuery(Item dto) {
		return "insert into " + getName()
				+ "(itemid, productid, listprice, unitcost, supplierid, status, attr1, attr2, attr3, attr4, attr5) "
				+ "values('" + dto.getItemid() + "','" + dto.getProductid() + "'," + dto.getListprice() + ","
				+ dto.getUnitcost() + ", '" + dto.getSupplierid() + "','" + dto.getStatus() + "','" + dto.getAttr1()
				+ "','" + dto.getAttr2() + "','" + dto.getAttr3() + "','" + dto.getAttr4() + "','" + dto.getAttr5()
				+ "')";
	}

	@Override
	public String getUpdateQuery(Item dto) {
		return "update " + getName() + "set productid='" + dto.getProductid() + "', listprice =" + dto.getListprice()
				+ ", unitcost =" + dto.getUnitcost() + ", supplierid = '" + dto.getSupplierid() + "', attr1= '"
				+ dto.getAttr1() + "', attr2= '" + dto.getAttr2() + "', attr3= '" + dto.getAttr3() + "' , attr4= '"
				+ dto.getAttr4() + "', attr5= '" + dto.getAttr5() + "' where itemid ='" + dto.getItemid() + "'";
	}

	public java.util.List<io.macaw.demo.petstore.productsservice.Item> getItemsByProductid(String id) {
		String query = "select * from " + getName() + " where productid = '" + id + "'";
		List<Item> itemDtos = fetchByQuery(query);
		return getEntitiesFromDTOs(itemDtos);
	}

	public io.macaw.demo.petstore.productsservice.Item getEntityFromDTO(Item item) {
		io.macaw.demo.petstore.productsservice.Item itemEntity = DomainEntityInstantiator.getInstance()
				.newInstance(io.macaw.demo.petstore.productsservice.Item.class);
		itemEntity.setItemid(item.getItemid());
		itemEntity.setSupplierid(item.getSupplierid());
		itemEntity.setProductid(item.getProductid());
		itemEntity.setUnitcost(item.getUnitcost());
		itemEntity.setListprice(item.getListprice());
		itemEntity.setAttr1(item.getAttr1());
		itemEntity.setAttr2(item.getAttr2());
		itemEntity.setAttr3(item.getAttr3());
		itemEntity.setAttr4(item.getAttr4());
		itemEntity.setAttr5(item.getAttr5());
		return itemEntity;

	}
	public List<io.macaw.demo.petstore.productsservice.Item> getProductsByCatIdQuery(String id) {
		String query = "select * from "+getName()+" where productid = '"+id+"'";
		List<Item> itemDtos = fetchByQuery(query);
			return getEntitiesFromDTOs(itemDtos);
	}
	public List<io.macaw.demo.petstore.productsservice.Item> getEntitiesFromDTOs(List<Item> items) {
		List<io.macaw.demo.petstore.productsservice.Item> itemEntities = new ArrayList<io.macaw.demo.petstore.productsservice.Item>();
		for (Item item : items) {
			itemEntities.add(getEntityFromDTO(item));
		}
		return itemEntities;
	}
}
