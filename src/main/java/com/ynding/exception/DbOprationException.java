package com.ynding.exception;

public class DbOprationException extends Exception{
	private static final long serialVersionUID = 1L;

	public DbOprationException(){
		super("操作数据发生异常");
	}
	
	public DbOprationException(String msg){
		super(msg);
	}
}
