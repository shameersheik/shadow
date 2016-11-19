package info.shadow.slidingmenu;



import android.app.ActivityManager;
import android.app.Fragment;
import info.shadow.slidingmenu.R;
import android.app.Fragment;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class test_now extends Fragment {
	ImageButton test;
	ImageButton start;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String uid = "uidkey";
	 SharedPreferences sharedpreferences;
	
	 public static final String messagesend = "message";
	 public static final String emergency = "emergencyKey"; 
	 public static final String fbupdate = "updatekey"; 
	 
	 public static final String shakeenable = "shakekey";
	 public static final String soundenable = "soundKey";
	 public static final String Contact1 = "con1"; 
	 public static final String  Contact2= "con2"; 
	 public static final String Contact3 = "con3"; 
	 public static final String Contact4 = "con4";
	 public static final String Contact5= "con5"; 
	 public static final String Number1 = "num1"; 
	 public static final String  Number2= "num2"; 
	 public static final String Number3= "num3"; 
	 public static final String Number4 = "num4";
	 public static final String Number5= "num5";
	String number1,number2,number3,number4,number5;
	String FinalMessag;
	String Message,link;
	String address;
	double latitude,longitude;
	String Location;

public test_now(){}
	int count=0;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.testnow, container, false);
        test=(ImageButton) rootView.findViewById(R.id.test);
        start=(ImageButton) rootView.findViewById(R.id.start);
        
        test.setOnClickListener(new View.OnClickListener() {
        		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	testnow();
				/*if(isMyServiceRunning()==true)
				{
					Toast.makeText(getActivity().getApplicationContext(),"Service Running Sucessfully!!!",Toast.LENGTH_LONG).show();
				}*/
				/*setting s=new setting();
			String[] set=s.getSettingValues();
			Log.d("in testnow",set[0]);
			Log.d("in testnow",set[1]);

			Log.d("in testnow",set[2]);
			Log.d("in testnow",set[3]);
			Log.d("in testnow",set[4]);*/
			/*String str[]=	getSetting();
			for(int i=0;i<5;i++)
			{
				 Toast.makeText(getActivity().getApplicationContext(),str[i], Toast.LENGTH_LONG).show();
				 
				 
			}*/
			
		//testnow();
			/*	if(count==4)
				{
					Toast.makeText(getActivity().getApplicationContext(),"Message Tesing COmpleted",Toast.LENGTH_LONG).show();
					
				}*/
				
			}
		});
        /*start.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});*/
        return rootView;
    }
	public void getSetting(Context context)
	{
		String mess,power,sound,shake,fb; 
//		Toast.makeText(getActivity().getApplicationContext(),"", Toast.LENGTH_LONG).show();
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, context.MODE_PRIVATE);

		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(messagesend, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(emergency, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(soundenable, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(shakeenable, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(fbupdate, ""), Toast.LENGTH_LONG).show();
		 
		 
		 /*mess=sharedpreferences.getString(messagesend, "");
		 power=sharedpreferences.getString(emergency, "");
		 sound=sharedpreferences.getString(soundenable, "");
		 shake=sharedpreferences.getString(shakeenable, "");
		 fb=sharedpreferences.getString(fbupdate, "");
		 String settings[] = {mess,power,sound,shake,fb};
		 return settings;*/
		 
	}
	public void getContacts()
	{
//		Toast.makeText(getActivity().getApplicationContext(),"", Toast.LENGTH_LONG).show();
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		 
		Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Number1, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Number2, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Number3, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Number4, ""), Toast.LENGTH_LONG).show();
		 Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Number5, ""), Toast.LENGTH_LONG).show();
		
		number1= sharedpreferences.getString(Contact1, "");
		Log.d("numbero",number1);
		number2= sharedpreferences.getString(Contact2, "");
		Log.d("number1",number2);
		number3= sharedpreferences.getString(Contact3, "");
		Log.d("number2",number3);
		number4= sharedpreferences.getString(Contact4, "");
		Log.d("number3",number4);
		number5= sharedpreferences.getString(Contact5, "");
		Log.d("number4",number5);
		String numbers[] = {number1,number2,number3,number4,number5};
		
		
		
		 
		 if (sharedpreferences.contains(Contact1))
	      {
	       //  contact1.setText(sharedpreferences.getString(Contact1, ""));
	         Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Contact1, ""), Toast.LENGTH_LONG).show();
	         
	         // number[0]=sharedpreferences.getString(Contact1, "");
	      }
	      if (sharedpreferences.contains(Contact2))
	      {
	    	  Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Contact2, ""), Toast.LENGTH_LONG).show();
	    	 // number[1]=sharedpreferences.getString(Contact2, "");
	      }
	      if (sharedpreferences.contains(Contact3))
	      {
	    	  Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Contact3, ""), Toast.LENGTH_LONG).show();
	    	  //number[2]=sharedpreferences.getString(Contact3, "");
	      }
	      if (sharedpreferences.contains(Contact4))
	      {
	    	  Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Contact4, ""), Toast.LENGTH_LONG).show();
	    	  //number[3]=sharedpreferences.getString(Contact4, "");
	      }
	      if (sharedpreferences.contains(Contact5))
	      {
	    	  Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(Contact5, ""), Toast.LENGTH_LONG).show();
	    	  //number[4]=sharedpreferences.getString(Contact5, "");
	      }    
	      //sendSMS("hai",FinalMessag);
	      for(int i=0;i<5;i++)
			{
				Log.d("in the for loop",":) :)");
				String[] str_array = numbers[i].split("\n");
				numbers[i] = str_array[1]; 
				//name[i] = str_array[1];
				Log.d("number"+i,numbers[i]);
				
				Log.d("final message",FinalMessag);
			
				sendSMS("5556");
			
				Toast.makeText(getActivity().getApplicationContext(),
				          "Message Sent Sucessfully"+numbers[i],
				          Toast.LENGTH_LONG).show();
			
				
				
			}

		
	}
	public void sendSMS(String num)
	{
		
		SmsManager smss=SmsManager.getDefault();
		//smss.sendTextMessage(num, null, mess,null,null);
		//smss.sendTextMessage("5556",null,FinalMessag,null, null);
		smss.sendTextMessage("5556",null,"Testing From Shadow Application",null, null);
		//smss.sendTextMessage("5556",null,link,null, null);
		//smss.sendTextMessage("5556",null,address,null, null);
	}
	private boolean isMyServiceRunning() {
	    ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if (Background_service.class.getName().equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
	public void  testnow()
	{
		
		getContacts();
			//em.sendSMS(num, mess)
		
	}

}
