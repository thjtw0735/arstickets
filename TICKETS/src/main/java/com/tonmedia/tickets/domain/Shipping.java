package com.tonmedia.tickets.domain;

public class Shipping {
	private int shipping_num;
	private int match_num;
	private String shipping_ticket;
	private int shipping_count;
	private String shipping_date;
	public String getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(String shipping_date) {
		this.shipping_date = shipping_date;
	}
	private String shipping_name;
	private String shipping_address;
	private String shipping_phone;
	private String shipping_status;
	private String email;
	public int getShipping_num() {
		return shipping_num;
	}
	public void setShipping_num(int shipping_num) {
		this.shipping_num = shipping_num;
	}
	public int getMatch_num() {
		return match_num;
	}
	public void setMatch_num(int match_num) {
		this.match_num = match_num;
	}
	public String getShipping_ticket() {
		return shipping_ticket;
	}
	public void setShipping_ticket(String shipping_ticket) {
		this.shipping_ticket = shipping_ticket;
	}
	public int getShipping_count() {
		return shipping_count;
	}
	public void setShipping_count(int shipping_count) {
		this.shipping_count = shipping_count;
	}
	public String getShipping_name() {
		return shipping_name;
	}
	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public String getShipping_phone() {
		return shipping_phone;
	}
	public void setShipping_phone(String shipping_phone) {
		this.shipping_phone = shipping_phone;
	}
	public String getShipping_status() {
		return shipping_status;
	}
	public void setShipping_status(String shipping_status) {
		this.shipping_status = shipping_status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
