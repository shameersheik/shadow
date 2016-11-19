package info.shadow.slidingmenu;

import android.app.AlertDialog;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

public class MySetting extends Fragment  {
	
	 public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String emergency = "emergencyKey"; 
	   public static final String fbupdate = "updatekey"; 
	   public static final String messagesend = "message"; 
	   public static final String shakeenable = "shakekey";
	   public static final String soundenable = "soundKey"; 
	   public static final String Number1 = "num1";
	   public String mess,emer,power,sound,shake,fb;
	public  SharedPreferences sharedpreferences;
	public	Editor editor;
public MySetting(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		
		
        View rootView = inflater.inflate(R.layout.settingsbutton, container, false);
        final ImageButton updatefb;
		final ImageButton emergencybutton;
		final ImageButton sendmessage;
		final ImageButton enableshake;
		final ImageButton enablesound;
		ImageButton startapp;

        updatefb=(ImageButton)rootView.findViewById(R.id.imageButton5);
        sendmessage=(ImageButton)rootView.findViewById(R.id.imageButton4);
        emergencybutton=(ImageButton)rootView.findViewById(R.id.imageButton3);
        enableshake=(ImageButton)rootView.findViewById(R.id.imageButton2);
        enablesound=(ImageButton)rootView.findViewById(R.id.imageButton6);
        startapp=(ImageButton)rootView.findViewById(R.id.imageButton1);
        sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
   //     editor= sharedpreferences.edit();

        
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
        if(sharedpreferences.getString(messagesend, "")==null)
		{
        	
        	editor = sharedpreferences.edit();
			  editor.putString(messagesend,"false" );
	        editor.commit(); 
	       
		}
        else
        {
        	if(sharedpreferences.getString(messagesend, "")=="true")
			{
				
				
        		sendmessage.setImageResource(R.drawable.smsgreen);
        	}
        	else if(sharedpreferences.getString(messagesend, "")=="false")
        	{
        		sendmessage.setImageResource(R.drawable.smsred);
        	}
        }
       /* if(sharedpreferences.getString(emergency, "")==null)
		{
        	editor.putString(emergency,"false" );
		}
        else
        {
        	if(sharedpreferences.getString(emergency, "")=="true")
			{
        		emergencybutton.setImageResource(R.drawable.powerbuttongreen);
        	}
        	else
        	{
        		emergencybutton.setImageResource(R.drawable.powerbuttonred);
        	}
        }
        if(sharedpreferences.getString(shakeenable, "")==null)
		{
        	editor.putString(shakeenable,"false" );
		}
        else
        {
        	if(sharedpreferences.getString(shakeenable, "")=="true")
			{
        		enableshake.setImageResource(R.drawable.shakegreen);
        	}
        	else
        	{
        		enableshake.setImageResource(R.drawable.shakered);
        	}
        }
        if(sharedpreferences.getString(soundenable, "")==null)
		{
        	editor.putString(soundenable,"false" );
		}
        else
        {
        	if(sharedpreferences.getString(soundenable, "")=="true")
			{
        		 enablesound.setImageResource(R.drawable.helpsoundgreen);
        	}
        	else
        	{
        		 enablesound.setImageResource(R.drawable.helpsoundred);
        	}
        }
        if(sharedpreferences.getString(fbupdate, "")==null)
		{
        	editor.putString(fbupdate,"false" );
		}
        else
        {
        	if(sharedpreferences.getString(fbupdate, "")=="true")
			{
        		updatefb.setImageResource(R.drawable.facebookgreen);
        	}
        	else
        	{
        		 updatefb.setImageResource(R.drawable.facebookred);
        	}
        }*/
        
        /*editor.putString(fbupdate,"false" );
        editor.putString(soundenable,"false" );
        editor.putString(messagesend,"false" );
        editor.putString(emergency,"false" );
        editor.putString(shakeenable,"false" );
        editor.commit(); */
        
        
			mess=sharedpreferences.getString(messagesend, "");
			Log.d("Mesage",mess);
			 power=sharedpreferences.getString(emergency, "");
			 Log.d("Emergency",power);
			sound=sharedpreferences.getString(soundenable, "");
			Log.d("Sound Enable",sound);
			shake=sharedpreferences.getString(shakeenable, "");
			Log.d("ShakeEnable",shake);
			fb=sharedpreferences.getString(fbupdate, "");
			Log.d("FBupdate",fb);	
				
			
			//editor= sharedpreferences.edit();
        updatefb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//updatefb
				 //sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				if(sharedpreferences.getString(fbupdate, "")=="true")
				{
					 updatefb.setImageResource(R.drawable.facebookred);
				
				 
		        editor.putString(fbupdate,"false" );
		        
		       
				}
				else
				{
					if(sharedpreferences.getString("access_token", null)!=null)
					{
					 updatefb.setImageResource(R.drawable.facebookgreen);
					// editor = sharedpreferences.edit();
				        editor.putString(fbupdate,"true" );
				      //  editor.commit();
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
				fb=sharedpreferences.getString(fbupdate, "");
				}
			
		});
	
