/*Title:SelectCar
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class if for the activity where the user selects the car available. if the cars are not available for the 
 * date that user has input, then the button for that car is disabled. once the user inputs a car the create reservation where 
 * the user logs in is callled. 
 */
package solis.freddy.CarRentalSystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class SelectCar extends Activity implements OnClickListener
{
	private ReservationSystem creatRes;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcar);
        creatRes = new ReservationSystem();
        
        View makeButton = findViewById(R.id.homeButton);
        makeButton.setOnClickListener(this);
        
        View vanButton = findViewById(R.id.vanButton);
        vanButton.setOnClickListener(this);
        
        View truckButton = findViewById(R.id.truckButton);
        truckButton.setOnClickListener(this);
        
        View sedanButton = findViewById(R.id.sedanButton);
        sedanButton.setOnClickListener(this);
        Dates checkDate = creatRes.getTempDate();
 		Cars van = creatRes.getVan();
 		Cars sedan = creatRes.getSedan();
 		Cars truck = creatRes.getTruck();
 		
 		if(van.checkDate(checkDate) == false)
 		{
 			vanButton.setEnabled(false);
 			
 			if(truck.checkDate(checkDate) == false)
 	 		{
 				if(sedan.checkDate(checkDate) == false)
 		 		{
 					Toast toast = Toast.makeText(this, "No Cars Available On This Date", Toast.LENGTH_LONG);
 					toast.show();
 		 		}
 	 		}
 			
 		}
 		if(sedan.checkDate(checkDate) == false)
 		{
 			sedanButton.setEnabled(false);
 		}
 		if(truck.checkDate(checkDate) == false)
 		{
 			truckButton.setEnabled(false);
 		}
         
         
    }

	public void onClick(View v) 
	{
		
 		
		if(v.getId() == R.id.vanButton)
		{
			creatRes.setTempCar("Minivan");
			Intent i = new Intent(this,LogInSystem.class);
			startActivity(i);
		}
		if(v.getId() == R.id.truckButton)
		{
			creatRes.setTempCar("Truck");
			Intent i = new Intent(this,LogInSystem.class);
			startActivity(i);
		}
		if(v.getId() == R.id.sedanButton)
		{
			creatRes.setTempCar("Sedan");
			Intent i = new Intent(this,LogInSystem.class);
			startActivity(i);
		}
		if(v.getId() == R.id.homeButton)
		{
			Intent i = new Intent(this, CarRentalSystemActivity.class);
			startActivity(i);
		}
	}

}
