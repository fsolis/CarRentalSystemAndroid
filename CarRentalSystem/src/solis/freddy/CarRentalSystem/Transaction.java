/*Title: Transaction
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class will hold all the information that is held by the transactions. The user, date,transaction number, 
 * the current date and the amount due if applicable 
 */
package solis.freddy.CarRentalSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Transaction 
{
	private Customer client;
	private Date date;
	private int transactionNum;
	private int transactionType;
	private static int number = 0;
	private Dates resdate;
	private double amount=0.0;
	
	Transaction()
	{
		this.client = null;
		this.date = new Date();
		this.getTime();
		this.transactionNum = Transaction.number;
		this.transactionType=0;
		increaseNumber();
		this.amount = 0.0;
		this.resdate = null;
	}
	Transaction(Customer client, int type)
	{
		this.client = client;
		this.date = new Date();
		this.getTime();
		increaseNumber();
		this.transactionNum = Transaction.number;
		this.transactionType = type;
		increaseNumber();
		this.amount = 0.0;
		this.resdate = null;
	}
	Transaction(Customer client, int type, Dates date, double ammount)
	{
		this.client = client;
		this.date = new Date();
		this.getTime();
		this.transactionNum = Transaction.number;
		this.transactionType = type;
		increaseNumber();
		this.amount = ammount;
		this.resdate = date;
	}
	
	public double getAmount()
	{
		return this.amount;
	}
	
	public void increaseNumber()
	{
		Transaction.number ++;
	}
	
	public int getTransNumber()
	{
		return this.transactionNum;
	}
	
	public void getTime()
	{
		this.date.getTime();
	}
	public String getDate()
	{
		String date;
		int hour,min;
		
		hour = Calendar.HOUR;
		min = Calendar.MINUTE;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		String sample = formatter.format(this.date);
		date = sample + " At " +hour + ":" + min ;
		
		return date;
	}
	
	public String toString()
	{
		String type ="Unknown";
		if(transactionType == 1)
		{
			type = "Account";
			return this.client.getUserId() + " (" + type + ") "  + this.getDate() + " Transaction Number: " + this.transactionNum;
		}
		if(transactionType == 2)
		{
			type = "Reservation";
			return this.client.getUserId() + " (" + type + ") "  +" Pickup day: " + this.resdate.getpickmonth() + "/" + this.resdate.getpickday() + "/" + this.resdate.getpickyear() +"at " + this.resdate.getpickhour() + ":" + this.resdate.getpickmin() +"0. Dropoff day: " + this.resdate.getretmonth() + "/" + this.resdate.getretday() + "/" + this.resdate.getretyear() + " at " + this.resdate.getrethour() + ":" + this.resdate.getretmin() + "0. Current Date:" +  this.getDate() + " Transaction Number: " + this.transactionNum;
		}
		if(transactionType == 3)
		{
			type = "Reservation Cancelled";
			return this.client.getUserId() + " (" + type + ") "  + this.getDate() + " Transaction Number: " + this.transactionNum;
		}
		return "Error with Transaction.";
	}
	
	public boolean equals(Object obj)
	{
		Transaction another = (Transaction) obj;
		if(this.transactionNum == another.getTransNumber())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}