package com.viscount.freedom.user.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public enum Module
{
	USERS("USERS"),
	SUITES("SUITES"),  
	ACCESS("ACCESS"),	   
	CONTROLLED_AREAS("CONTROLLED_AREAS"),		   
	SCHEDULES("SCHEDULES"),	   
	LOG("LOG"),
	ADMIN_USERS("ADMIN_USERS"),
	COMM_PORTS("COMM_PORTS"),
	DEVICES("DEVICES"),
	PANELS("PANELS"),   
	BACKUP("BACKUP"),
	RESTORE_DATA("RESTORE_DATA"),	
	AUDIT("AUDIT"),
	RISK_LEVEL("RISK_LEVEL"),	  
	UTILITIES("UTILITIES"),	
	PIV("PIV"),
	NVR_SERVERS("NVR_SERVERS"),
	MUSTERING("MUSTERING");	   

	private final String moduleValue; 
	private final static HashSet<String> moduleValues = new HashSet<String>();
	private final static Map<String, Module> moduleLookup = new HashMap<String, Module>();
	
	static {
		for(Module module : Module.values()) {
			moduleValues.add(module.getModuleValue());
			moduleLookup.put(module.getModuleValue(), module);
		}
	}
	
	private Module(final String moduleValue){
		this.moduleValue = moduleValue;
	}
	
	public String getModuleValue(){
		return this.moduleValue;
	}
           
	public static HashSet<String> getAllModules(){
		return moduleValues;
	}

}
