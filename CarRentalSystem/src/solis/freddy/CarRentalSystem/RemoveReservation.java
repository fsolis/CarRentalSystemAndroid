/*Title:RemoveReservation
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class is meant for the remove reservations activity. This activity will ask the 
 * user to chose an reservation they would like to cancel, then it will ask them to confirm and then it will
 * remove the reservation. if the user has no reservations it will say so and return to the main menu
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

public class RemoveReservation extends Activity implements OnClickListener 
{
	private int index =0;
	private ReservationSystem creatRes;
	private boolean atleast = false;
	private boolean doubcheck = false;
   @Override
    public void onCreate(Bundle savedInstanceState) 
    {
	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removereservation);
        creatRes = new ReservationSystem();
        ArrayList <Reservation> reserv = creatRes.getReservations();
        ArrayList <Customer> custs = creatRes.getCustomers();
        index = creatRes.getIndex();
        Customer temp = custs.get(index);
        Reservation tempRes;
        String name = temp.getUserId();
        TextView field = (TextView)findViewById(R.id.viewres);
        int size = reserv.size();
        int j=0;
        
        while(j<size)
        {
        	tempRes = reserv.get(j);
        	if(temp.getUserId().equals(name) == true)
        	{
        		atleast = true;
        		field.append(tempRes.toString() + '\n');
        	}
        	j++;
        }
        if(atleast == false)
        {
        	Toast toast = Toast.makeText(this, "No Reservations for this account.", Toast.LENGTH_LONG);
			toast.show();
			
			Intent i = new Intent(this,CarRentalSystemActivity.class);
			startActivity(i);
        }
               		
        View cancelButton = findViewById(R.id.cancelReservation);
        cancelButton.setOnClickListener(this);
        
        View homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);
    }

public void onClick(View v) 
{
	if(v.getId() == R.id.cancelReservation)
	{
		ArrayList <Reservation> reserv = creatRes.getReservations();
	    ArrayList <Customer> custs = creatRes.getCustomers();
	    Customer temp = custs.get(index);
	    Reservation tempRes;
		int choice;
		EditText input = (EditText)findViewById(R.id.getreservationnum);
		String numbers = input.getText().toString();	
		choice = Integer.parseInt(numbers);
		int size = reserv.size();
	    int j=0;
	    
	    while(j<size)
	    {
	    	tempRes = reserv.get(j);
	    	
	    	if(tempRes.getResNumber() == choice)
	    	{
	    		Dates tempdate;
	    		
					if(tempRes.getCar().equals("Sedan") && doubcheck == true)
					{
						tempdate = tempRes.getDate();
						Cars sedan = creatRes.getSedan();
						sedan.removeDate(tempdate);
						creatRes.setSedan(sedan);
						creatRes.removeReservation(tempRes);
						Transaction temptrans = new Transaction(temp, 3);
						creatRes.addTrans(temptrans);
						Toast toast = Toast.makeText(this, temptrans.toString(), Toast.LENGTH_LONG);
						toast.show();
						
						Intent i = new Intent(this,CarRentalSystemActivity.class);
						startActivity(i);
						
					}
					if(tempRes.getCar().equals("Sedan") && doubcheck == false)
					{
						Toast toast = Toast.makeText(this, "Are you Sure? Press Cancel Again?, else click Main Menu " , Toast.LENGTH_LONG);
						toast.show();
						doubcheck =true;
					}
					if(tempRes.getCar().equals("Truck") && doubcheck == true)
					{
						tempdate = tempRes.getDate();
						Cars truck = creatRes.getTruck();
						truck.removeDate(tempdate);
						creatRes.setTruck(truck);
						creatRes.removeReservation(tempRes);
						Transaction temptrans = new Transaction(temp, 3);
						creatRes.addTrans(temptrans);
						Toast toast = Toast.makeText(this, temptrans.toString(), Toast.LENGTH_LONG);
						toast.show();
						
						Intent i = new Intent(this,CarRentalSystemActivity.class);
						startActivity(i);
						
					}
					if(tempRes.getCar().equals("Truck") && doubcheck == false)
					{
						Toast toast = Toast.makeText(this, "Are you Sure? Press Cancel Again?, else click Main Menu " , Toast.LENGTH_LONG);
						toast.show();
						doubcheck =true;
					}
					if(tempRes.getCar().equals("Minivan") && doubcheck == true)
					{
						tempdate = tempRes.getDate();
						Cars van = creatRes.getVan();
						van.removeDate(tempdate);
						creatRes.setVan(van);
						creatRes.removeReservation(tempRes);
						Transaction temptrans = new Transaction(temp, 3);
						creatRes.addTrans(temptrans);
						Toast toast = Toast.makeText(this, temptrans.toString(), Toast.LENGTH_LONG);
						toast.show();
						
						Intent i = new Intent(this,CarRentalSystemActivity.class);
						startActivity(i);
						
					}
					if(tempRes.getCar().equals("Minivan") && doubcheck == false)
					{
						Toast toast = Toast.makeText(this, "Are you Sure? Press Cancel Again?, else click Main Menu " , Toast.LENGTH_LONG);
						toast.show();
						doubcheck =true;
					}
				}
	    	j++;
	    }
	}
    if(v.getId() == R.id.homeButton)
    {
    	Intent i = new Intent(this,CarRentalSystemActivity.class);
		startActivity(i);
    }
	
	
}

}
