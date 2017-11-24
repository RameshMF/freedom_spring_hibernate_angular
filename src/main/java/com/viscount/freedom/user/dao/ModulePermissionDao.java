package com.viscount.freedom.user.dao;

import java.util.List;

import com.viscount.freedom.user.model.ModulePermission;

/**
 * The Interface ModulePermissionDao.
 */
public interface ModulePermissionDao {
	
	/**
	 * Gets the user module permissions.
	 *
	 * @param name the name
	 * @return the user module permissions
	 */
	public List<ModulePermission> getUserModulePermissions(String name);
}
