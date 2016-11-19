package info.shadow.slidingmenu;



import android.app.Fragment;

import android.app.AlertDialog;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class setting extends Fragment {

ImageButton updatefb;
ImageButton emergencybutton;
ImageButton sendmessage;
ImageButton enableshake;
ImageButton enablesound;
ImageButton startapp;
public static final String MyPREFERENCES = "MyPrefs" ;
 public static final String messagesend = "message";
 public static final String emergency = "emergencyKey"; 
 public static final String fbupdate = "updatekey"; 
 
 public static final String shakeenable = "shakekey";
 public static final String soundenable = "soundKey";
 SharedPreferences sharedpreferences;
 public String mess,emer,power,sound,shake,fb;
 public static final String Number1 = "num1";
 Editor editor;
 public setting(){}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.settingsbutton, container, false);
       
		
		 updatefb=(ImageButton)rootView.findViewById(R.id.imageButton5);
	        sendmessage=(ImageButton)rootView.findViewById(R.id.imageButton4);
	        emergencybutton=(ImageButton)rootView.findViewById(R.id.imageButton3);
	        enableshake=(ImageButton)rootView.findViewById(R.id.imageButton2);
	        enablesound=(ImageButton)rootView.findViewById(R.id.imageButton6);
	        startapp=(ImageButton)rootView.findViewById(R.id.imageButton1);
	        
	        
	        sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	        mess=sharedpreferences.getString(messagesend, "");
			Log.d("beforeMesage",mess);
			 power=sharedpreferences.getString(emergency, "");
			 Log.d("beforeEmergency",power);
			sound=sharedpreferences.getString(soundenable, "");
			Log.d("Sbeforeound Enable",sound);
			shake=sharedpreferences.getString(shakeenable, "");
			Log.d("beforeShakeEnable",shake);
			fb=sharedpreferences.getString(fbupdate, "");
			Log.d("beforeFBupdate",fb);
	        // editor = sharedpreferences.edit();
	       
			 // editor.putString(messagesend,"false" );
	        //sendmessage.setImageResource(R.drawable.smsgreen);
	        
	        //Powerbuttn
			if(sharedpreferences.getString(emergency, "").equalsIgnoreCase("enable"))
			{
	       
	        	Toast.makeText(getActivity().getApplicationContext(),"insideifformessagesend", Toast.LENGTH_LONG).show();
	        	emergencybutton.setImageResource(R.drawable.powerbuttongreen);
				

			}
			else
			{
				if(sharedpreferences.getString(emergency, "").equalsIgnoreCase(""))
				{
					emergencybutton.setImageResource(R.drawable.powerbuttonred);
					 editor = sharedpreferences.edit();
					  editor.putString(emergency,"disable" );
			      editor.commit(); 
				
				}
				if(sharedpreferences.getString(emergency, "").equalsIgnoreCase("disable"))
				{
					emergencybutton.setImageResource(R.drawable.powerbuttonred);
				}
			}

	        if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase("enable"))
			{
	       
	        	Toast.makeText(getActivity().getApplicationContext(),"insideifformessagesend", Toast.LENGTH_LONG).show();
				sendmessage.setImageResource(R.drawable.smsgreen);
				

			}
			else
			{
				if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase(""))
				{
					sendmessage.setImageResource(R.drawable.smsred);
					editor = sharedpreferences.edit();
	    			editor.putString(messagesend,"disable" );
	    	        editor.commit();
					
				}
				if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase("disable"))
				{
					sendmessage.setImageResource(R.drawable.smsred);
				}
			}
	       //spound button start 
	       if(sharedpreferences.getString(soundenable, "").equalsIgnoreCase("enable"))
			{
	       
	        	//Toast.makeText(getActivity().getApplicationContext(),"insideifformessagesend", Toast.LENGTH_LONG).show();
	    	   enablesound.setImageResource(R.drawable.helpsoundgreen);
				

			}
			else
			{
				if(sharedpreferences.getString(soundenable, "").equalsIgnoreCase(""))
				{
					enablesound.setImageResource(R.drawable.helpsoundred);
					 editor = sharedpreferences.edit();
						editor.putString(soundenable,"disable" );
				        editor.commit(); 			
				}
				if(sharedpreferences.getString(soundenable, "").equalsIgnoreCase("disable"))
				{
					enablesound.setImageResource(R.drawable.helpsoundred);
				}
			}
	        //fbbutton
	       if(sharedpreferences.getString(fbupdate, "").equalsIgnoreCase("enable"))
			{
	       
	        	//Toast.makeText(getActivity().getApplicationContext(),"insideifformessagesend", Toast.LENGTH_LONG).show();
				updatefb.setImageResource(R.drawable.facebookgreen);
				

			}
			else
			{
				if(sharedpreferences.getString(fbupdate, "").equalsIgnoreCase(""))
				{
					 updatefb.setImageResource(R.drawable.facebookred);
					 editor = sharedpreferences.edit();
				        editor.putString(fbupdate,"disable" );
				        editor.commit();
			
				}
				if(sharedpreferences.getString(fbupdate, "").equalsIgnoreCase("disable"))
				{
					 updatefb.setImageResource(R.drawable.facebookred);
				}
			}
