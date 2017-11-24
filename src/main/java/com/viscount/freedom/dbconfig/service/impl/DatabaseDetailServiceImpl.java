package com.viscount.freedom.dbconfig.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viscount.freedom.dbconfig.dao.DatabaseDetailDAO;
import com.viscount.freedom.dbconfig.domain.DatabaseDetail;
import com.viscount.freedom.dbconfig.domain.GlobalData;
import com.viscount.freedom.dbconfig.service.DatabaseDetailService;
import com.viscount.freedom.dbconfig.util.ManageSessionFactory;
import com.viscount.freedom.dto.APIResponse;


/**
 * The Class DatabaseDetailServiceImpl.
 * This is class is created to implement business logic.
 */
@Service("databaseDetailService")
public class DatabaseDetailServiceImpl implements DatabaseDetailService {

	@Value("${database.dbconfig.record.notfound}")
	private String dbRecordNotFound;
	
	@Value("${database.dbconfig.record.add}")
	private String addDBRecord;
	
	@Value("${database.dbconfig.record.update}")
	private String updateDBRecord;
	
	@Value("${database.dbconfig.configuration.wrong}")
	private String dbConfig;
	
	@Resource(name="dbGlobalProperties")
	private Properties dbGlobalProperties;

	/** The logger. */
	private final Logger logger = Logger.getLogger(getClass());

	/** The database detail dao. */
	@Autowired
	private DatabaseDetailDAO databaseDetailDAO;
	
	/**
	 * This method is used to get the all database details.
	 *
	 * @return the all database detail
	 */
	@Override
	@Transactional
	public APIResponse getAllDatabaseDetail() {
		
		APIResponse apiResponse = new APIResponse();
		List<DatabaseDetail> databaseDetails = null;
		try {
			databaseDetails = this.databaseDetailDAO.getAllDatabaseDetail();
			
			if(databaseDetails != null && !databaseDetails.isEmpty()) {
				apiResponse.setStatus(true);
				apiResponse.setObject(databaseDetails);	
			}else{
				apiResponse.setStatus(false);
				apiResponse.setUserMessage(dbRecordNotFound);
			}
			
		} catch (Exception exception) {
			apiResponse.setStatus(false);
			apiResponse.setUserMessage(dbRecordNotFound);
			this.logger.error("", exception); //$NON-NLS-1$
		}
		return apiResponse;
	}

	/**
	 * Gets the active db property.
	 *
	 * @return the active db property
	 */
	@Override
	@Transactional
	public APIResponse getActiveDatabaseDetail() {
		APIResponse apiResponse = new APIResponse();
		try{
			DatabaseDetail databaseDetail = this.databaseDetailDAO.getActiveDatabaseDetail();
			if(databaseDetail != null) {
				apiResponse.setObject(databaseDetail);
				apiResponse.setStatus(true);	
			}else {
				apiResponse.setStatus(false);
				apiResponse.setUserMessage(dbRecordNotFound);
			}
			
		} catch (Exception exception) {
			this.logger.error("", exception); //$NON-NLS-1$
			apiResponse.setStatus(false);
		}
		return apiResponse;
	}
	
	/**
	 * Gets active db global data.
	 *
	 * @param globalDatas the global data.
	 * @return the API response for global data updated.
	 */
	@Override
	@Transactional
	public APIResponse getActiveDbGlobalData() {
		APIResponse apiResponse = new APIResponse();
		try{
			DatabaseDetail databaseDetail = this.databaseDetailDAO.getActiveDatabaseDetail();
			if(databaseDetail != null) {
				
				if(databaseDetail.getGlobalDatas() == null || databaseDetail.getGlobalDatas().isEmpty()){
					
					Set<GlobalData> globalDatas = new HashSet<>();
					Set<Object> keys = dbGlobalProperties.keySet();
					for(Object key : keys) {
						String value = dbGlobalProperties.getProperty((String) key);
						GlobalData globalData = new GlobalData();
						globalData.setId(null);
						globalData.setKeyname((String) key);
						globalData.setValue(value);
						globalData.setDatabaseDetail(databaseDetail);
						globalDatas.add(globalData);
					}
					databaseDetail.setGlobalDatas(globalDatas);
					this.databaseDetailDAO.updateDatabaseDetail(databaseDetail);
				}
				apiResponse.setObject(databaseDetail.getGlobalDatas());
				apiResponse.setStatus(true);
			}else {
				apiResponse.setStatus(false);
				apiResponse.setUserMessage(dbRecordNotFound);
			}
			
		} catch (Exception exception) {
			this.logger.error("", exception); //$NON-NLS-1$
			apiResponse.setStatus(false);
		}
		return apiResponse;
	}
	
