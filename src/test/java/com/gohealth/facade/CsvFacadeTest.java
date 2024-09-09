package com.gohealth.facade;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gohealth.model.Ticket;
import com.gohealth.model.TicketStatus;
import com.gohealth.util.TicketUtil;

class CsvFacadeTest {

	String[] createCommand = {"create","-desc","Test description","-link","yahoo.com","-parent","3"};
	String[] closeCommand = {"close","1"};
	
	@Test
	void testCreateTicket() {
		TicketUtil ticketUtil = new TicketUtil();
		List<Ticket> ticketList = new ArrayList<Ticket>();
		String newId = ticketUtil.generateId(ticketList);
		Ticket newTicket = ticketUtil.createNewTicket(newId,createCommand);
		assertEquals("1",newTicket.getId());
		assertEquals(createCommand[2],newTicket.getDescription());
	}
	
	@Test
	void testCloseTicket() {
		TicketUtil ticketUtil = new TicketUtil();
		List<Ticket> ticketList = new ArrayList<Ticket>();
		String newId = ticketUtil.generateId(ticketList);
		Ticket newTicket = ticketUtil.createNewTicket(newId,createCommand);
		ticketList.add(newTicket);
		
		newTicket = ticketUtil.getTicketFromList(newId, ticketList);
		ticketUtil.closeTicket(newTicket);
		assertEquals(TicketStatus.CLOSED,newTicket.getStatus());
	}

}
