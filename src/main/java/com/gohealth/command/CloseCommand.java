package com.gohealth.command;

import org.springframework.stereotype.Service;

@Service(CommandType.CLOSE_)
public class CloseCommand implements Command{

	private CommandReceiver receiver;
	public CloseCommand(CommandReceiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void execute(String[] command) {
		//System.out.println("CloseCommand.execute()");
		receiver.close(command);
	}
}