	/**
	 * Update active db global data.
	 *
	 * @param globalDatas the global data.
	 * @return the API response for global data updated.
	 */
	@Override
	@Transactional
	public APIResponse updateGlobalData(Set<GlobalData> globalDatas) {
		APIResponse apiResponse = new APIResponse();
		try{
			DatabaseDetail databaseDetail = this.databaseDetailDAO.getActiveDatabaseDetail();
			if(databaseDetail != null) {

				Set<GlobalData> tempGlobalDatas = new HashSet<>();
				for(GlobalData globalData : globalDatas){
					globalData.setDatabaseDetail(databaseDetail);
					tempGlobalDatas.add(globalData);
				}
				databaseDetail.setGlobalDatas(tempGlobalDatas);
				this.databaseDetailDAO.updateDatabaseDetail(databaseDetail);
				apiResponse.setStatus(true);	
				apiResponse.setUserMessage(updateDBRecord);
			}else {
				apiResponse.setStatus(false);
			}
			
		} catch (Exception exception) {
			this.logger.error("", exception); //$NON-NLS-1$
			apiResponse.setStatus(false);
			apiResponse.setUserMessage(dbRecordNotFound);
		}
		return apiResponse;
	}

	/**
	 * Add or update the database details by filter.
	 *
	 * @param databaseDetailParam the database detail
	 * @return the API response
	 */
	@Override
	@Transactional
	public APIResponse addUpdateDatabaseDetail(DatabaseDetail databaseDetailParam) {

		APIResponse apiResponse = new APIResponse();
		try{
			
			// Configure session
			
			if(ManageSessionFactory.isConfigurableSessionFactory(databaseDetailParam)) {

				DatabaseDetail databaseDetail = this.databaseDetailDAO.isDatabaseDetailExist(databaseDetailParam);
				databaseDetailParam.setIsActive((byte) 1);
				
				if(databaseDetail == null) {
					Set<GlobalData> globalDatas = this.databaseDetailDAO.getActiveDBGlobalData();
					Set<GlobalData> newGlobalDatas = new HashSet<>();
					// set databaseDetail id as null for new insertion
					databaseDetailParam.setId(null);
					
					if(globalDatas != null) {
						
						for(GlobalData globalData : globalDatas) {
							globalData.setId(null);
							globalData.setDatabaseDetail(databaseDetailParam);
							newGlobalDatas.add(globalData);
						}
					} else {
						Set<Object> keys = dbGlobalProperties.keySet();
						for(Object key : keys) {
							String value = dbGlobalProperties.getProperty((String) key);
							GlobalData globalData = new GlobalData();
							globalData.setId(null);
							globalData.setKeyname((String) key);
							globalData.setValue(value);
							globalData.setDatabaseDetail(databaseDetailParam);
							newGlobalDatas.add(globalData);
						}
					}
					databaseDetailParam.setGlobalDatas(newGlobalDatas);
					this.databaseDetailDAO.deactivateCurrentActiveDBDetails();
					this.databaseDetailDAO.addDatabaseDetail(databaseDetailParam);
					
					ManageSessionFactory.configureSessionFactory(databaseDetailParam);
					apiResponse.setUserMessage(addDBRecord);
					
				} else {
					
						databaseDetailParam.setId(databaseDetail.getId());
						databaseDetailParam.setGlobalDatas(databaseDetail.getGlobalDatas());
						this.databaseDetailDAO.deactivateCurrentActiveDBDetails();
						this.databaseDetailDAO.updateDatabaseDetail(databaseDetailParam);
						ManageSessionFactory.configureSessionFactory(databaseDetailParam);
						apiResponse.setUserMessage(updateDBRecord);
				}
				apiResponse.setStatus(true);
			} else {
				apiResponse.setStatus(false);
				apiResponse.setUserMessage(dbConfig); //$NON-NLS-1$
			}
		} catch (Exception exception) {
			this.logger.error("", exception); //$NON-NLS-1$
		}
		return apiResponse;
	}

}
