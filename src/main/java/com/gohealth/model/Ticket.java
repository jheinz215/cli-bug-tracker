package com.gohealth.model;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import com.opencsv.bean.CsvBindByPosition;

public class Ticket {

	@CsvBindByPosition(position = 0)
	private String id;
	@Option(name="-desc", usage="Ticket description")
	@CsvBindByPosition(position = 1)
	private String description;
	@Option(name="-parent", usage="Parent ID related to ticket")
	@CsvBindByPosition(position = 2)
	private String parent;
	@CsvBindByPosition(position = 3)
	private TicketStatus status;
	@CsvBindByPosition(position = 4)
	private String createDtm;
	@Option(name="-link", usage="URL to log")
	@CsvBindByPosition(position = 5)
	private String link;
	
	@Argument
	private String argument;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public TicketStatus getStatus() {
		return status;
	}
	public void setStatus(TicketStatus status) {
		this.status = status;
	}
	public String getCreateDtm() {
		return createDtm;
	}
	public void setCreateDtm(String createDtm) {
		this.createDtm = createDtm;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
