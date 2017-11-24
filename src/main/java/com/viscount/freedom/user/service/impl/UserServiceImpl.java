package com.viscount.freedom.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.viscount.freedom.dto.APIResponse;
import com.viscount.freedom.user.dao.AdminUserDao;
import com.viscount.freedom.user.dao.UserDao;
import com.viscount.freedom.user.domain.AdminUser;
import com.viscount.freedom.user.domain.UserRole;
import com.viscount.freedom.user.domain.Users;
import com.viscount.freedom.user.service.AdminUserService;
import com.viscount.freedom.user.service.UserService;

/**
 * The Class AdminUserServiceImpl.
 * @author Administrator 
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(UserServiceImpl.class);

	/** The user found. */
	@Value("user.record.found")
	private String userFound;
	
	/** The user not found. */
	@Value("user.record.notfound")
	private String userNotFound;
	
	/** The admin user dao. */
	@Autowired
	UserDao userDao;
	
	/**
	 * This method is used to add user info
	 * @param adminUser
	 * @return {@link APIResponse}
	 */
	@Transactional
	public APIResponse addUser(final Users user) {
		APIResponse apiResponse = new APIResponse();
		try {
			if(user != null){
					userDao.save(user);
					apiResponse.setStatus(true);	
			}else {
				apiResponse.setStatus(false);
				apiResponse.setUserMessage(userNotFound);
			}
			
		} catch (Exception e) {
			apiResponse.setStatus(false);
			apiResponse.setUserMessage(e.getClass().getName());
			log.error("Error in UserService.addUserInfo ", e);
		}
		return apiResponse;
	}
	
	 /**
	 * This method is used to get user info
	 * @param
	 * @return APIResponse
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true)
	public APIResponse getUsers()
	{
		APIResponse apiResponse = new APIResponse();
		try
		{
			List<Users> users = userDao.findAll(Users.class);
			if(users!=null)
			{
				apiResponse.setObject(users);
				apiResponse.setStatus(true);
			}
		}
		catch(Exception e)
		{
			apiResponse.setStatus(false);
			apiResponse.setUserMessage(e.getClass().getName());
			
		}
		System.out.println("getUsers" + apiResponse);
		return apiResponse;
	}
	
	/**
	 * This method is used to update user info
	 * @param
	 * @return APIResponse
	 */
	
	@Override
	@Transactional
	public APIResponse editUser(final Users user)
	{
		APIResponse apiResponse = new APIResponse();
		try
		{
			userDao.update(user);
			apiResponse.setStatus(true);
		}
		catch(Exception e)
		{
			log.error("Error in UserService.editUser: ", e);
			apiResponse.setStatus(false);
		}
		return apiResponse;
	}
	
	/**
	 * This method is used to delete user info
	 * @param Long-userId
	 * @return APIResponse
	 */
	
	@Override
	@Transactional
	public APIResponse deleteUser(final Long userId)
	{
		APIResponse apiResponse = new APIResponse();
		Users user = null;
		try
		{
			if(userId != 0 && userId != null){
				user = userDao.findById(userId);
				if(user != null){
					userDao.delete(user);		
					apiResponse.setStatus(true);
				}else{
					apiResponse.setStatus(false);
					apiResponse.setUserMessage(userNotFound);
				}
			}
			
		}
		catch(Exception e)
		{
			log.error("Error in UserService.deleteUser: ", e);
			apiResponse.setStatus(false);
		}
		return apiResponse;
		
	}

}
