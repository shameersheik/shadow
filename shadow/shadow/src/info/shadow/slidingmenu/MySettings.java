package info.shadow.slidingmenu;

import info.shadow.slidingmenu.R;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class MySettings extends Fragment implements CompoundButton.OnCheckedChangeListener{
	Switch updatefb,emergencybutton,sendmessage,enableshake,enablesound;
	 public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String emergency = "emergencyKey"; 
	   public static final String fbupdate = "updatekey"; 
	   public static final String messagesend = "message"; 
	   public static final String shakeenable = "shakekey";
	   public static final String soundenable = "soundKey"; 
	 SharedPreferences sharedpreferences;
		Editor editor;
	 
	public MySettings(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.mysettings, container, false);
       
        updatefb=(Switch)rootView.findViewById(R.id.switch2);
        sendmessage=(Switch)rootView.findViewById(R.id.switch1);
        emergencybutton=(Switch)rootView.findViewById(R.id.switch3);
        enableshake=(Switch)rootView.findViewById(R.id.switch4);
        enablesound=(Switch)rootView.findViewById(R.id.switch5);
        
        
        if (updatefb != null) {
            //s1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        	updatefb.setOnCheckedChangeListener(this);
        	if (updatefb != null) {
                updatefb.setOnCheckedChangeListener(this);
            }
        	
        }
        if (sendmessage != null) {
            //s1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        	sendmessage.setOnCheckedChangeListener(this);
        	if (sendmessage != null) {
        		sendmessage.setOnCheckedChangeListener(this);
            }
        	
        }
        if (emergencybutton != null) {
            //s1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        	emergencybutton.setOnCheckedChangeListener(this);
        	if (emergencybutton != null) {
        		emergencybutton.setOnCheckedChangeListener(this);
            }
        	
        }
        if ( enableshake != null) {
            //s1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        	 enableshake.setOnCheckedChangeListener(this);
        	if ( enableshake != null) {
        		 enableshake.setOnCheckedChangeListener(this);
            }
        	
        }
        if (enablesound != null) {
            //s1.setOnCheckedChangeListener((OnCheckedChangeListener) this);
        	enablesound.setOnCheckedChangeListener(this);
        	if (enablesound != null) {
        		enablesound.setOnCheckedChangeListener(this);
            }
        	
        }
        
        
      
    
        
        
         
        return rootView;
    }
	@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		editor = sharedpreferences.edit();
		
		if(updatefb.isChecked())
		{
				//Toast.makeText(getActivity().getApplicationContext(),updatefb.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "fb switch is " + "on", Toast.LENGTH_LONG).show();
				Editor editor = sharedpreferences.edit();
		        editor.putString(fbupdate,"true" );
		        editor.commit(); 
		}
		else
		{
			//Toast.makeText(getActivity().getApplicationContext(),updatefb.isChecked()+"", Toast.LENGTH_LONG).show();
			 //Toast.makeText(getActivity().getApplicationContext(), "fb switch is " + "off", Toast.LENGTH_LONG).show();
			 editor = sharedpreferences.edit();
		        editor.putString(fbupdate,"false" );
		        editor.commit(); 
		}
		
		if(sendmessage.isChecked())
		{
				//Toast.makeText(getActivity().getApplicationContext(),sendmessage.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "sendmessage switch is " + "on", Toast.LENGTH_LONG).show();
		 editor = sharedpreferences.edit();
		 editor.putString(messagesend,"true" );
				editor.commit(); 
			}
		else
		{
			//Toast.makeText(getActivity().getApplicationContext(),sendmessage.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "sendmessage switch is " + "off", Toast.LENGTH_LONG).show();
			 editor = sharedpreferences.edit();
			 editor.putString(messagesend, "false");
			 editor.commit(); 
		}
		if(emergencybutton.isChecked())
		{
				//Toast.makeText(getActivity().getApplicationContext(),emergencybutton.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "emergencybutton switch is " + "on", Toast.LENGTH_LONG).show();
			  editor = sharedpreferences.edit();
			  editor.putString(emergency,"true" );
				editor.commit(); 
		}
		else
		{
			//Toast.makeText(getActivity().getApplicationContext(),emergencybutton.isChecked()+"", Toast.LENGTH_LONG).show();
			 //Toast.makeText(getActivity().getApplicationContext(), "emergencybutton switch is " + "off", Toast.LENGTH_LONG).show();
			 editor = sharedpreferences.edit();
			 editor.putString(emergency,"false" );
				editor.commit(); 
		}
		if( enableshake.isChecked())
		{
				//Toast.makeText(getActivity().getApplicationContext(), enableshake.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), " enableshake switch is " + "on", Toast.LENGTH_LONG).show();
			  editor = sharedpreferences.edit();
			  editor.putString(shakeenable,"true" );
				editor.commit(); 
		}
		else
		{
			//Toast.makeText(getActivity().getApplicationContext(), enableshake.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), " enableshake switch is " + "off", Toast.LENGTH_LONG).show();
			editor = sharedpreferences.edit();
			 editor.putString(shakeenable, "false");
				editor.commit(); 
		}
		if(enablesound.isChecked())
		{
				//Toast.makeText(getActivity().getApplicationContext(),enablesound.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "enablesound switch is " + "on", Toast.LENGTH_LONG).show();
			editor = sharedpreferences.edit();
			 editor.putString(soundenable, "true");
				editor.commit(); 
		}
		else
		{
			//Toast.makeText(getActivity().getApplicationContext(),enablesound.isChecked()+"", Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(), "enablesound switch is " + "off", Toast.LENGTH_LONG).show();
			 editor = sharedpreferences.edit();
			 editor.putString(soundenable,"false" );
				editor.commit(); 
		}
				 
		Toast.makeText(getActivity().getApplicationContext(),"fb"+sharedpreferences.getString(fbupdate, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(messagesend, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),"emergecny button"+sharedpreferences.getString(emergency, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),"enablesheik"+sharedpreferences.getString(shakeenable, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),"enablesound"+sharedpreferences.getString(soundenable, ""), Toast.LENGTH_LONG).show();
		Toast.makeText(getActivity().getApplicationContext(), "Settings:", Toast.LENGTH_LONG).show();
		// Toast.makeText(getActivity().getApplicationContext(), "Monitored switch is " + (isChecked ? "on" : "off"), Toast.LENGTH_LONG).show();
}
}