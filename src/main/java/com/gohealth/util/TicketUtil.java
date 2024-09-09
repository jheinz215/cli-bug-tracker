package com.gohealth.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.kohsuke.args4j.CmdLineParser;
import org.springframework.stereotype.Component;

import com.gohealth.model.Ticket;
import com.gohealth.model.TicketStatus;

@Component
public class TicketUtil {

	public Ticket createNewTicket( String ticketId, String[] args ) {
		Ticket newTicket = new Ticket();
		newTicket.setId(ticketId);
		newTicket.setStatus(TicketStatus.OPEN);
		newTicket.setCreateDtm(generateDateTime());
		CmdLineParser parser = new CmdLineParser(newTicket);
		try {
			parser.parseArgument(args);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Created ticket: "+ticketId);
		return newTicket;
	}
	
	public String generateId( List<Ticket> ticketList ) {
		return Integer.toString(ticketList.size()+1);
	}
	
	public String generateDateTime() {
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return now.format(formatter);
	}
	
	public Ticket getTicketFromList( String id, List<Ticket> ticketList ) {
		return ticketList.stream().filter(t -> t.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
	
	public boolean isTicketOpen( Ticket t ) {
		return t.getStatus().equals(TicketStatus.OPEN);
	}
	
	public void closeTicket( Ticket t ) {
		if(t != null && isTicketOpen(t)) {
			t.setStatus(TicketStatus.CLOSED);
			System.out.println("Closed ticket: "+t.getId());
		}
	}
}
