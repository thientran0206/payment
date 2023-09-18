package com.payment.Payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void method1(Customer c, String s1) {
		switch(s1.toUpperCase()) {
			case "LIST_BILL":
				c.showBill();
				break;
			case "DUE_DATE":
				c.showDueDate();
				break;
			case "LIST_PAYMENT":
				c.showListPayment();
				break;
		}
		return;
	}
	
	public static void method2(Customer c,String s1,String s2) {
		switch(s1.toUpperCase()) {
			case "CASH_IN":
				c.addFund(Integer.parseInt(s2));
				break;
			case "PAY":
				c.payment(Integer.parseInt(s2));
				break;
			case "SEARCH_BILL_BY_PROVIDER":
				c.showBillByProvider(s2);
				break;
		}	
		return;
	}
	
	public static void method3(Customer c,String s1,String s2,String s3) {
		switch(s1.toUpperCase()) {
			case "PAY":
				c.payment(Integer.parseInt(s2),Integer.parseInt(s3));
				break;
			case "SCHEDULE":
				c.schedule(Integer.parseInt(s2),s3);
				break;
			
		}
		return;
	}
	
	public static void main(String args[]) throws IOException
    {
		
	   Bill b1 = new Bill(1,"ELECTRIC",200000,"25/10/2020","NOT_PAID","EVN HCMC");
	   Bill b2 = new Bill(2,"WATER",175000,"30/10/2020","NOT_PAID","SAVACO HCMC");
	   Bill b3 = new Bill(3,"INTERNET",800000,"30/11/2020","NOT_PAID","VNPT");
	   Customer c = new Customer(0);
	   c.addBill(b1);
	   c.addBill(b2);
	   c.addBill(b3);
	   BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	   while (true) {
	       String s = in.readLine();
	       if (s.length() == 0 || "EXIT".equals(s.toUpperCase())) {
	            System.out.println("Good bye!");
	            return;
	       }
	       String [] array = s.split(" ");
	       if(array.length == 1)	method1(c,array[0]);
	       else if(array.length == 2)	method2(c,array[0],array[1]);
	       		else if(array.length == 3) method3(c,array[0],array[1],array[2]);
	   }
    }
}
