package com.payment.Payment;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
	private int fund;
	private ArrayList<Bill> bills;
	
	public Customer(int fund) {
		this.fund = fund;
		this.bills = new ArrayList<Bill>();
	}
	public int getFund() {
		return fund;
	}
	public void setFund(int fund) {
		this.fund = fund;
	}
	public void addFund(int num) {
		this.fund += num;
		System.out.println("Your current balance is: "+ this.fund);
	}
	
	public ArrayList<Bill> getBills() {
		return bills;
	}
	public void setBills(ArrayList<Bill> bills) {
		this.bills = bills;
	}
	public void addBill(Bill bill) {
		this.bills.add(bill);
	}
	public void showBill() {
		this.bills.stream().forEach(s -> {
			System.out.print(s.getNo() + ". " + s.getType()+ " "+s.getAmount()+ " "+s.getDate()+ " " +s.getState()+ " "+s.getProvider() + "\n");
		});
	}
	public void showDueDate() {
		this.bills.stream().filter(b -> "NOT_PAID".equals(b.getState())).forEach(s -> System.out.println(s.toString()));
	}
	public void showListPayment() {
		this.bills.stream().forEach(s -> {
			System.out.print(s.getAmount() + " " + s.getDate()+ " ");
			if("NOT_PAID".equals(s.getState())) System.out.println("PENDING" + " " + s.getNo());
			else System.out.println("PROCESSED"+ " " + s.getNo());
		});
	}
	public void payment(int id) {
		boolean found = false;
		int index = 0;
		for(int i=0;i< this.bills.size();i++) {
			if(this.bills.get(i).getNo()== id) {
				found = true;
				index=i;
			}
		}
		if(found == false) {
			System.out.println("Sorry! Not found a bill with such id");
			return;
		}
		if(this.fund > bills.get(index).getAmount()) {
			bills.get(index).setState("PAID");
			this.fund -= bills.get(index).getAmount(); 
		}
		System.out.println("Your current balance is:"+this.fund);
	}
	public void payment(int id1,int id2) {
		boolean found = false;
		int index1 = 0;
		int index2 = 0;
		for(int i=0;i< this.bills.size();i++) {
			if(this.bills.get(i).getNo()== id1) {
				found = true;
				index1=i;
			}
			if(this.bills.get(i).getNo()== id2) {
				found = true;
				index2=i;
			}
		}
		if(found == false) {
			System.out.println("Sorry! Not found a bill with such id");
			return;
		}
		int sum = bills.get(index1).getAmount() +  bills.get(index2).getAmount();
		if(this.fund > sum) {
			bills.get(id1).setState("PAID");
			bills.get(id2).setState("PAID");
			this.fund -= bills.get(id1).getAmount(); 
			this.fund -= bills.get(id2).getAmount(); 
		}
		else {
			System.out.println("Sorry! Not enough fund to proceed with payment.");
			return;
		}
		System.out.println(this.fund);
	}
	public void showBillByProvider(String provider) {
		this.bills.stream().filter(b -> provider.equals(b.getProvider())).forEach(s -> System.out.println(s.toString()));
	}
	public void schedule(int id, String date) {
		boolean found = false;
		for(Bill b : bills) {
			if(b.getNo()== id)	found = true;
		}
		if(found == false) {
			System.out.println("Sorry! Not found a bill with such id");
			return;
		}
		this.bills.get(id).setDate(date);
		System.out.println("Payment for bill id "+id+" is scheduled on "+date );
	}
}
