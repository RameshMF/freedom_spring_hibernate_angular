package com.viscount.freedom.dbconfig.controller;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.viscount.freedom.dbconfig.domain.DatabaseDetail;
import com.viscount.freedom.dbconfig.domain.GlobalData;
import com.viscount.freedom.dbconfig.service.DatabaseDetailService;
import com.viscount.freedom.dto.APIResponse;

/**
 * The Class DBConfigController.
 * This class is mainly created to get the request from client application's to configure 
 * database( Switch database at runtime) as per choice like MySQL or Postgres.
 * @author Administrator
 * @since
 * @version
 */

@Controller
@RequestMapping("/dbconfig")
public class DBConfigController {

	/** The database detail service. */
	@Autowired
	private transient DatabaseDetailService databaseDetailService;

	/** The logger. */
	private final Logger logger = Logger.getLogger(getClass());

	/**
	 * This method is used to get the all database details.
	 *
	 * @return the all database detail
	 */
	@RequestMapping(value = "getAll")
	public @ResponseBody APIResponse getAllDatabaseDetail() {

		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.getAllDatabaseDetail();
		} catch (Exception exception) {
			this.logger.error("", exception);
			exception.printStackTrace();
		}
		return apiResponse;
	}

	/**
	 * Gets the active db property.
	 *
	 * @return the active db property
	 */
	@RequestMapping(value = "getActiveDbProp")
	public @ResponseBody APIResponse getActiveDbProperty() {
		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.getActiveDbGlobalData();
		} catch (Exception exception) {
			this.logger.error("", exception);
		}
		return apiResponse;
	}
	
	/**
	 * Update active db global data.
	 *
	 * @param globalDatas the global data.
	 * @return the API response for global data updated.
	 */
	@RequestMapping(value = "updateActiveDbProp", method = RequestMethod.POST)
	public @ResponseBody APIResponse updateActiveDbGlobalData(@RequestBody Set<GlobalData> globalDatas) {
		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.updateGlobalData(globalDatas);
		} catch (Exception exception) {
			this.logger.error("", exception);
		}
		return apiResponse;
	}


	/**
	 * Checks if database is configured.
	 *
	 * @return the API response
	 */
	@RequestMapping(value = "isConfigured")
	public @ResponseBody APIResponse isConfigured() {
		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.getActiveDatabaseDetail();
		} catch (Exception exception) {
			this.logger.error("", exception);
		}
		return apiResponse;
	}

	/**
	 * Gets the active database detail.
	 *
	 * @return the active database detail
	 */
	@RequestMapping(value = "getActive")
	public @ResponseBody APIResponse getActiveDatabaseDetail() {
		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.getActiveDatabaseDetail();
			
		} catch (Exception exception) {
			this.logger.error("", exception);
			exception.printStackTrace();
		}
		return apiResponse;
	}

	/**
	 * Adds the database details by filter.
	 *
	 * @param databaseDetail the database detail
	 * @return the API response
	 */
	@RequestMapping(value = "addUpdate", method = RequestMethod.POST)
	public @ResponseBody APIResponse addDatabaseDetailsByFilter(@RequestBody DatabaseDetail databaseDetail) {
		APIResponse apiResponse = null;
		try {
			apiResponse = this.databaseDetailService.addUpdateDatabaseDetail(databaseDetail);

		} catch (Exception exception) {
			this.logger.error("", exception);
			exception.printStackTrace();
		}
		return apiResponse;
	}
}
