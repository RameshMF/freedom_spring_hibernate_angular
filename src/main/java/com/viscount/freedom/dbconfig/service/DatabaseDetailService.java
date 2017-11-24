package com.viscount.freedom.dbconfig.service;

import java.util.Set;

import com.viscount.freedom.dbconfig.domain.DatabaseDetail;
import com.viscount.freedom.dbconfig.domain.GlobalData;
import com.viscount.freedom.dto.APIResponse;

public interface DatabaseDetailService {

	
	public APIResponse getAllDatabaseDetail();
	
	public APIResponse getActiveDatabaseDetail();
	
	public APIResponse addUpdateDatabaseDetail(DatabaseDetail databaseDetail);

	public APIResponse getActiveDbGlobalData();
	public APIResponse updateGlobalData(Set<GlobalData> globalDatas);
	
}
