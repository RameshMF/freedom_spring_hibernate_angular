package com.viscount.freedom.user.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.viscount.freedom.user.domain.AdminUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdminUserDao.
 */
public interface AdminUserDao extends GenericDao<AdminUser> {
	
	/**
	 * Find by user name.
	 *
	 * @param username the username
	 * @return the admin user
	 * @throws UsernameNotFoundException the username not found exception
	 * @throws Exception 
	 */
	public AdminUser findByUserName(String username) throws UsernameNotFoundException, Exception;

	/**
	 * Check user name.
	 *
	 * @param userName the user name
	 * @return true, if successful
	 * @throws Exception 
	 */
	public boolean checkUserName(String userName) throws Exception;

	
	/**
	 * Find all.
	 *
	 * @return the list
	 * @throws Exception 
	 */
	List<AdminUser> findAll() throws Exception;

}
