package com.viscount.freedom.user.controller;

import javax.xml.ws.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.viscount.freedom.dto.APIResponse;
import com.viscount.freedom.user.domain.Users;
import com.viscount.freedom.user.service.UserService;

/**
 * The Class AdminUserController.
 * 
 */
@Component
@Controller
@RequestMapping("/users")
public class UserController {

	/**
	 * The Constant log.
	 */
	private static final Logger log = Logger.getLogger(UserController.class);

	/**
	 * The admin user service.
	 */
	@Autowired
	UserService userService;

	/**
	 * This controller is used to process addUser @POST request.
	 *
	 * @param user
	 *            the admin user
	 * @return {@link Response}
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).USERS, T(com.viscount.freedom.user.model.Permission).CREATE)")
	public APIResponse addUser(@RequestBody Users user) {
		APIResponse apiResponse = null;
		try {
			if (user != null) {
				apiResponse = userService.addUser(user);
				if (apiResponse.getStatus()) {
					return apiResponse;
				}
			}
		} catch (Exception e) {
			log.error("Error in UserController.addUser ", e);
			return apiResponse;
		}
		return apiResponse;
	}

	/**
	 * This controller is used to process authenticate POST request.
	 *
	 * @return {@link Response}
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).USERS, T(com.viscount.freedom.user.model.Permission).VIEW)")
	public APIResponse getUsers() throws Exception {
		return userService.getUsers();
	}

	/**
	 * Edits the user.
	 *
	 * @param user
	 *            the admin user
	 * @return the API response
	 */
	@RequestMapping(value = "/updateAdminUser", method = RequestMethod.PUT)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).USERS, T(com.viscount.freedom.user.model.Permission).EDIT)")
	public APIResponse editUser(@RequestBody Users user) {
		APIResponse apiResponse = null;
		if (user != null) {
			apiResponse = userService.editUser(user);
		}
		return apiResponse;
	}

	/**
	 * Detete user.
	 *
	 * @param userId
	 *            the user id
	 * @return the API response
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/deleteAdminUser/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).USERS, T(com.viscount.freedom.user.model.Permission).DELETE)")
	public APIResponse deteteUser(@PathVariable("userId") Long userId) throws Exception {
		APIResponse apiResponse = null;
		if (userId != null && userId != 0) {
			apiResponse = userService.deleteUser(userId);
		}
		return apiResponse;
	}
}
