package io.macaw.demo.petstore.productsservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.productsservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.productsservice.mysql.db.dto.Category;

public class CategoryDAO extends BaseDAO<Category> {

	@Override
	public String getName() {
		return "CATEGORY";
	}

	@Override
	public Category getDto(ResultSet rs) {
		Category category = new Category();
		try {
			if(rs != null) {
				category.setCategoryid(rs.getString("categoryid"));
				category.setName(rs.getString("name"));
				category.setDescription(rs.getString("description"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from "+getName()+" where categoryid = '"+id+"'";

	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from "+getName()+" where categoryid = '"+id+"'";

	}

	@Override
	public String getInsertQuery(Category dto) {
		return "insert into "+getName()+"(categoryid,name, description) "
				+ "values('"+dto.getCategoryid()+"','"+dto.getName()+"','"+dto.getDescription()+"')";
	}

	@Override
	public String getUpdateQuery(Category dto) {
		return "update "+getName()+" set name='"+dto.getName()+ "', description='"+dto.getDescription()+"' where categoryid='"+dto.getCategoryid()+"'";
	}
	
	public io.macaw.demo.petstore.productsservice.Category getEntityFromDTO(Category category) {
		io.macaw.demo.petstore.productsservice.Category categoryEntity = DomainEntityInstantiator.getInstance().newInstance(io.macaw.demo.petstore.productsservice.Category.class);
		categoryEntity.setCategoryid(category.getCategoryid());
		categoryEntity.setName(category.getName());
		categoryEntity.setDescription(category.getDescription());
		return categoryEntity;
	}
	
	public List<io.macaw.demo.petstore.productsservice.Category> getEntitiesFromDTOs(List<Category> categories) {
		List<io.macaw.demo.petstore.productsservice.Category> categoryEntities = new ArrayList<io.macaw.demo.petstore.productsservice.Category>();
		for(Category category : categories) {
			categoryEntities.add(getEntityFromDTO(category));
		}
		return categoryEntities;
	}

}
