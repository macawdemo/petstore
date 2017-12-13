package io.macaw.demo.petstore.userservice.mysql.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.db.mysql.utils.DbConnector;
import io.macaw.demo.petstore.userservice.mysql.db.dto.Account;
import io.macaw.demo.petstore.userservice.mysql.db.dto.Credentials;

public class CredentialsDAO extends BaseDAO<Credentials> {

	public String getName() {
		return "CREDENTIALS";
	}

	@Override
	public Credentials getDto(ResultSet rs) {
		Credentials credentials = new Credentials();
		try {
			if (rs != null) {
				credentials.setUserid(rs.getString("userid"));
				credentials.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credentials;
	}

	@Override
	public String getFindByIdQuery(String id) {
		return "select * from " + getName() + " where userid = '" + id + "'";
	}

	@Override
	public String getDeleteByIdQuery(String id) {
		return "delete from " + getName() + " where userid = '" + id + "'";

	}

	@Override
	public String getInsertQuery(Credentials dto) {

		return "insert into " + getName() + "(userid,password)" + " values('" + dto.getUserid() + "','"
				+ dto.getPassword() + "')";
	}

	@Override
	public String getUpdateQuery(Credentials dto) {
		return "update " + getName() + " set userid ='" + dto.getUserid() + "' " + "where password='"
				+ dto.getPassword() + "'";
	}

	public String verifyCredentials(String id, String password) {
		// TODO: Need to optimise codes
		Account dto = new Account();
		String sql = "select * from " + getName() + "where userid='" + id + "' and password='" + password + "'";
		String message = "not successful";
		DbConnector dbConnector = DbConnector.getInstance();
		Connection conn = dbConnector.getConnection();

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			if (rs != null) {
				if ((rs.getString("userid").equalsIgnoreCase(id)) && (rs.getString("password").equals(password))) {
					message = "success";
				} else {
					message = "not successful";
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return message; // TODO: Modify this function to return numericals
	}

}
