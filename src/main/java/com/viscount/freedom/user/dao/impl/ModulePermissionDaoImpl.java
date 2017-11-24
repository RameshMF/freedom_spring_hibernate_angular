package com.viscount.freedom.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.viscount.freedom.dbconfig.util.ManageSessionFactory;
import com.viscount.freedom.user.dao.ModulePermissionDao;
import com.viscount.freedom.user.domain.UserRoleModule;
import com.viscount.freedom.user.model.ModulePermission;


/**
 * The Class ModulePermissionDaoImpl.
 */
@Repository
public class ModulePermissionDaoImpl extends BaseDAO implements ModulePermissionDao{

	
	/**
	 * Gets the user module permissions.
	 *
	 * @param username the username
	 * @return the user module permissions
	 * @throws UsernameNotFoundException the username not found exception
	 */
	public List<ModulePermission> getUserModulePermissions(String username) throws UsernameNotFoundException{

		List<ModulePermission> modulePermissionList = new ArrayList<ModulePermission>();
		Session session  = ManageSessionFactory.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserRoleModule.class,"userRoleModule").createAlias("module", "module")
				.createAlias("userRole", "userRole").createAlias("userRole.user", "user").add(Restrictions.eq("user.userName", username));
		ProjectionList projectionList  = Projections.projectionList();
		projectionList.add(Projections.property("module.name"));
		projectionList.add(Projections.property("userRoleModule.permission"));
		criteria.setProjection(projectionList);
		List<Object[]> rows = criteria.list();
		for (Object[] objects : rows) {

			ModulePermission modulePermission = new ModulePermission();
			modulePermission.setModule((String) objects[0]);
			modulePermission.setPermission((Integer) objects[1]);
			modulePermissionList.add(modulePermission);
		}
		closeSession(session);
		return modulePermissionList;
	}
}
