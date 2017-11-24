package com.mjwcorp.geddswebviewer.application.getarm;

public class TestExceptions  {

	public static void main(String[] args) {
		try{
			TestExceptions.myTest(null);
        } catch(DBException mae){
            System.out.println("Inside catch block: "+mae.getMessage());
        }
    }
     
    static void myTest(String str) throws DBException{
        if(str == null){
            throw new DBException("String val is null");
        }
    }
}
