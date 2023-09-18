package com.payment.Payment;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testAddFunc()
    {
    	Customer c = new Customer(0);
    	c.addFund(10000);
        assertEquals( c.getFund(),10000 );
    }
    
    @Test
    public void testPayment()
    {
    	Bill b1 = new Bill(1,"ELECTRIC",200000,"25/10/2020","NOT_PAID","EVN HCMC");
 	   	Bill b2 = new Bill(2,"WATER",175000,"30/10/2020","NOT_PAID","SAVACO HCMC");
 	   	Bill b3 = new Bill(3,"INTERNET",800000,"30/11/2020","NOT_PAID","VNPT");
    	Customer c = new Customer(0);
    	c.addFund(1000000);
    	c.addBill(b1);
 	   	c.addBill(b2);
 	   	c.addBill(b3);
 	    c.payment(1);
        assertEquals( c.getFund(),800000 );
    }
    @Test
    public void testPayment2()
    {
    	Bill b1 = new Bill(1,"ELECTRIC",200000,"25/10/2020","NOT_PAID","EVN HCMC");
 	   	Bill b2 = new Bill(2,"WATER",175000,"30/10/2020","NOT_PAID","SAVACO HCMC");
 	   	Bill b3 = new Bill(3,"INTERNET",800000,"30/11/2020","NOT_PAID","VNPT");
    	Customer c = new Customer(0);
    	c.addFund(1000000);
    	c.addBill(b1);
 	   	c.addBill(b2);
 	   	c.addBill(b3);
 	    c.payment(10);
        assertEquals( c.getFund(),800000 );
    }
    
    @Test
    public void testSchedule()
    {
    	Bill b1 = new Bill(1,"ELECTRIC",200000,"25/10/2020","NOT_PAID","EVN HCMC");
 	   	Bill b2 = new Bill(2,"WATER",175000,"30/10/2020","NOT_PAID","SAVACO HCMC");
 	   	Bill b3 = new Bill(3,"INTERNET",800000,"30/11/2020","NOT_PAID","VNPT");
    	Customer c = new Customer(0);
    	c.addFund(1000000);
    	c.addBill(b1);
 	   	c.addBill(b2);
 	   	c.addBill(b3);
 	    c.schedule(2,"28/10/2020");
        assertEquals( c.getBills().get(2).getDate(),"28/10/2020" );
    }
}
