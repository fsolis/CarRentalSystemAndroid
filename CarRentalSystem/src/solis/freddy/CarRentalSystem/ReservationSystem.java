/*Title: ReservationSystem
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This is the main class that the program runs off of. In android these are all static so that they can be updated
 * and changed by all activities. This class will manage all the cars, reservations, clients, transactions that are
 * involved with this program 
 */
package solis.freddy.CarRentalSystem;


import java.util.ArrayList;

public class ReservationSystem 
{
		private static ArrayList <Customer> customers = new ArrayList <Customer> (5);
		private static ArrayList <Transaction> transactions = new ArrayList <Transaction> (5);
		private static ArrayList <Reservation> reservations = new ArrayList <Reservation> (5);
		private static Cars minivan = new Cars("Minivan");
		private static Cars truck = new Cars("Truck");
		private static Cars sedan = new Cars("Sedan");
		private static Dates tempDate = new Dates();
		private static String tempCar = "Unkown";
		private static int curclientIndex = 0;
		
		
		
		public void setIndex(int index)
		{
			ReservationSystem.curclientIndex = index;
		}
		
		public int getIndex()
		{
			return ReservationSystem.curclientIndex;
		}
		
		public ArrayList<Reservation> getReservations()
		{
			return ReservationSystem.reservations;
		}
		
		public void setReservation (Reservation nRes)
		{
			ReservationSystem.reservations.add(nRes);
		}
		
		public void removeReservation(Reservation remove)
		{
			ReservationSystem.reservations.remove(remove);
		}
		
		public void removeAccount(Customer rAcc)
		{
			ReservationSystem.customers.remove(rAcc);
		}
		
		public ArrayList<Transaction> getTransactions()
		{
			return ReservationSystem.transactions;
		}
		
		public ArrayList<Customer> getCustomers()
		{
			return ReservationSystem.customers;
		}
		
		public void addTrans(Transaction nTrans)
		{
			ReservationSystem.transactions.add(nTrans);
		}
		
		public void addCustomer(Customer nCust)
		{
			ReservationSystem.customers.add(nCust);
		}
		

		public void setTempDate(Dates newTempDate)
		{
			ReservationSystem.tempDate = newTempDate;
		}
		
		public Dates getTempDate()
		{
			return ReservationSystem.tempDate;
		}
		
		public Cars getVan()
		{
			return ReservationSystem.minivan;
		}
		
		public void setVan(Cars van)
		{
			 ReservationSystem.minivan = van;
		}
		
		public Cars getTruck()
		{
			return ReservationSystem.truck;
		}
		
		public void setTruck(Cars truck)
		{
			 ReservationSystem.truck = truck;
		}
		
		public Cars getSedan()
		{
			return ReservationSystem.sedan;
		}
		
		public void setSedan(Cars sedan)
		{
			 ReservationSystem.sedan = sedan;
		}
	
		public String getTempCar()
		{
			return ReservationSystem.tempCar;
		}
		
		public void setTempCar(String car)
		{
			ReservationSystem.tempCar = car;
		}
		
		
}
		