package com.viscount.freedom.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.viscount.freedom.user.dao.UserDao;
import com.viscount.freedom.user.domain.Users;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Users> implements UserDao {

	public UserDaoImpl() {
		super(Users.class);
	}
/*
	*//**
	 * This method is used to fetch all users
	 * @param 
	 * @return List-userInfo
	 *//*
	@Override
	public List<Users> findAll() throws Exception {
		//List<AdminUser> adminUsers = null;
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		List<Users> users = new ArrayList<>();
		Criteria criteria = session.createCriteria(AdminUser.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("userId"));
		projectionList.add(Projections.property("userName"));
		projectionList.add(Projections.property("firstName"));
		projectionList.add(Projections.property("lastName"));
		projectionList.add(Projections.property("business"));
		projectionList.add(Projections.property("sites"));
		projectionList.add(Projections.property("userLanguage"));
		criteria.setProjection(projectionList);
		List<Object[]> rows = criteria.list();
		for (Object[] object : rows) {
			AdminUser adminUser = new AdminUser();
			adminUser.setUserId((Long) object[0]);
			adminUser.setUserName((String) object[1]);
			adminUser.setFirstName((String) object[2]);
			adminUser.setLastName((String) object[3]);
			adminUser.setBusiness((String) object[4]);
			adminUser.setSites((String) object[5]);
			adminUser.setUserLanguage((String) object[6]);
			//users.add(adminUser);
		}
		closeSession(session);
		return users;
	}*/

}
