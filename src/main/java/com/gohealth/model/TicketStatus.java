package com.gohealth.model;

public enum TicketStatus {
	
	OPEN(TicketStatus.OPEN_),
	CLOSED(TicketStatus.CLOSED_);
	
	public static final String OPEN_ = "open";
	public static final String CLOSED_ = "closed";
	
	private String status;
	
	TicketStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
