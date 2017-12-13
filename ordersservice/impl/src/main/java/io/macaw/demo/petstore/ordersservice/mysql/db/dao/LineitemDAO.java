package io.macaw.demo.petstore.ordersservice.mysql.db.dao;

import java.sql.ResultSet;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.ordersservice.mysql.db.dto.Lineitem;

public class LineitemDAO extends BaseDAO<Lineitem> {

	@Override
	public String getName() {
		return "LINEITEMS";
	}

	@Override
	public Lineitem getDto(ResultSet rs) {
		Lineitem lineitem = new Lineitem();
		try {
			if(rs != null) {
				lineitem.setItemid(rs.getString("itemid"));
				lineitem.setOrderid(rs.getString("orderid"));
				lineitem.setLinenum(rs.getInt("linenum"));
				lineitem.setQuantity(rs.getInt("quantity"));
				lineitem.setUnitprice(rs.getDouble("unitprice"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return lineitem;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from "+getName()+" where orderid = '"+id+"'";

	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from "+getName()+" where orderid = '"+id+"'";

	}

	@Override
	public String getInsertQuery(Lineitem dto) {
		return "insert into "+getName()+"(orderid, linenum, itemid, quantity, unitprice) values('"+dto.getOrderid()+"',"+dto.getLinenum()+",'"+dto.getItemid()+"',"+dto.getQuantity()+","+dto.getUnitprice()+")";
	}

	@Override
	public String getUpdateQuery(Lineitem dto) {
		return "update "+getName()+" set quantity="+dto.getQuantity()+", unitprice=" + dto.getUnitprice() + " where orderid ='"+dto.getOrderid()+"'and itemid='"+dto.getItemid()+"'";
	}

}
