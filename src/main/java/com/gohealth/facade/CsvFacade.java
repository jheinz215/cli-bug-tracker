package com.gohealth.facade;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gohealth.model.Ticket;
import com.gohealth.util.CsvReadWriteUtil;
import com.gohealth.util.TicketUtil;

@Component
public class CsvFacade {
	@Autowired
	TicketUtil ticketUtil;
	@Autowired
	CsvReadWriteUtil csvUtil;
	@Value("${csv.spreadsheet.filename}")
    private String fileName;
	private List<Ticket> ticketList;
	
	public CsvFacade() {
		this.ticketList = new ArrayList<Ticket>();
	}
	
	public void createTicket( String[] args ) {
		//Parse CSV file to list of Tickets
		ticketList = csvUtil.readFileToObjectList(fileName);
		//Generate ID
		String newId = ticketUtil.generateId(ticketList);
		//Create new ticket
		Ticket newTicket = ticketUtil.createNewTicket(newId,args);
		//Add to list
		ticketList.add(newTicket);
		//Write list to file
		csvUtil.writeObjectListToFile(ticketList, fileName);
	}
	
	public void closeTicket( String ticketId ) {
		//Parse CSV file to list of Tickets
		ticketList = csvUtil.readFileToObjectList(fileName);
		//Fetch ticket from list by ID
		Ticket ticket = ticketUtil.getTicketFromList(ticketId, ticketList);
		//Close ticket
		ticketUtil.closeTicket(ticket);
		//Write list to file
		csvUtil.writeObjectListToFile(ticketList, fileName);
	}
}
