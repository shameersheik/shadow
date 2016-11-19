package info.shadow.slidingmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dialog extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);

		AlertDialog alertDialog ;

		   alertDialog = new AlertDialog.Builder(this).create();

		    alertDialog.setTitle("SHADOW");

		    alertDialog.setMessage("Need Help For");

		    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Police Station", new DialogInterface.OnClickListener() {

		      public void onClick(DialogInterface dialog, int id) {

		    	  	//...
		    	  EmergencyService es=new EmergencyService();
		    	  
		    	  

		    } }); 

		    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Fire Station", new DialogInterface.OnClickListener() {

		      public void onClick(DialogInterface dialog, int id) {

		        //...

		    }}); 

		    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Hospital", new DialogInterface.OnClickListener() {

		      public void onClick(DialogInterface dialog, int id) {

		        //...

		    }});
		
		alertDialog.show();
				
	}
	

}
