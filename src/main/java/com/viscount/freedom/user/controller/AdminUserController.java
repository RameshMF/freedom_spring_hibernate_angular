package com.viscount.freedom.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.viscount.freedom.dbconfig.domain.DatabaseDetail;
import com.viscount.freedom.dbconfig.service.DatabaseDetailService;
import com.viscount.freedom.dbconfig.util.ManageSessionFactory;
import com.viscount.freedom.dto.APIResponse;
import com.viscount.freedom.user.domain.AdminUser;
import com.viscount.freedom.user.dto.UserLogin;
import com.viscount.freedom.user.service.AdminUserService;


/**
 * The Class AdminUserController.
 * 
 */
@Component
@Controller
@RequestMapping("/user")
public class AdminUserController {

	/**
	 * The Constant log.
	 */
	private static final Logger log = Logger.getLogger(AdminUserController.class);
	
	/**
	 * The admin user service.
	 */
	@Autowired
	AdminUserService adminUserService;
	
	/**
	 * The database detail service.
	 */
	@Autowired
	DatabaseDetailService databaseDetailService;
	
	/**
	 * The authentication manager.
	 */
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	/**
	 * This controller is used to process authenticate POST request.
	 *
	 * @param user the user
	 * @param session the session
	 * @return {@link Response}
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(@ModelAttribute UserLogin user, HttpSession session) {
		APIResponse apiResponse = null;
		Authentication authentication = null;
		//String success = "JSON";
		try {
			
			// Configure sessionFactory if record exist in database
			apiResponse = databaseDetailService.getActiveDatabaseDetail();
			if(apiResponse.getStatus()) {
				DatabaseDetail databaseDetail = (DatabaseDetail) apiResponse.getObject();
				ManageSessionFactory.configureSessionFactory(databaseDetail);
			}
			
			if(user.getUsername() != null && user.getPassword() != null){
				try{
					apiResponse = adminUserService.getAdminUser(user.getUsername());
					if(apiResponse.getStatus()){
						UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
						authentication = this.authenticationManager.authenticate(authenticationToken);
						SecurityContextHolder.getContext().setAuthentication(authentication);
						AdminUser adminUser = (AdminUser) apiResponse.getObject();
						session.setAttribute("user_accountId", adminUser.getUserId());
						return "redirect:/#/listUser";
					} 
				} catch (AuthenticationException authException){
					log.info("User unauthorize", authException);
				}
			} 
		} catch(Exception e) {
			log.error("Error in UserController.authenticate ", e);
		}
		return "redirect:/#/login";
    }

	/**
	 * This controller is used to process addUser @POST request.
	 *
	 * @param adminUser the admin user
	 * @return {@link Response}
	 */
	@RequestMapping(value = "/addAdminUser", method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).ADMIN_USERS, T(com.viscount.freedom.user.model.Permission).CREATE)")
	public APIResponse addUser(@RequestBody AdminUser adminUser){
		APIResponse apiResponse = null;
		try{
			if(adminUser != null){
				apiResponse = adminUserService.addUserInfo(adminUser);
				if(apiResponse.getStatus()){
					return apiResponse;
				} 
			}	
		}catch (Exception e){
			log.error("Error in UserController.addUser ", e);
				return apiResponse;
		}
		return apiResponse;
	}

	
	/**
	 * This controller is used to process logout DELETE request.
	 *
	 * @param httpServletRequest the http servlet request
	 * @return {@link APIResponse}
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest httpServletRequest){
		try {
		HttpSession httpSession = httpServletRequest.getSession(false);
	    SecurityContextHolder.clearContext();
		if(httpSession != null){
			httpSession.invalidate();	
		}
		} catch (Exception e) {
			log.error("Error in UserController.logout ", e);
		}
		return "redirect:/#/login";
	}
	
	/**
	 * This controller is used to process authenticate POST request.
	 *
	 * @return {@link Response}
	 * @throws Exception the exception
	 */
    @RequestMapping(value = "/getAdminUsers", method = RequestMethod.GET)
    @ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).ADMIN_USERS, T(com.viscount.freedom.user.model.Permission).VIEW)")
	public APIResponse getUsers() throws Exception
	{
		return adminUserService.getUsers();
	}
	
	 
	/**
	 * Edits the user.
	 *
	 * @param adminUser the admin user
	 * @return the API response
	 */
	@RequestMapping(value = "/updateAdminUser", method = RequestMethod.PUT)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).ADMIN_USERS, T(com.viscount.freedom.user.model.Permission).EDIT)")
	public APIResponse editUser(@RequestBody AdminUser adminUser)
	{
		APIResponse apiResponse=null;
		if(adminUser!=null)
		{
			apiResponse = adminUserService.editUser(adminUser);
		}
		return apiResponse;
	}

	/**
	 * Detete user.
	 *
	 * @param userId the user id
	 * @return the API response
	 * @throws Exception the exception
	 */
	@RequestMapping(value = "/deleteAdminUser/{userId}", method = RequestMethod. DELETE)
	@ResponseBody
	@PreAuthorize("hasPermission(T(com.viscount.freedom.user.model.Module).ADMIN_USERS, T(com.viscount.freedom.user.model.Permission).DELETE)")
	public APIResponse deteteUser(@PathVariable("userId") Long userId) throws Exception
	{
		APIResponse apiResponse = null;
		if(userId!=null && userId!=0)
		{
			apiResponse = adminUserService.deleteUser(userId);
		} 
		return apiResponse;
	}
}
