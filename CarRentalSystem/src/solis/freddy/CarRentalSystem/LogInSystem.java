/*Title:LogInSystem
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This activity is meant for logging in when the user wants to create a reservation
 * this class will check and make sure that the username and passwords are valid then it will confirm their
 * transaction. 
 */
package solis.freddy.CarRentalSystem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInSystem extends Activity implements OnClickListener
{
	private ReservationSystem creatRes;
	private int useatt = 0;
	private int passatt = 0;
	private int index = 0;
	private boolean checker = false;
	   @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.loginsystem);
	        
	        creatRes = new ReservationSystem();
	        
	        View okButton = findViewById(R.id.okButton);
			okButton.setOnClickListener(this);	

	        View homeButton = findViewById(R.id.homeButton);
	        homeButton.setOnClickListener(this);
	 
	    }


	public void onClick(View v) 
	{
		ArrayList <Customer> customers = creatRes.getCustomers();
		Cars truck = creatRes.getTruck();
		Cars van = creatRes.getVan();
		Cars sedan = creatRes.getSedan();
		String name;
		String carType;
		EditText input;
		Customer temp;
		Dates tempDate = creatRes.getTempDate();
		double total;
		int pickDay = tempDate.getpickday();
		int dropDay = tempDate.getretday();

		input = (EditText)findViewById(R.id.getusername);
		name = input.getText().toString();
		
		
		if(v.getId() == R.id.okButton)
		{
			input = (EditText)findViewById(R.id.getusername);
			name = input.getText().toString();
			if(checkUserName(name) == false)
			{
				useatt ++;
				
				if(useatt == 2)
				{
					Intent i = new Intent(this, CarRentalSystemActivity.class);
					startActivity(i);
				}
			}
			else
			{
				input = (EditText)findViewById(R.id.getpassword);
				name = input.getText().toString();
				
				if(checkPassword(name) == false)
				{
					passatt++;
					
					if(passatt==2)
					{
						Intent i = new Intent(this, CarRentalSystemActivity.class);
						startActivity(i);
					}
				}
				else
				{
					temp = customers.get(index);
					carType = creatRes.getTempCar();
					if(carType.equals("Minivan") == true)
					{
						total = ((dropDay - pickDay) + 1) * 25;
						Reservation tempres = new Reservation("Minivan",temp,tempDate,total);
						if(checker == true)
						{
							
							creatRes.setReservation(tempres);
							van.addDate(tempDate);
							creatRes.setVan(van);
							Transaction temptrans = new Transaction(temp, 2,tempDate,total);
							creatRes.addTrans(temptrans);
							Dates temperDate = new Dates();
							creatRes.setTempDate(temperDate);
							Toast toast = Toast.makeText(this, "Reservation Made." + '\n' + temptrans.toString(), Toast.LENGTH_LONG);
							toast.show();
							
							Intent i = new Intent(this, CarRentalSystemActivity.class);
							startActivity(i);
							
						}
						if(checker == false)
						{
							useatt=0;
							passatt=0;
							checker = true;
							
							TextView view = (TextView)findViewById(R.id.confirmation);
							view.setText(tempres.toString() + '\n' + "If this is correct click Ok, If not click Main Menu.");
						}
						
					}
					if(carType.equals("Truck") == true)
					{
						total = ((dropDay - pickDay) + 1) * 25;
						Reservation tempres = new Reservation("Truck",temp,tempDate,total);
						if(checker== true)
						{
							
							creatRes.setReservation(tempres);
							truck.addDate(tempDate);
							creatRes.setTruck(truck);
							Transaction temptrans = new Transaction(temp, 2,tempDate,total);
							creatRes.addTrans(temptrans);
							Dates temperDate = new Dates();
							creatRes.setTempDate(temperDate);
							Toast toast = Toast.makeText(this, "Reservation Made." + '\n' + temptrans.toString(), Toast.LENGTH_LONG);
							toast.show();
							
							Intent i = new Intent(this, CarRentalSystemActivity.class);
							startActivity(i);
							
						}
						if(checker == false)
						{
							useatt=0;
							passatt=0;
							checker = true;
							
							TextView view = (TextView)findViewById(R.id.confirmation);
							view.setText(tempres.toString() + '\n' + "If this is correct click Ok, If not click Main Menu.");
						}
						
					}
					if(carType.equals("Sedan") == true)
					{
						total = ((dropDay - pickDay) + 1) * 25;
						Reservation tempres = new Reservation("Sedan",temp,tempDate,total);
						
						if(checker == true)
						{
							
							creatRes.setReservation(tempres);
							sedan.addDate(tempDate);
							creatRes.setSedan(sedan);
							Transaction temptrans = new Transaction(temp, 2,tempDate,total);
							creatRes.addTrans(temptrans);
							Dates temperDate = new Dates();
							creatRes.setTempDate(temperDate);
							Toast toast = Toast.makeText(this, "Reservation Made." + '\n' + temptrans.toString(), Toast.LENGTH_LONG);
							toast.show();
							
							Intent i = new Intent(this, CarRentalSystemActivity.class);
							startActivity(i);
						}
						if(checker == false)
						{
							useatt=0;
							passatt=0;
							checker = true;
							
							TextView view = (TextView)findViewById(R.id.confirmation);
							view.setText(tempres.toString() + '\n' + "If this is correct click Ok, If not click Main Menu.");
						}
						
					}
					
				}
				
			}
		}

		if(v.getId() == R.id.homeButton)
		{
			Toast toast = Toast.makeText(this, "Reservation was not made" , Toast.LENGTH_LONG);
			toast.show();

			Intent i = new Intent(this, CarRentalSystemActivity.class);
			startActivity(i);
		}
}



public boolean checkUserName(String inputName)
{
	ArrayList <Customer> customers = creatRes.getCustomers();
	
	int size = customers.size();
	
	Customer temp;
	int j = 0;
	while(j < size)
	{
		temp = customers.get(j);
		if(temp.getUserId().equals(inputName) == true)
		{
			this.index = j;
			return true;
		}
		
		j++;
	}
	
	Toast toast = Toast.makeText(this, "Username Does not Exist" , Toast.LENGTH_LONG);
	toast.show();
	return false;
	
}

public boolean checkPassword(String inputPass)
{
	ArrayList <Customer> customers = creatRes.getCustomers();
	
	Customer temp = customers.get(index);
	
	if(temp.getPassword().equals(inputPass) == true)
	{
		return true;
	}
	
	Toast toast = Toast.makeText(this, "Incorrect Pasword" , Toast.LENGTH_LONG);
	toast.show();
	return false;
}

}
