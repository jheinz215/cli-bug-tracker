package com.gohealth.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gohealth.facade.CsvFacade;

@Component
public class CommandReceiver {
	
	@Autowired
	CsvFacade csvFacade;
	
	public void create(String[] command) {
		csvFacade.createTicket(command);
	}
	public void close(String[] command) {
		csvFacade.closeTicket(command[1]);
	}
}
