package com.viscount.freedom.auth;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.viscount.freedom.user.model.Permission;

public class AuthorityManager {
	
	private static final Logger LOGGER = Logger.getLogger(AuthorityManager.class);
	
    public static boolean isPermitted(int myPermissions, Permission authorityToCheck ) {
        return ((myPermissions & authorityToCheck.getPermissionValue()) == authorityToCheck.getPermissionValue());
    }
    
    public static int addPermission(int myPermissions, Permission authorityToAdd) throws Exception {
        return addPermissions(myPermissions, new int[] { authorityToAdd.getPermissionValue() } );
    }
    
    public static int addPermissions(int myPermissions, int[] authorityToAdd) throws Exception {
        for (int i = 0; i < authorityToAdd.length; i++) {
        	Permission authority = Permission.findByValue(authorityToAdd[i]);
        	if(authority != null){
        		myPermissions |= authorityToAdd[i];
        	}
        }
        return myPermissions;
    }
    
    public static int deletePermission( int myPermissions, Permission authorityToDelete ) throws Exception {
    	return deletePermissions(myPermissions, new int[] { authorityToDelete.getPermissionValue() } );
    }

    public static int deletePermissions(int myPermissions, int[] authorityToDelete ) throws Exception {
        for (int i = 0; i < authorityToDelete.length; i++) {
        	Permission authority = Permission.findByValue(authorityToDelete[i]);
        	if(authority != null){
        		myPermissions &= ~authorityToDelete[i];
        	}
        }
        return myPermissions;
    }
    
    public static int togglePermission( int myPermissions, Permission authorityToToggle ) throws Exception {

        myPermissions ^= authorityToToggle.getPermissionValue();
        return myPermissions;
    }
    
    public static Map<Permission, Boolean> getPermissionMap(Integer myPermissions){
    	Map<Permission, Boolean> accessMap = new HashMap<Permission, Boolean>();
    	if(myPermissions != null){
        	for (Permission authority : Permission.values()) {
        		accessMap.put(authority, isPermitted(myPermissions, authority));
    		}
    	}
    	return accessMap;
    }
    
    public static void main(String args []) {
    	
    	//System.out.println(Integer.parseInt("11110", 16));  
    	//System.out.println(Permission.FULL_ACCESS.getPermissionValue());
    	System.out.println(2|4|16);
    	System.out.println(Permission.VIEW.getPermissionValue() | Permission.CREATE.getPermissionValue() | Permission.DELETE.getPermissionValue());
    	System.out.println(Permission.VIEW.getPermissionValue());
    	System.out.println(Permission.CREATE.getPermissionValue());
    	System.out.println(Permission.EDIT.getPermissionValue());
    	System.out.println(Permission.DELETE.getPermissionValue());
    	
    	System.out.println(isPermitted(Permission.VIEW_CREATE_DELETE.getPermissionValue(), Permission.VIEW));
    	System.out.println(isPermitted(Permission.VIEW_CREATE_DELETE.getPermissionValue(), Permission.CREATE));
    	System.out.println(isPermitted(Permission.VIEW_CREATE_DELETE.getPermissionValue(), Permission.EDIT));
    	System.out.println(isPermitted(Permission.VIEW_CREATE_DELETE.getPermissionValue(), Permission.DELETE));
    	System.out.println(isPermitted(Permission.VIEW_CREATE_DELETE.getPermissionValue(), Permission.NO_ACCESS));
    	int a=10,b=20;
    	//a ^= b; 
    	a=a^b;
    	b=b^a;	
    	a=a^b;
    	//b ^= a;
    	//a ^= b;
    	System.out.println(a);
    	System.out.println(b);
    }
}
