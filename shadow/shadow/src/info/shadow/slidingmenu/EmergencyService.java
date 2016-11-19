package info.shadow.slidingmenu;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.widget.Toast;

public class EmergencyService {

	String []setting;
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
	 
		
	 public void emerge()
	 {
		 Log.d("inside emrgee",":):)");
		 //setting s=new setting();
		//String a[]= s.getSettingValues();
		 Emergencymessage em=new Emergencymessage();
		//* String a[]=em.getSetting();
		 String message=em.Settingss();
		Log.d("messgeeeeeeeee",message);
		/*for(int i=0;i<5;i++)
		{
			Log.d("Vallllllllue",a[0]);
		}*/
		 /*if(sharedpreferences.getString(messagesend, "").equalsIgnoreCase("enable"))
		 {
			// Toast.makeText(getActivity().getApplicationContext(), "message Enabled", Toast.LENGTH_LONG).show();
			 Log.d("Message Send","enabled :) :) :)");
		 }*/
	 }
	public void emergencyservice(String[] a)
	{
		Log.d("in","in mergency service");
		setting=new String[5];
		setting[0]=a[0];//message
		setting[1]=a[1];//power
		setting[2]=a[2];//sound
		setting[3]=a[3];//shake
		setting[4]=a[4];//fb
		
		
		Log.d("vlaue",a[0]);
		Log.d("vlaue",a[1]);
		Log.d("vlaue",a[2]);
		Log.d("vlaue",a[3]);
		Log.d("vlaue",a[4]);
		if(isMessageEnabled()==true)
		{
			//Toast.makeText(getActivity().getApplicationContext(),"messagenable",Toast.LENGTH_LONG).show();
			
			Log.d("FunctionMessage","Enabled");
			Emergencymessage em=new Emergencymessage();
			em.sendMessageToClients();
		}
		/*if(isPowerEnabled()==true)
		{
			Log.d("FunctionPower","Enabled");
		}
		if(isShakeEnabled()==true)
		{
			Log.d("functionShake","Enabled");
			
		}
		if(isFBEnabled()==true)
		{
			Log.d("functionFb","Enabled");
		}*/
		if(isSoundEnabled()==true)
		{
			Log.d("FunctionSound","Enabled");
			ChooseMedia cm=new ChooseMedia();
		cm.play();
		}
		
		
		
		//getSetting();
		
	}
	public void getSetting()
	{
	Emergencymessage	 m1=new Emergencymessage();
		String []a1=m1.getSetting();
		
		Log.d("message",a1[0]);
		Log.d("shake",a1[3]);
		Log.d("sound",a1[2]);
		Log.d("fb",a1[4]);
		Log.d("power",a1[1]);
	}
	public boolean isShakeEnabled()
	{
		if(setting[3].equalsIgnoreCase("enable"))
		{
			Log.d("shakeddddd","enabled");
		return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isSoundEnabled()
	{
		if(setting[2].equalsIgnoreCase("enable"))
		{
			Log.d("sound","enableddddd");
		return true;
		}
		else
		{
			return false;
		}
	
		
	}
	public boolean isFBEnabled()
	{
		if(setting[4].equalsIgnoreCase("enable"))
		{
			Log.d("fb","enabledddd");
		return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean isMessageEnabled()
	{
		if(setting[0].equalsIgnoreCase("enable"))
		{
			Log.d("message","enableddddd");
		return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean isPowerEnabled()
	{
		if(setting[1].equalsIgnoreCase("enable"))
		{
			Log.d("power","enabledddd");
		return true;
		}
		else
		{
			return false;
		}
		
	}
		
	
}
