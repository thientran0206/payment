package com.payment.Payment;

import java.util.Date;

public class Bill {

	private int no;
	private String type;
	private int amount;
	private String date;
	private String state;
	private String provider;
	
	public Bill(int no, String type,int amount, String date, String state, String provider) {
		this.no = no;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.state = state;
		this.provider = provider;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	@Override
	public String toString() {
		return this.getNo() + ". " + this.getType()+ " "+this.getAmount()+ " "+this.getDate()+ " " +this.getState()+ " "+this.getProvider();
	}
}
