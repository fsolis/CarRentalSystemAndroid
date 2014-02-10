/*Title: SelectDate
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This is the class for the activity select dates where the user inputs what time and date the user 
 * wants to reserve the car for this class will call the select car activity. 
 */
package solis.freddy.CarRentalSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class SelectDate extends Activity implements OnClickListener
{
	private ReservationSystem creatRes;
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.selectdate);
        creatRes = new ReservationSystem();
        
        TimePicker pickTime = (TimePicker)findViewById(R.id.picktime);
        pickTime.setIs24HourView(true);
		TimePicker dropTime = (TimePicker)findViewById(R.id.droptime);
        dropTime.setIs24HourView(true);
        
        pickTime.setCurrentMinute(00);
        pickTime.setCurrentHour(00);
        dropTime.setCurrentMinute(00);
        dropTime.setCurrentHour(00);

        DatePicker pickInput = (DatePicker)findViewById(R.id.pickup);
		DatePicker dropInput = (DatePicker)findViewById(R.id.dropoff);
		
		pickInput.updateDate(2012, 05, 01);
		dropInput.updateDate(2012, 05, 01);
        View okButton = findViewById(R.id.okButton);
		okButton.setOnClickListener(this);	
		
        View homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);
      
    }


	public void onClick(View v) 
	{
		boolean checker;
		int pickDay,pickMonth,pickYear,pickHour,pickMin,dropDay,dropMonth,dropYear,dropHour,dropMin;
		DatePicker pickInput = (DatePicker)findViewById(R.id.pickup);
		DatePicker dropInput = (DatePicker)findViewById(R.id.dropoff);
		TimePicker pickTime = (TimePicker)findViewById(R.id.picktime);
		TimePicker dropTime = (TimePicker)findViewById(R.id.droptime);
		
		if(v.getId() == R.id.okButton)
		{
			pickDay = pickInput.getDayOfMonth();
			pickMonth = pickInput.getMonth() + 1;
			pickYear = pickInput.getYear();
			pickHour = pickTime.getCurrentHour();
			pickMin = pickTime.getCurrentMinute();
			dropDay = dropInput.getDayOfMonth();
			dropMonth = dropInput.getMonth() + 1;
			dropYear = dropInput.getYear();
			dropHour = dropTime.getCurrentHour();
			dropMin = dropTime.getCurrentMinute();
			checker = checkDates(pickDay,pickMonth,pickYear,pickHour,pickMin,dropDay,dropMonth,dropYear,dropHour,dropMin);
			if(checker == true)
			{
				Dates temp = new Dates(pickDay,pickMonth,pickYear,pickHour,pickMin,dropDay,dropMonth,dropYear,dropHour,dropMin);
				creatRes.setTempDate(temp);
				Intent i = new Intent(this,SelectCar.class);
				startActivity(i);
			}
			
		}
		if(v.getId() == R.id.homeButton)
		{
			Intent i = new Intent(this,CarRentalSystemActivity.class);
			startActivity(i);
		}

	}
	
	public boolean checkDates(int pd,int pm, int py,int ph, int pMin, int dd, int dm, int dy, int dh,int dMin)
	{
		if(pm != 6)
		{
			Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		if(dm != 6)
		{
			Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		if(py != 2012)
		{
			Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		if(dy != 2012)
		{
			Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		if(dy < py)
		{
			Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		if(py == dy)
		{
			if(pm > dm)
			{
				Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
				toast.show();
				return false;
			}
			else
			{
				if(pm == dm)
				{
					if(pd == dd)
					{
						if(ph > dh)
						{
								Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
								toast.show();
								return false;
						}
					}
					if(pd > dd)
					{
						Toast toast = Toast.makeText(this, "Invalid Dates", Toast.LENGTH_SHORT);
						toast.show();
						return false;
					}
				}
			}
		}
	
		
		return true;
	}

}