//shake enable
	       if(sharedpreferences.getString(shakeenable, "").equalsIgnoreCase("enable"))
			{
	       
	        	//Toast.makeText(getActivity().getApplicationContext(),"insideifformessagesend", Toast.LENGTH_LONG).show();
	   		enableshake.setImageResource(R.drawable.shakegreen);
				

			}
			else
			{
				if(sharedpreferences.getString(shakeenable, "").equalsIgnoreCase(""))
				{
					enableshake.setImageResource(R.drawable.shakered);
					 editor = sharedpreferences.edit();
					   editor.putString(shakeenable,"disable" );
			        editor.commit();
					
				}
				if(sharedpreferences.getString(shakeenable, "").equalsIgnoreCase("disable"))
				{
					enableshake.setImageResource(R.drawable.shakered);
				}
			}	       
	        Toast.makeText(getActivity().getApplicationContext(),"status of messagesend:"+ sharedpreferences.getString(messagesend, "")+"", Toast.LENGTH_LONG).show();
	     //   Toast.makeText(getActivity().getApplicationContext(),"status of facebook:"+ sharedpreferences.getString(fbupdate, "")+"", Toast.LENGTH_LONG).show();
	       // Toast.makeText(getActivity().getApplicationContext(),"status of power:"+ sharedpreferences.getString(emergency, "")+"", Toast.LENGTH_LONG).show();
	        //Toast.makeText(getActivity().getApplicationContext(),"status of shake:"+ sharedpreferences.getString(shakeenable, "")+"", Toast.LENGTH_LONG).show();
	        //Toast.makeText(getActivity().getApplicationContext(),"status of sound:"+ sharedpreferences.getString(soundenable, "")+"", Toast.LENGTH_LONG).show();
	        //editor.commit();
	        sendmessage.setOnClickListener(new View.OnClickListener() {
	    		
	    		@Override
	    		public void onClick(View v) {
	    			// TODO Auto-generated method stub
	    			
	    			if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase("enable"))
	    			{
	    				Toast.makeText(getActivity().getApplicationContext(),"offf message send", Toast.LENGTH_LONG).show();
	    				sendmessage.setImageResource(R.drawable.smsred);
	    				
	    				editor = sharedpreferences.edit();
		    			  editor.putString(messagesend,"disable" );
		    	        editor.commit(); 
		    	       

	    			}


	    			else
	    			{
	    			if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase("disable"))
	    			{
	    				if(sharedpreferences.getString(Number1, "")!="")
	    				{
	    				sendmessage.setImageResource(R.drawable.smsgreen);
    					
	    				 editor = sharedpreferences.edit();
	    					  editor.putString(messagesend,"enable" );
	    			        editor.commit();
	    				}
	    				else
	    				{
	    					AlertDialog alert;
	    					alert= new AlertDialog.Builder(getActivity()).create();
	    					alert.setTitle("COntacts Needed!!");
	    					alert.setMessage("Add Contatc to send Message!!!!");
	    					alert.setButton("Ok", new DialogInterface.OnClickListener() {
	    					
	    					@Override
	    					public void onClick(DialogInterface dialog, int which) {
	    						// TODO Auto-generated method stub
	    						
	    						}
	    						});
	    					alert.show();
	    				}
	    			}
	    			}
	    			//	    			mess=sharedpreferences.getString(messagesend, "");
	    		}
	    	});
		
		startapp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//EmergencyService er=new EmergencyService();
			//er.emerge();
			//ConnectToServer cs=new ConnectToServer();
				//cs.fbPostHistory("hai", "hello","eeeeeeeeeeee");
			
				mess=sharedpreferences.getString(messagesend, "");
				 power=sharedpreferences.getString(emergency, "");
				 sound=sharedpreferences.getString(soundenable, "");
				 shake=sharedpreferences.getString(shakeenable, "");
				 fb=sharedpreferences.getString(fbupdate, "");
			 
				String settings[] = {mess,power,sound,shake,fb};
			
				//String settings[]=tn.getSetting();
			EmergencyService es=new EmergencyService();
			es.emergencyservice(settings);
			

					
			/*AlertDialog alertDialog ;

			   alertDialog = new AlertDialog.Builder(getActivity()).create();

			    alertDialog.setTitle("SHADOW");

			    alertDialog.setMessage("Need Help For");

			    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Police Station", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {

			    	  	//...
			  		String settings[] = {mess,power,sound,shake,fb};
					EmergencyService es=new EmergencyService();
					es.emergencyservice(settings);
			    	 // EmergencyService es=new EmergencyService();
			    	  
			    	  
			    	  

			    } }); 

			    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Fire Station", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {

			    	  String settings[] = {mess,power,sound,shake,fb};
						EmergencyService es=new EmergencyService();
						es.emergencyservice(settings);

			    }}); 

			    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Hospital", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {

			    	  String settings[] = {mess,power,sound,shake,fb};
						EmergencyService es=new EmergencyService();
						es.emergencyservice(settings);

			    }});
			
			alertDialog.show();*/
			
			
			
			
			
			
			
			
			
			
			}
		});
