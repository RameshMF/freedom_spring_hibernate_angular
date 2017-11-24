package com.viscount.freedom.auth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.viscount.freedom.user.dao.ModulePermissionDao;
import com.viscount.freedom.user.model.Module;
import com.viscount.freedom.user.model.ModulePermission;
import com.viscount.freedom.user.model.Permission;


public class BasePermissionEvaluator implements PermissionEvaluator
{
	@Autowired
	ModulePermissionDao modulePermissionDao;
	
	@Override
	public boolean hasPermission(Authentication authentication,
										Object targetDomainObject,
										Object permissions)
	{
		boolean hasPermission = false;
		
		try
		{
			List<ModulePermission> modulePermissions = modulePermissionDao.getUserModulePermissions(authentication.getName());

			if (authentication != null && targetDomainObject instanceof Module) {
				final Module module = (Module) targetDomainObject;
				
				if(permissions instanceof Permission){

					final Permission permissionObj = (Permission)permissions;

					for (ModulePermission modulePermission : modulePermissions) {
					
						if(modulePermission.getModule().equals(module.name())){
							boolean isPermitted = AuthorityManager.isPermitted(modulePermission.getPermission(), permissionObj);
							return isPermitted;
						}
					}
					return hasPermission;
				} else if (permissions instanceof ArrayList) {

					@SuppressWarnings("unchecked")
					final ArrayList<Permission> permissionList = (ArrayList<Permission>) permissions;
					if(permissionList.contains(Permission.NO_ACCESS)){
						// return false
						return hasPermission;
					}
					for (ModulePermission modulePermission : modulePermissions) {
						
						if(modulePermission.getModule().equals(module.name())){
							
							for(Permission permissionObj : permissionList){
								boolean isPermitted = AuthorityManager.isPermitted(modulePermission.getPermission(), permissionObj);
								if(!isPermitted)
									return hasPermission;
							}
						}
					}
					return true;
				} 
			}
		} catch(Exception exception){
			// Maintain log
		}
		return hasPermission;
	}

	@Override
	public boolean hasPermission( Authentication authentication,
									Serializable targetId,
									String targetType,
									Object permission)
	{
		throw new RuntimeException("Id and Class permissions are not supperted by this application");
//		return false;
	}

}
