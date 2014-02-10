/*Title:AminWindow
 * Name:Freddy Solis
 * Date: May 8, 2012
 * ID: 0338
 * Abstract: This class is for the administer activity which is called when the administer logs in. This class outputs 
 * all of the current transactions that have been made.
 */


package solis.freddy.CarRentalSystem;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AminWindow extends Activity implements OnClickListener
{
	private ReservationSystem creatRes;
   @Override
    public void onCreate(Bundle savedInstanceState) 
    {
	   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminwindow);
        creatRes = new ReservationSystem();
        ArrayList <Transaction> trans = creatRes.getTransactions();
        TextView field = (TextView)findViewById(R.id.viewtrans);
        Transaction tempTrans;
        int size = trans.size();
        int j=0;
        
        while(j<size)
        {
        	tempTrans = trans.get(j);
        	
        	field.append(tempTrans.toString() + '\n' + '\n');
        	
        	j++;
        }
        
        View homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(this);
    }
public void onClick(View v) 
{
	
    if(v.getId() == R.id.homeButton)
    {
    	Intent i = new Intent(this,CarRentalSystemActivity.class);
		startActivity(i);
    }
}

}