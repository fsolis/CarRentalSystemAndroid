/*Title:Dates
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class holds the dates that are input by the user. It will hold values for day,month,year,and hours
 * for both the return days and the pickup days. 
 */
package solis.freddy.CarRentalSystem;

public class Dates 
{
	private int retday;
	private int retmonth;
	private int retyear;
	private int rethour;
	private int retmin;
	private int pickday;
	private int pickmonth;
	private int pickyear;
	private int pickhour;
	private int pickmin;
	
	Dates()
	{
		this.retday = 0;
		this.retmonth = 0;
		this.retyear = 0;
		this.rethour = 0;
		this.retmin = 0;
		this.pickday = 0;
		this.pickmonth = 0;
		this.pickyear = 0;
		this.pickhour = 0;
		this.pickmin = 0;
		
	}
	
	Dates(int pickday, int pickmonth, int pickyear,int pickhour, int pickmin, int retday, int retmonth,int retyear, int rethour, int retmin)
	{
		this.retday = retday;
		this.retmonth = retmonth;
		this.retyear = retyear;
		this.pickhour = pickhour;
		this.pickmin = pickmin;
		this.pickday = pickday;
		this.pickmonth = pickmonth;
		this.pickyear = pickyear;
		this.rethour = rethour;
		this.retmin = retmin;
	}
	
	public int getretday()
	{
		return this.retday;
	}
	
	public int getretmonth()
	{
		return this.retmonth;
	}
	
	public int getretyear()
	{
		return this.retyear;
	}
	
	public int getpickday()
	{
		return this.pickday;
	}
	
	public int getpickmonth()
	{
		return this.pickmonth;
	}
	
	public int getpickyear()
	{
		return this.pickyear;
	}
	
	public int getpickhour()
	{
		return this.pickhour;
	}
	
	public int getpickmin()
	{
		return this.pickmin;
	}
	
	public int getrethour()
	{
		return this.rethour;
	}
	
	public int getretmin()
	{
		return this.retmin;
	}
	public boolean isValid(Dates nDate)
	{
		// This commented code is for when a user can choose different months
		/*
		if(this.retyear == nDate.getpickyear())
		{
			if(this.retmonth == nDate.getpickmonth())
			{
				if(this.retday == nDate.getpickday())
				{
					if(this.rethour < nDate.getpickhour())
					{
						return true;
					}
					if(this.rethour == nDate.getpickhour())
					{
						if(this.retmin < nDate.getpickmin())
						{
							return true;
						}
					}

				}
			}
		}
		if(this.retyear >= nDate.getpickyear())
		{
			if(this.retmonth <= nDate.getpickmonth())
			{
				if(this.retday < nDate.getpickday())
				{
					return true;
				}
			}
		}
		
		if(this.pickyear >= nDate.getretyear())
		{
			if(this.pickmonth >= nDate.getpickday())
			{
				if(this.pickday > nDate.getpickday())
				{
					return true;
				}
			}
		}
		*/
		
		if(this.pickday > nDate.getretday())
		{
			return true;
		}
		if(this.pickday == nDate.getretday())
		{
			if(this.pickhour > nDate.getrethour())
			{
				return true;
			}
			if(this.rethour < nDate.getpickhour())
			{
				return true;
			}
		}
		if(nDate.getpickday() == this.retday)
		{
			if(nDate.getpickhour() > this.rethour)
			{
				return true;
			}
		}
		
		if(this.retday < nDate.getpickday())
		{
			return true;
		}
				
		return false;
	}
	
	public boolean equals(Object obj)
	{
		Dates another = (Dates) obj;
		if(another.getpickday() == this.pickday)
		{
			if(another.getpickmonth() == this.pickmonth)
			{
				if(another.getpickyear() == this.pickyear)
				{
					if(another.getpickhour() == this.pickhour)
					{
						if(another.getpickmin()== this.pickmin)
						{
							if(another.getretyear() == this.retyear)
							{
								if(another.getretmonth() == this.retmonth)
								{
									if(another.getretday() == this.retday)
									{
										if(another.getrethour() == this.rethour)
										{
											if(another.getretmin() == this.retmin)
											{
												return true;
											}
										}
									}
								}
							}
						}
					}
					
				}
			}
		}
		return false;
	}
}
