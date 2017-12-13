package io.macaw.demo.petstore.userservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.userservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.userservice.mysql.db.dto.Account;

public class AccountDAO extends BaseDAO<Account> {

	public String getName() {
		return "ACCOUNT";
	}

	@Override
	public Account getDto(ResultSet rs) {
		Account account = new Account();
		try {
			if (rs != null) {
				account.setUserid(rs.getString("userid"));
				account.setEmail(rs.getString("email"));
				account.setFirstname(rs.getString("firstname"));
				account.setLastname(rs.getString("lastname"));
				account.setStatus(rs.getBoolean("status"));
				account.setAddr1(rs.getString("addr1"));
				account.setAddr2(rs.getString("addr2"));
				account.setCity(rs.getString("city"));
				account.setState(rs.getString("state"));
				account.setZip(rs.getString("zip"));
				account.setCountry(rs.getString("country"));
				account.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
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
	public String getInsertQuery(Account dto) {
		return "insert into " +getName()
				+ "(userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone) " + " values('"
				+dto.getUserid()+"','"+dto.getEmail()+"','"+dto.getFirstname()+"',+'"+dto.getLastname()
				+"','"+dto.getStatus()+"','"+dto.getAddr1()+"','"+dto.getAddr2()+"','"+dto.getCity()
				+ "','"+dto.getState()+"','"+dto.getZip()+"','"+dto.getCountry()+"','"+dto.getPhone()
				+ "' )";
	}

	@Override
	public String getUpdateQuery(Account dto) {

		return "update " +getName()+" set email='"+dto.getEmail()+"',firstname='"+dto.getFirstname()
				+"',lastname='"+dto.getLastname()+"',status='"+dto.getStatus()+"', addr1='"+dto.getAddr1()
				+"',addr2='"+dto.getAddr2()+"',city='"+dto.getCity()+"',state='"+dto.getCity()+"',state='"
				+dto.getState()+"',zip='"+dto.getZip()+"',country='"+dto.getCountry()+"',phone='"+dto.getPhone()
				+"where userid='"+dto.getUserid()+"'";

	}
	public io.macaw.demo.petstore.userservice.Account getEntityFromDTO(Account account){
		io.macaw.demo.petstore.userservice.Account accountEntity = DomainEntityInstantiator.getInstance().newInstance(io.macaw.demo.petstore.userservice.Account.class);
		accountEntity.setUserid(account.getUserid());
		accountEntity.setFirstname(account.getFirstname());
		accountEntity.setLastname(account.getLastname());
		accountEntity.setStatus(account.getStatus());
		accountEntity.setAddr1(account.getAddr1());
		accountEntity.setAddr2(account.getAddr2());
		accountEntity.setCity(account.getCity());
		accountEntity.setState(account.getState());
		accountEntity.setZip(account.getZip());
		accountEntity.setCountry(account.getCountry());
		accountEntity.setPhone(account.getPhone());
		return accountEntity;
	}

	public List<io.macaw.demo.petstore.userservice.Account> getEntitiesFromDTOs(List<Account> accounts){
		List<io.macaw.demo.petstore.userservice.Account> accountEntities = new ArrayList<io.macaw.demo.petstore.userservice.Account>();
		for(Account account : accounts) {
			accountEntities.add(getEntityFromDTO(account));
		}
		return accountEntities;
	}
	
	
}
