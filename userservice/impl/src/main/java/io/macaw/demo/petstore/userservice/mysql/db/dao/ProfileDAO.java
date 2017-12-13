package io.macaw.demo.petstore.userservice.mysql.db.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.macaw.db.mysql.utils.BaseDAO;
import io.macaw.demo.petstore.userservice.DomainEntityInstantiator;
import io.macaw.demo.petstore.userservice.mysql.db.dto.Profile;

public class ProfileDAO extends BaseDAO<Profile> {

	public String getName() {
		return "PROFILE";
	}

	@Override
	public Profile getDto(ResultSet rs) {
		Profile profile = new Profile();
		try {
			if (rs != null) {
				profile.setUserid(rs.getString("userid"));
				profile.setLangref(rs.getString("langref"));
				profile.setFavcategory(rs.getString("favcateogory"));
				profile.setOptedfor(rs.getBoolean("optedfor"));
				profile.setBanneropt(rs.getBoolean("banneropt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profile;
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
	public String getInsertQuery(Profile dto) {
		return "insert into " + getName() + "(userid,langref,favcategory,optedfor,banneropt)" + " values('"
				+ dto.getUserid() + "','" + dto.getLangref() + "','" + dto.getFavcategory() + "','" + dto.getOptedfor()
				+ "','" + dto.getBanneropt() + "')";
	}

	@Override
	public String getUpdateQuery(Profile dto) {
		return "update " + getName() + " set langref ='" + dto.getLangref() + "',favcategory='" + dto.getFavcategory()
				+ "',optedfor='" + dto.getOptedfor() + "','" + dto.getBanneropt() + "' where userid='" + dto.getUserid()
				+ "'";
	}

	public io.macaw.demo.petstore.userservice.Profile getEntityFromDTO(Profile profile) {
		io.macaw.demo.petstore.userservice.Profile profileEntity = DomainEntityInstantiator.getInstance()
				.newInstance(io.macaw.demo.petstore.userservice.Profile.class);
		profileEntity.setUserid(profile.getUserid());
		profileEntity.setFavcategory(profile.getFavcategory());
		profileEntity.setBanneropt(profile.getBanneropt());
		profileEntity.setLangpref(profile.getLangref());
		profileEntity.setOptedfor(profile.getOptedfor());
		return profileEntity;
	}

	public List<io.macaw.demo.petstore.userservice.Profile> getEntitiesFromDTOs(List<Profile> profiles) {
		List<io.macaw.demo.petstore.userservice.Profile> profileEntities = new ArrayList<io.macaw.demo.petstore.userservice.Profile>();
		for (Profile profile : profiles) {
			profileEntities.add(getEntityFromDTO(profile));
		}
		return profileEntities;
	}

}
