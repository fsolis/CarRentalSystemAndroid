/*Title:CreateAccount
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This activity is called when the user wants to create an account, it will ask for the user name and password.
 * it will then make sure that the user name is valid as well as the password. Once everything is valid then it creates a new 
 * Customer and adds it to the system. It outputs the transaction summary and returns to the main menu. if the username and pass-
 * word is fails twice it will return to main menu.
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

public class CreateAccount extends Activity implements OnClickListener
{
		private int attempts =0;
		private ReservationSystem creatRes;
	   @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.createaccount);
	        creatRes = new ReservationSystem();
	        
	       
	        View okButton = findViewById(R.id.okButton);
			okButton.setOnClickListener(this);	
			
	        View homeButton = findViewById(R.id.homeButton);
	        homeButton.setOnClickListener(this);
	        
	    }


	public void onClick(View v) 
	{
		String name;
		String password;
		if(v.getId() == R.id.okButton)
		{
			EditText input;
			Customer temp;
			input = (EditText)findViewById(R.id.getusername);
			name = input.getText().toString();
			if(attempts < 2)
			{
				if(checkUserName(name) == false)
				{
					attempts ++;
				}
				else
				{
					input = (EditText)findViewById(R.id.getpassword);
					password = input.getText().toString();
					if(checkPassword(password) == false)
					{
						attempts++;
					}
					else
					{
						temp = new Customer(name, password);
						
						creatRes.addCustomer(temp);
						
						Transaction newAcc = new Transaction(temp,1);
						creatRes.addTrans(newAcc);
						Toast toast = Toast.makeText(this, "Account Created." + '\n' + newAcc.toString(), Toast.LENGTH_LONG);
						toast.show();
						Intent i = new Intent(this,CarRentalSystemActivity.class);
						startActivity(i);
						
					}
				}
			}
			if(attempts == 2)
			{
				Intent i = new Intent(this,CarRentalSystemActivity.class);
				startActivity(i);
			}
		
		}
		if(v.getId() == R.id.homeButton)
		{
			Intent i = new Intent(this,CarRentalSystemActivity.class);
			startActivity(i);
		}
	
	}
	
	public boolean checkUserName(String input)
	{
		Customer temp = new Customer(input, "password");
		ArrayList <Customer> customers = creatRes.getCustomers();
		
		if(customers.contains(temp) == true)
		{
			Toast toast = Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT);
			toast.show();
			return false;
		}
		boolean checker = true;
		char c;
		int countInt = 0, countLetter = 0;
		for(int i=0;i < input.length();i++)
		{
			c = input.charAt(i);
			{
				if( Character.isDigit(c) )
				{
					countInt++;
				}
				if(Character.isLetter(c))
				{
					countLetter++;
				}
			}
		}
		if(countInt ==0)
		{
			checker = false;
		}
		if(countLetter == 0)
		{
			checker = false;
		}
		if(input.length() < 5)
		{
			checker = false;
		}
		if(checker == false)
		{
			Toast toast = Toast.makeText(this, "Username must be 5 characters long (Numbers and Letters", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		return checker;
	}
	
	public boolean checkPassword(String input)
	{
		boolean checker = true;
		char c;
		int countInt = 0, countLetter = 0;
		for(int i=0;i < input.length();i++)
		{
			c = input.charAt(i);
			{
				if( Character.isDigit(c) )
				{
					countInt++;
				}
				if(Character.isLetter(c))
				{
					countLetter++;
				}
			}
		}
		if(countInt ==0)
		{
			checker = false;
		}
		if(countLetter == 0)
		{
			checker = false;
		}
		if(input.length() < 5)
		{
			checker = false;
		}
		if(checker == false)
		{
			Toast toast = Toast.makeText(this, "Password must be 5 characters long (Numbers and Letters", Toast.LENGTH_SHORT);
			toast.show();
		}
		
		return checker;
	}

}
