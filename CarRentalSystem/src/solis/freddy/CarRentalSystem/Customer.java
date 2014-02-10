/*Title:Customer
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class is meant for the Customers for this system. it will hold the username and password
 */

package solis.freddy.CarRentalSystem;

public class Customer 
{
	private String password;
	private String userId;
	
	Customer()
	{
		password = null;
		userId=null;
	}
	
	Customer(String user, String pass)
	{
		this.userId = user;
		this.password = pass;
	}
	
	public String getUserId()
	{
		return this.userId;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setUser(String user)
	{
		this.userId = user;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public boolean equals(Object obj)
	{
		Customer another = (Customer) obj;
		if(this.userId.equals(another.getUserId()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
