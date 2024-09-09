package com.gohealth.command;

public enum CommandType {
	
	CREATE(CommandType.CREATE_),
	CLOSE(CommandType.CLOSE_);
	
	public static final String CREATE_ = "create";
	public static final String CLOSE_ = "close";
	
	private String commandName;
	
	CommandType(String commandName){
		this.commandName = commandName;
	}
	
	public String getCommandName() {
		return this.commandName;
	}
}
