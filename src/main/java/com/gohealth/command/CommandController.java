package com.gohealth.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Class used to auto-populate command map and delegate functionality
@Component
public class CommandController {
	
	@Autowired
	private Map<String,Command> commandHandlersMap;
	
	public void onCommand( String[] command ) {
		commandHandlersMap.get(command[0]).execute(command);
	}
}
