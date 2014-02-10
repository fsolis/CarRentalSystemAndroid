/*Title: Reservation
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class is meant to hold the information for reservations that are made. The information is
 * the type of car, the user, the date of reservation, the amount of money due, and also the reservation number.
 */
package solis.freddy.CarRentalSystem;


public class Reservation 
{	
	private String car;
	private Customer client;
	private Dates date;
	private static int number = 0;
	private double amount;
	private int num;
	

	Reservation()
	{
		this.car = "Unkown";
		this.client = null;
		this.date = null;
		this.amount = 0.0;
		this.num = Reservation.number;
		Reservation.number ++;
	}


	Reservation(String car, Customer client, Dates date, double amount)
	{
		this.car = car;
		this.client = client;
		this.date = date;
		this.amount = amount;
		this.num = Reservation.number;
		Reservation.number ++;
	}


	public String getCar()
	{

		return this.car;
	}

	public Customer getClient()
	{
		return this.client;
	}
	
	public Dates getDate()
	{
		return this.date;
	}
	
	public double getAmmount()
	{
		return this.amount;
	}
	
	public int getResNumber()
	{
		return this.num;
	}
	
	public String toString()
	{
		return (this.client.getUserId() +  " Pickup day: " + this.date.getpickday() + "/" + this.date.getpickmonth() + "/" + this.date.getpickyear() +" at " + this.date.getpickhour() + ":" + this.date.getpickmin() + "0 Dropoff day: " + this.date.getretday()+ "/" + this.date.getretmonth() + "/" + this.date.getretyear() + " at " + this.date.getrethour() + ":" + this.date.getretmin() + "0. Car Type: " + this.car + ". Reservation Number: "+ this.num + ". Total Amount Due: $" + this.amount +"0");
	}
	
	public boolean equals(Object obj)
	{
		Reservation another = (Reservation) obj;
		if(this.num == another.getResNumber())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}
