package io.macaw.demo.petstore.productsservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.productsservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.productsservice.mysql.db.dto.Product;

public class ProductDAO extends BaseDAO<Product>{

	@Override
	public String getName() {
		return "PRODUCT";
	}

	@Override
	public Product getDto(ResultSet rs) {
		Product product = new Product();
		try {
			if(rs != null) {
				product.setProductid(rs.getString("productid"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setCategory(rs.getString("category"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from " + getName() + " where productid ='"+id+"'";
	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from "+getName()+" where productid = '"+id+"'";
	}

	@Override
	public String getInsertQuery(Product dto) {
		return "insert into "+getName()+"(productid, name, description, category) "
				+ "values('"+dto.getProductid()+"','"+dto.getName()+"','"+dto.getDescription()+"','"+dto.getCategory()+"')";
	}

	@Override
	public String getUpdateQuery(Product dto) {
		return "update "+getName()+" set name='"+dto.getName()+"', description='"+dto.getDescription()+"' , category='"+dto.getCategory()+"' where categoryid='"+dto.getProductid()+"'";
	}
	

	public List<io.macaw.demo.petstore.productsservice.Product> getProductsByCatIdQuery(String id) {
		String query = "select * from "+getName()+" where category = '"+id+"'";
		List<Product> productDtos = fetchByQuery(query);
			return getEntitiesFromDTOs(productDtos);
	}
	
	public io.macaw.demo.petstore.productsservice.Product getEntityFromDTO(Product product){
		io.macaw.demo.petstore.productsservice.Product productEntity = DomainEntityInstantiator.getInstance().newInstance(io.macaw.demo.petstore.productsservice.Product.class);
		productEntity.setProductid(product.getProductid());
		productEntity.setName(product.getName());
		productEntity.setDescription(product.getDescription());
		productEntity.setCategory(product.getCategory());
		return productEntity;
	}
	
	public List<io.macaw.demo.petstore.productsservice.Product> getEntitiesFromDTOs(List<Product> products){
		List<io.macaw.demo.petstore.productsservice.Product> productEntities = new ArrayList<io.macaw.demo.petstore.productsservice.Product>();
		for(Product product: products) {
			productEntities.add(getEntityFromDTO(product));
		}
		return productEntities;
	}


}
