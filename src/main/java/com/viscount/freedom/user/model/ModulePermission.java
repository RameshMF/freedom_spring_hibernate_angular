package com.viscount.freedom.user.model;

public class ModulePermission
{
	private String module;
	private int permission;
	
	public ModulePermission(){
		
	}
	public String getModule()
	{
		return module;
	}
	public void setModule(String module)
	{
		this.module = module;
	}
	public int getPermission()
	{
		return permission;
	}
	public void setPermission(int permission)
	{
		this.permission = permission;
	}
	
}
