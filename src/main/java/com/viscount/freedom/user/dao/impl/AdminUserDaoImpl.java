package com.viscount.freedom.user.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.viscount.freedom.dbconfig.util.ManageSessionFactory;
import com.viscount.freedom.user.dao.AdminUserDao;
import com.viscount.freedom.user.domain.AdminUser;
import com.viscount.freedom.user.domain.Module;
import com.viscount.freedom.user.domain.Role;
import com.viscount.freedom.user.domain.UserRole;
import com.viscount.freedom.user.domain.UserRoleModule;

@Repository
public class AdminUserDaoImpl extends GenericDaoImpl<AdminUser> implements AdminUserDao {

	public AdminUserDaoImpl() {
		super(AdminUser.class);
	}
	/**
	 * This method is to find user by user name
	 * @throws Exception 
	 */
	@Override
	public AdminUser findByUserName(final String userName) throws Exception{

		Session session = ManageSessionFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(AdminUser.class);
		criteria.add(Restrictions.eq("userName", userName));
		AdminUser adminUserDetails = (AdminUser) criteria.uniqueResult();
		if(adminUserDetails != null){
			getUserRoles(adminUserDetails);	
		}else {
			return adminUserDetails;
		}
		closeSession(session);
		return adminUserDetails;
	}

	/**
	 * This method is used to get all roles for a user
	 * @param session 
	 * @param userInfo
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private AdminUser getUserRoles(AdminUser adminUser) throws Exception {
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		List<UserRole> userRoles = new ArrayList<UserRole>();
		Criteria criteria = session.createCriteria(UserRole.class,"userRole") 
				.createAlias("role", "role").createAlias("user", "user")
				.add(Restrictions.eq("user.userId", adminUser.getUserId()));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("role.id"));
		projectionList.add(Projections.property("role.name"));
		projectionList.add(Projections.property("userRole.id"));
		criteria.setProjection(projectionList);
		List<Object[]> rows = criteria.list();
		for (Object[] object : rows) {
			Role role = new Role();
			role.setId((Long) object[0]);
			role.setName((String) object[1]);

			UserRole userRole = new UserRole();
			userRole.setId((Long) object[2]);
			userRole.setRole(role);
			userRoles.add(userRole);
		}
		Set<UserRole> uniqueRoles = new HashSet<UserRole>(userRoles);
		adminUser.setUserRoles(uniqueRoles);

		if(adminUser != null){
			for (UserRole userRole : adminUser.getUserRoles()) {
				userRole.setUser(adminUser);
				uniqueRoles.add(getUserModules(userRole));
			}

			adminUser.setUserRoles(uniqueRoles);
		}

		closeSession(session);
		return adminUser;
	}


	/**
	 * This method is used to get all roles for a user
	 * @param session 
	 * @param userInfo
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private UserRole getUserModules(UserRole userRole) throws Exception {
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		List<UserRoleModule> userModules = new ArrayList<UserRoleModule>();
		Criteria criteria = session.createCriteria(UserRoleModule.class) 
				.createAlias("userRole", "userRole")
				.createAlias("module", "module")
				.add(Restrictions.eq("userRole.id", userRole.getId()));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("module.id"));
		projectionList.add(Projections.property("module.name"));
		criteria.setProjection(projectionList);
		List<Object[]> rows = criteria.list();

		for (Object[] object : rows) {

			Module module = new Module();
			module.setId((Long) object[0]);
			module.setName((String) object[1]);

			UserRoleModule  userRoleModule = new UserRoleModule();
			userRoleModule.setModule(module);
			userModules.add(userRoleModule);
		}

		if(userRole != null){
			Set<UserRoleModule> userModulesSet = new HashSet<UserRoleModule>(userModules);
			userRole.setUserRoleModules(userModulesSet);
		}

		closeSession(session);
		return userRole;
	}

	/**
	 * This method is used to check for existing username
	 * @param userName
	 * @return
	 */
	public boolean checkUserName(String userName) throws Exception {
		Session session = null;
		session = ManageSessionFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(AdminUser.class).add(Restrictions.eq("userName", userName));
		if(criteria.list() != null && criteria.list().size() > 0){
			return true;
		}
		closeSession(session);
		return false;
	}

	/**
	 * This method is used to fetch all users
	 * @param 
	 * @return List-userInfo
	 */
	@Override
	public List<AdminUser> findAll() throws Exception {
		//List<AdminUser> adminUsers = null;
		Session session = ManageSessionFactory.getSessionFactory().openSession();
		List<AdminUser> adminUsers = new ArrayList<>();
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
			adminUsers.add(adminUser);
		}
		closeSession(session);
		return adminUsers;
	}
	
}
