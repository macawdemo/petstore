package io.macaw.demo.petstore.userservice.mysql.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.userservice.mysql.db.dto.Bannerdata;

public class BannerdataDAO extends BaseDAO<Bannerdata> {

	public String getName() {
		return "BANNERDATA";
	}

	@Override
	public Bannerdata getDto(ResultSet rs) {
		Bannerdata bannerdata = new Bannerdata();
		try {
			if (rs != null) {
				bannerdata.setFavcategory(rs.getString("favcategory"));
				bannerdata.setBannername(rs.getString("bannername"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bannerdata;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from " + getName() + " where favcategory = '" + id + "'";
	}

	@Override
	public String getDeleteByIdQuery(String id) {

		return "delete from " + getName() + " where favcategory = '" + id + "'";
	}

	@Override
	public String getInsertQuery(Bannerdata dto) {

		return "insert into " + getName() + "(favcategory,bannername)" + " values('" + dto.getFavcategory() + "',"
				+ dto.getBannername() + ")";
	}

	@Override
	public String getUpdateQuery(Bannerdata dto) {
		return "update '" + getName() + "' set bannername ='" + dto.getBannername() + "'" + "where favcategory='"
				+ dto.getFavcategory() + "'";

	}

}
