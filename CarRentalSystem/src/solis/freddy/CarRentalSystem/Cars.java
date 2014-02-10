/*Title:Cars
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This is the class for the cars, it contains the name of the car as well as 
 * a ArrayList of dates that the car is reserved for.
 * 
 */
package solis.freddy.CarRentalSystem;

import java.util.ArrayList;

public class Cars 
{
	private String type;
	private ArrayList <Dates> dates;
	
	
	Cars(String name)
	{
		this.type = name;
		dates = new ArrayList <Dates> (5);
	}
	
	public void addDate(Dates nDate)
	{
		dates.add(nDate);
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public boolean checkDate(Dates nDate)
	{
		int size = this.dates.size();
		Dates temp;
		boolean checker = true;
		int i=0;
		while(i<size)
		{
			temp = dates.get(i);
			checker = temp.isValid(nDate);
			if(checker == false)
			{
				System.out.print("here");
				return checker;
			}
			i++;
		}
		
		return checker;
	}
	
	public void removeDate(Dates nDate)
	{
		this.dates.remove(nDate);
	}
	
	
	
}
