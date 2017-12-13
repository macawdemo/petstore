package io.macaw.demo.petstore.productsservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.productsservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.productsservice.mysql.db.dto.Supplier;

public class SupplierDAO extends BaseDAO<Supplier> {

	@Override
	public String getName() {
		return "SUPPLIER";
	}

	@Override
	public Supplier getDto(ResultSet rs) {
		Supplier supplier = new Supplier();
		try {
			if(rs != null) {
				supplier.setSupplierid(rs.getString("supplierid"));
				supplier.setName(rs.getString("name"));
				supplier.setStatus(rs.getString("status"));
				supplier.setAddr1(rs.getString("addr1"));
				supplier.setAddr2(rs.getString("addr2"));
				supplier.setCity(rs.getString("city"));
				supplier.setCity(rs.getString("state"));
				supplier.setCity(rs.getString("zip"));
				supplier.setPhone(rs.getString("phone"));
			}
			}catch(Exception e) {
				e.printStackTrace();
			
		}
		return supplier;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from "+getName()+" where supplierid = '"+id+"'" ;
	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from "+getName()+" where supplierid = '"+id+"'";

	}

	@Override
	public String getInsertQuery(Supplier dto) {
		return "insert into "+getName()+"(supplierid, name, status, addr1, addr2, city, state, zip, phone) "
				+ "values('"+dto.getSupplierid()+"','"+dto.getName()+"','"+dto.getStatus()+"','"+dto.getAddr1()+"','"+dto.getAddr2()+"','"+dto.getCity()+"','"+dto.getState()+"','"+dto.getZip()+"','"+dto.getPhone()+"')";
	}

	@Override
	public String getUpdateQuery(Supplier dto) {
		return "update "+getName()+" set name="+dto.getName()+ ", status=" + dto.getStatus() + ", addr1=" + dto.getAddr1() + ", addr2=" + dto.getAddr2() + ", city=" + dto.getCity() + ", state=" + dto.getState() + ", zip=" + dto.getZip() + ", phone=" + dto.getPhone() +" where supplierid='"+dto.getSupplierid()+"'";
	}

	public io.macaw.demo.petstore.productsservice.Supplier getEntityFromDTO(Supplier supplier) {
		io.macaw.demo.petstore.productsservice.Supplier supplierEntity = DomainEntityInstantiator.getInstance().newInstance(io.macaw.demo.petstore.productsservice.Supplier.class);
		supplierEntity.setSupplierid(supplier.getSupplierid());
		supplierEntity.setName(supplier.getName());
		supplierEntity.setStatus(supplier.getStatus());
		//TODO: Implement address details later. API needs regeneration.
		return supplierEntity;
	}
	
	public List< io.macaw.demo.petstore.productsservice.Supplier> getEntitiesFromDTOs(List<Supplier> suppliers){
		List< io.macaw.demo.petstore.productsservice.Supplier> supplierEntities = new ArrayList< io.macaw.demo.petstore.productsservice.Supplier>();
		for(Supplier supplier : suppliers) {
			supplierEntities.add(getEntityFromDTO(supplier));
			}
		return supplierEntities;
	}

	
}
