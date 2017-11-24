package com.viscount.freedom.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.viscount.freedom.dto.APIResponse;
import com.viscount.freedom.user.domain.AdminUser;
import com.viscount.freedom.user.domain.Users;


// TODO: Auto-generated Javadoc
/**
 * The Interface AdminUserService.
 */
public interface AdminUserService extends UserDetailsService {

	/**
	 * Gets the admin user.
	 *
	 * @param username the username
	 * @return the admin user
	 */
	public APIResponse getAdminUser(final String username);
	
	/**
	 * This method is used to add user info.
	 *
	 * @param adminUser the admin user
	 * @return the API response
	 */
	public APIResponse addUserInfo(final AdminUser adminUser);
	
	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public APIResponse getUsers();
	
	/**
	 * This method is used to update user.
	 *
	 * @param adminUser the admin user
	 * @return the API response
	 */
	public APIResponse editUser(final AdminUser adminUser);
	
	/**
	 * This method is used to delete user.
	 *
	 * @param userId the user id
	 * @return the API response
	 */
	public APIResponse deleteUser(final Long userId);

}
