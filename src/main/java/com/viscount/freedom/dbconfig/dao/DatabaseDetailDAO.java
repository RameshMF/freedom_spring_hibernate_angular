package com.viscount.freedom.dbconfig.dao;

import java.util.List;
import java.util.Set;

import com.viscount.freedom.dbconfig.domain.DatabaseDetail;
import com.viscount.freedom.dbconfig.domain.GlobalData;

public interface DatabaseDetailDAO {

	public List<DatabaseDetail> getAllDatabaseDetail() throws Exception;
	
	public DatabaseDetail getActiveDatabaseDetail() throws Exception;
	
	public void addDatabaseDetail(final DatabaseDetail databaseDetail) throws Exception;
	
	public void updateDatabaseDetail(final DatabaseDetail databaseDetail) throws Exception;
	
	public DatabaseDetail isDatabaseDetailExist(final DatabaseDetail databaseDetail) throws Exception;

	public void deactivateCurrentActiveDBDetails() throws Exception;
	
	// GlobalData
	public Set<GlobalData> getActiveDBGlobalData() throws Exception;
	
}
