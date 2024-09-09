package com.gohealth.command;

import org.springframework.stereotype.Service;

@Service(CommandType.CREATE_)
public class CreateCommand implements Command {

	private CommandReceiver receiver;
	public CreateCommand(CommandReceiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void execute(String[] command) {
		//System.out.println("CreateCommand.execute()");
		receiver.create(command);
	}
}
