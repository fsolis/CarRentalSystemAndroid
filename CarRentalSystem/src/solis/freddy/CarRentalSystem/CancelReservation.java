/*Title:CancelReservation
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class is for the user to log in when they want to cancel a reservation
 * it will ask for the username and password it will then send them either to the admin window for administrator or to the 
 * remove reservation system other users
 */
package solis.freddy.CarRentalSystem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class CancelReservation extends Activity implements OnClickListener
{
	private ReservationSystem creatRes;
	private int useatt = 0;
	private int passatt = 0;
	private int index = 0;
	  @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.cancelreservation);
	        
	        creatRes = new ReservationSystem();
	        
	        View okButton = findViewById(R.id.okButton);
			okButton.setOnClickListener(this);	
			
	        View homeButton = findViewById(R.id.homeButton);
	        homeButton.setOnClickListener(this);
	    }


	public void onClick(View v) 
	{
		if(v.getId() == R.id.okButton)
		{
			EditText input;
			String name;
			String password;
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
					password = input.getText().toString();
					
					if(checkPassword(password) == false)
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
						creatRes.setIndex(index);
						if(name.equals("admin2") == true && password.equals("admin2"))
						{
							Intent i = new Intent(this, AminWindow.class);
							startActivity(i);
						}
						else
						{
							Intent i = new Intent(this, RemoveReservation.class);
							startActivity(i);
						}
						
					}
				}
			}
		}
			
		if(v.getId() == R.id.homeButton)
		{
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
						creatRes.setIndex(this.index);
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
