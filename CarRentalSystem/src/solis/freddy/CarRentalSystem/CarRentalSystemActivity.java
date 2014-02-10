/*Title:CarRentalSystemActivity
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract:This is the main activity. From here the program will ask the user what he/she would like to do
 * and based on their answer it will send them to creatAccount, makeReservaton, or cancelReservation. 
 */
package solis.freddy.CarRentalSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CarRentalSystemActivity extends Activity implements OnClickListener
{
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ReservationSystem creatRes = new ReservationSystem();
        Customer manager = new Customer("admin2", "admin2");
        creatRes.addCustomer(manager);
        
        View accountButton = findViewById(R.id.createAccount);
		accountButton.setOnClickListener(this);
		
        View makeButton = findViewById(R.id.makeReservation);
        makeButton.setOnClickListener(this);
        
        View cancelButton = findViewById(R.id.cancelReservation);
        cancelButton.setOnClickListener(this);
    }

	public void onClick(View v) 
	{
		if(v.getId() == R.id.createAccount)
		{
			Intent i = new Intent(this,CreateAccount.class);
			startActivity(i);
		}
		if(v.getId() == R.id.makeReservation)
		{
			Intent i = new Intent(this,SelectDate.class);
			startActivity(i);
		}
		if(v.getId() == R.id.cancelReservation)
		{
			Intent i = new Intent(this,CancelReservation.class);
			startActivity(i);
		}		
	}
}