        enablesound.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//updatefb
				if(sharedpreferences.getString(soundenable, "")=="true")
				{
					 enablesound.setImageResource(R.drawable.helpsoundred);
				
					// editor = sharedpreferences.edit();
				editor.putString(soundenable,"false" );
		        //editor.commit(); 
		       
				}
				else
				{
					 enablesound.setImageResource(R.drawable.helpsoundgreen);
						
					 editor = sharedpreferences.edit();
						editor.putString(soundenable,"true" );
				       // editor.commit();
				}
				sound=sharedpreferences.getString(soundenable, "");
			}
		});
 sendmessage.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			
			if(sharedpreferences.getString(messagesend, "")=="true")
			{
				
				
				sendmessage.setImageResource(R.drawable.smsred);
			
			editor = sharedpreferences.edit();
			  editor.putString(messagesend,"false" );
	        editor.commit(); 
	       
			}
			else
			{
				if(sharedpreferences.getString(Number1, "")!="")
				{
				sendmessage.setImageResource(R.drawable.smsgreen);
					
				 editor = sharedpreferences.edit();
					  editor.putString(messagesend,"true" );
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
			mess=sharedpreferences.getString(messagesend, "");
		}
	});
 emergencybutton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			if(sharedpreferences.getString(emergency, "")=="true")
			{
				emergencybutton.setImageResource(R.drawable.powerbuttonred);
			
		// editor = sharedpreferences.edit();
			  editor.putString(emergency,"false" );
	      //  editor.commit(); 
	       
			}
			else
			{
				emergencybutton.setImageResource(R.drawable.powerbuttongreen);
					
			//editor = sharedpreferences.edit();
					  editor.putString(emergency,"true" );
			  //      editor.commit();
			}
			power=sharedpreferences.getString(emergency, "");
		}
	});
 enableshake.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			if(sharedpreferences.getString(shakeenable, "")=="true")
			{
				enableshake.setImageResource(R.drawable.shakered);
			
			 //editor = sharedpreferences.edit();
			   editor.putString(shakeenable,"false" );
	        //editor.commit(); 
	       
			}
			else
			{
				enableshake.setImageResource(R.drawable.shakegreen);
					
				// editor = sharedpreferences.edit();
					   editor.putString(shakeenable,"true" );
			      //  editor.commit();
			}
			shake=sharedpreferences.getString(shakeenable, "");
		}
	});
      
 startapp.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//updatefb
			 
			 mess=sharedpreferences.getString(messagesend, "");
				Log.d("Mesage",mess);
				 power=sharedpreferences.getString(emergency, "");
				 Log.d("Emergency",power);
				sound=sharedpreferences.getString(soundenable, "");
				Log.d("Sound Enable",sound);
				shake=sharedpreferences.getString(shakeenable, "");
				Log.d("ShakeEnable",shake);
				fb=sharedpreferences.getString(fbupdate, "");
				Log.d("FBupdate",fb);	
			 
			 
				String settings[] = {mess,power,sound,shake,fb};
			EmergencyService es=new EmergencyService();
			es.emergencyservice(settings);
			
		}
	});       
        
 //editor.commit(); 
        return rootView;
	}
	
	/*public String[] getSettingValues()
	{
		 Log.d("in my setting","INSIDE MY SETTING");
		 sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

		 mess=sharedpreferences.getString(messagesend, "");
			Log.d("Mesage",mess);
			
			 Log.d("Emergency",power);
			
			Log.d("Sound Enable",sound);
			
			Log.d("ShakeEnable",shake);
			
			Log.d("FBupdate",fb);	
		 
		 
		String settings[] = {mess,power,sound,shake,fb};
		
		return settings;
		
	}*/
}
