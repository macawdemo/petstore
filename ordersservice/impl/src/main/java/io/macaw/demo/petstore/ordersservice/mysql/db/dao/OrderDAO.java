package io.macaw.demo.petstore.ordersservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.ordersservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.ordersservice.mysql.db.dto.Order;

public class OrderDAO extends BaseDAO<Order> {

	@Override
	public String getName() {
		return "ORDERS";
	}

	@Override
	public Order getDto(ResultSet rs) {
		Order order = new Order();
		try {
			if (rs != null) {
				order.setOrderid(rs.getString("orderid"));
				order.setUserid(rs.getString("userid"));
			//	order.setOrderdate(rs.getDate("orderdate"));
				order.setShipaddr1(rs.getString("shipaddr1"));
				order.setShipaddr2(rs.getString("shipaddr2"));
				order.setShipcity(rs.getString("shipcity"));
				order.setShipstate(rs.getString("shipstate"));
				order.setBilladdr1(rs.getString("billaddr1"));
				order.setBilladdr2(rs.getString("billaddr2"));
				order.setBillstate(rs.getString("bilstate"));
				order.setBillzip(rs.getString("billzip"));
				order.setBillcountry(rs.getString("billcountry"));
				order.setCourier(rs.getString("courier"));
				order.setTotalprice(rs.getDouble("totalprice"));
				order.setBilltofirstname(rs.getString("billtofirstname"));
				order.setBilltolastname(rs.getString("billtolastname"));
				order.setShiptofirstname(rs.getString("shiptofirstname"));
				order.setShiptolastname(rs.getString("shiptolastname"));
				order.setCreditcard(rs.getString("creditcard"));
			//	order.setExpirydate(rs.getDate("expirydate"));
				order.setCardtype(rs.getString("cardtype"));
				order.setLocale(rs.getString("locale"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public String getFindByIdQuery(String id) {
		// TODO Auto-generated method stub
		return "select * from " + getName() + " where orderid = '"+id+"'";
	}

	@Override
	public String getDeleteByIdQuery(String id) {
		// TODO Auto-generated method stub
		return "delete from " + getName() + " where orderid = '"+id+"'";
	}

	@Override
	public String getInsertQuery(Order dto) {
		// TODO Auto-generated method stub
		return "insert into " + getName()
				+ "( orderid, userid, orderdate, shipaddr1, shipaddr2, shipcity, shipstate, shipzip, shipcountry, billaddr1, billaddr2, billstate, billzip, billcountry, courier, totalprice, billtofirstname, billtolastname, shiptofirstname, shiptolastname, creditcard, cardtype, locale) "
				+ " values('"+dto.getOrderid()+"','"+dto.getUserid()+"',"+dto.getOrderdate()+",'"+dto.getShipaddr1()+"','"+dto.getShipaddr2()+"','"+dto.getShipcity()+"','"+dto.getShipstate()
				+"','"+dto.getShipzip()+"','"+dto.getShipcountry()+"',"+dto.getBilladdr1()+"','"+dto.getBilladdr2()+"','"+dto.getBillstate()+"','"+dto.getBillzip()+"','"+dto.getBillcountry()
				+"','"+dto.getCourier()+"',"+dto.getTotalprice()+", '"+dto.getBilltofirstname()+"','"+dto.getBilltolastname()+"','"+dto.getShiptofirstname()+"','"+dto.getShiptolastname()+"','"+dto.getCreditcard()+"','"+dto.getCardtype()+"','"+dto.getLocale()+"')";

	}

	@Override
	public String getUpdateQuery(Order dto) {
		return "update "+getName()+" set userid='"+dto.getUserid()+"',orderdate="+dto.getOrderdate()+",shipaddr1='"+dto.getShipaddr1()+",shipcity='"+dto.getShipcity()+"',shipstate='"
				+dto.getShipstate()+"',shipzip='"+dto.getShipzip()+"',shipcountry='"+dto.getShipcountry()+"', billaddr1='"+dto.getBilladdr1()+"', billaddr2='"+dto.getBilladdr2()+"',billstate='"+dto.getBillstate()+"',billzip='"+dto.getBillzip()+"', billcountry='"+dto.getBillcountry()+"', courier='"+dto.getCourier()+"', totalprice="+dto.getTotalprice()+", billtofirstname='"+dto.getBilltofirstname()+"', billtolastname='"+dto.getBilltolastname()+"',shiptofirstname='"+dto.getShiptofirstname()+"', shiptolastname='"+dto.getShiptolastname()+"', creditcard='"
				+dto.getCreditcard()+"', cardtype='"+dto.getCardtype()+"', locale='"+dto.getLocale()
				+ "' where orderid='"+dto.getOrderid()+"'";
	}
	
	public io.macaw.demo.petstore.ordersservice.Order getEntityFromDTO(Order order){
		io.macaw.demo.petstore.ordersservice.Order orderEntity = DomainEntityInstantiator.getInstance().newInstance(io.macaw.demo.petstore.ordersservice.Order.class);
		//TODO: Rework Date Format
		orderEntity.setOrderid(order.getOrderid());
		orderEntity.setUserid(order.getUserid());
		  //orderEntity.setOrderdate(order.getOrderdate()); 
		orderEntity.setShipaddr1(order.getShipaddr1());
		orderEntity.setShipaddr2(order.getShipaddr2());
		orderEntity.setShipcity(order.getShipcity());
		orderEntity.setShipstate(order.getShipstate());
		orderEntity.setShipzip(order.getShipzip());
		orderEntity.setShipcountry(order.getShipcountry());
		orderEntity.setBilladdr1(order.getBilladdr1());
		orderEntity.setBilladdr2(order.getBilladdr2());
		orderEntity.setBillstate(order.getBillstate());
		orderEntity.setBillzip(order.getBillzip());
		orderEntity.setBillcountry(order.getBillcountry());
		orderEntity.setCourier(order.getCourier());
		orderEntity.setTotalprice(order.getTotalprice());
		 // orderEntity.setShipdate(order.gets);
		orderEntity.setBilltofirstname(order.getBilltofirstname());
		orderEntity.setBilltolastname(order.getBilltolastname());
		orderEntity.setShiptofirstname(order.getShiptofirstname());
		orderEntity.setShiptolastname(order.getShiptolastname());
		orderEntity.setCreditcard(order.getCreditcard());
		//  orderEntity.setExpirydate(order.getExpirydate());
		//orderEntity.setExpirydate(new Date());
		orderEntity.setCardtype(order.getCreditcard());
		orderEntity.setLocale(order.getLocale());
		
		return orderEntity;
	}
	
	public List<io.macaw.demo.petstore.ordersservice.Order> getEntitiesFromDTOs(List<Order> orders) {
		List<io.macaw.demo.petstore.ordersservice.Order> orderEntities = new ArrayList<io.macaw.demo.petstore.ordersservice.Order>();
		for(Order order : orders) {
			orderEntities.add(getEntityFromDTO(order));
		}
		return orderEntities;
	}
	
	public List<io.macaw.demo.petstore.ordersservice.Order> getOrdersByUser(String id){
		String query = "select * from "+getName()+" where userid = '"+id+"'";
		List<Order> orderDtos = fetchByQuery(query);
		return getEntitiesFromDTOs(orderDtos);
		
	}
}
