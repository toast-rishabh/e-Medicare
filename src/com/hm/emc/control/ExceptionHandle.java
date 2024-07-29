package com.hm.emc.control;

public class ExceptionHandle {
	public class SQLException extends Exception{
	    public SQLException(String statement){
	        super(statement);
	    }
	}
}
