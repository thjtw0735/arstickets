package com.tonmedia.tickets.domain;

public class Ticket {
	private int ticket_num;
	private int match_num;
	private String ticket_level;
	private int ticket_price;
	private String ticket_seatnum;
	private String ticket_index;
	public int getTicket_num() {
		return ticket_num;
	}
	public String getTicket_index() {
		return ticket_index;
	}
	public void setTicket_index(String ticket_index) {
		this.ticket_index = ticket_index;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}
	public int getMatch_num() {
		return match_num;
	}
	public void setMatch_num(int match_num) {
		this.match_num = match_num;
	}
	public String getTicket_level() {
		return ticket_level;
	}
	public void setTicket_level(String ticket_level) {
		this.ticket_level = ticket_level;
	}
	public int getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}
	public String getTicket_seatnum() {
		return ticket_seatnum;
	}
	public void setTicket_seatnum(String ticket_seatnum) {
		this.ticket_seatnum = ticket_seatnum;
	}
	
	
	

}