updatefb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//updatefb
				 //sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				if(sharedpreferences.getString(fbupdate, "").equalsIgnoreCase("enable"))
				{
					 updatefb.setImageResource(R.drawable.facebookred);
				
					 editor = sharedpreferences.edit();
		        editor.putString(fbupdate,"disable" );
		        editor.commit();
		       
				}
				else
				{
					if(sharedpreferences.getString(fbupdate, "").equalsIgnoreCase("disable"))
					{
					if(sharedpreferences.getString("access_token", null)!=null)
					{
					 updatefb.setImageResource(R.drawable.facebookgreen);
					 editor = sharedpreferences.edit();
				        editor.putString(fbupdate,"enable" );
				        editor.commit();
					}
					else
					{
						AlertDialog alert;
						alert= new AlertDialog.Builder(getActivity()).create();
						alert.setTitle("FaceBook Authentication Required!!");
						alert.setMessage("Login To ur Facebook Account!!!!");
						alert.setButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
							}
							});
						alert.show();
					}
					}
				}
				fb=sharedpreferences.getString(fbupdate, "");
				}
			
		});
	
        enablesound.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//updatefb
				if(sharedpreferences.getString(soundenable, "").equalsIgnoreCase("enable"))
				{
					 enablesound.setImageResource(R.drawable.helpsoundred);
				
					 editor = sharedpreferences.edit();
				editor.putString(soundenable,"disable" );
		        editor.commit(); 
		       
				}
				else
				{
					if(sharedpreferences.getString(soundenable, "").equalsIgnoreCase("disable"))
					{
					 enablesound.setImageResource(R.drawable.helpsoundgreen);
						
					 editor = sharedpreferences.edit();
						editor.putString(soundenable,"enable" );
					   editor.commit();
					}
				}
				sound=sharedpreferences.getString(soundenable, "");
			}
		});
 
 emergencybutton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			if(sharedpreferences.getString(emergency, "").equalsIgnoreCase("enable"))
			{
				emergencybutton.setImageResource(R.drawable.powerbuttonred);
			
		 editor = sharedpreferences.edit();
			  editor.putString(emergency,"disable" );
	      editor.commit(); 
	       
			}
			else
			{
				if(sharedpreferences.getString(emergency, "").equalsIgnoreCase("disable"))
				{
				emergencybutton.setImageResource(R.drawable.powerbuttongreen);
					
			editor = sharedpreferences.edit();
					  editor.putString(emergency,"enable" );
			        editor.commit();
				}
				}
			power=sharedpreferences.getString(emergency, "");
		}
	});
 enableshake.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			if(sharedpreferences.getString(shakeenable, "").equalsIgnoreCase("enable"))
			{
				enableshake.setImageResource(R.drawable.shakered);
			
			 editor = sharedpreferences.edit();
			   editor.putString(shakeenable,"disable" );
	        editor.commit(); 
	        getActivity().stopService(new Intent(getActivity(),Background_service.class));
	       
			}
			else
			{
				if(sharedpreferences.getString(shakeenable, "").equalsIgnoreCase("disable"))
				{
				enableshake.setImageResource(R.drawable.shakegreen);
					
				 editor = sharedpreferences.edit();
					   editor.putString(shakeenable,"enable" );
			        editor.commit();
			        getActivity().startService(new Intent(getActivity(),Background_service.class));
			}
			}
			shake=sharedpreferences.getString(shakeenable, "");
		}
	});
    
		 return rootView;
	}

	public String[] getSettingValues()
	{
		 Log.d("in my setting","INSIDE MY SETTING");
		//sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

		 //sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		 
		 
		String settings[] = {mess,power,sound,shake,fb};
		
		return settings;
		
	}
	}
