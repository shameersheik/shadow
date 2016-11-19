package info.shadow.slidingmenu;

import info.shadow.slidingmenu.R;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Emergencymessage extends Fragment {
	ImageButton send;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String uid = "uidkey";
	 SharedPreferences sharedpreferences;
	 String uidd;
	

		public static final String emergency = "emergencyKey"; 
		   public static final String fbupdate = "updatekey"; 
		   public static final String messagesend = "message"; 
		   public static final String shakeenable = "shakekey";
		   public static final String soundenable = "soundKey"; 
		  
		   public String mess,emer,power,sound,shake,fb;
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
	String FinalMessag="";
	String Message,link;
	String address;
	double latitude,longitude;
	String Location;
	
	
	public Emergencymessage(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        send=(ImageButton)rootView.findViewById(R.id.imageButton1);
        send.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
								
		sendMessageToClients();	
			}
		});
         
        return rootView;
    }
	public void emergencyMessage()
	{
		 try {
			 LocationGetter l1=new LocationGetter();
			 sendMessage sms=new sendMessage();
			 String hello="helloinvaribale";
				//sms.sendMess(hello,"5556");
			 //sms.sendMess("test!!!1","555-6");
			 l1.getlatlng();
			 double lati=l1.getLAT();
			 double lng=l1.getLONG();
			 latitude=lati;
			 longitude=lng;
			 Toast.makeText(getActivity().getApplicationContext(),"Latitude:"+lati+""+"Longitud:"+lng, Toast.LENGTH_LONG).show();
			// Toast.makeText(getActivity().getApplicationContext(),"longitude:"+lng+"", Toast.LENGTH_LONG).show();
			 AddressDisplay ad=new AddressDisplay();
	
			//String address= ad.getADDRESS(9.524678699999999000, 77.855308899999950000);
	 address= ad.getADDRESS(lati,lng);
			Log.d("GetAddress",address);
			 Toast.makeText(getActivity().getApplicationContext(),"address:"+address,Toast.LENGTH_LONG).show();
			
			Location="Latitude:"+latitude+"Longitude"+longitude+"";
			 Message="I am in Danger please help!!!!!";
			 link="https://maps.google.com/maps?q=police+station&near="+lati+","+lng+"";
			FinalMessag=Message+"MY Location"+Location+" My Location :"+address+"NearByPoliceStation:"+link+"";
			Log.d("linkkkkk",link);
			Toast.makeText(getActivity().getApplicationContext(),"Final message \n"+FinalMessag, Toast.LENGTH_LONG).show();
//String stat=sms.sendMess(FinalMessage, "5556");	
					 
			      }
			      catch (Exception e) {
			          /*Toast.makeText(getActivity().getApplicationContext(),
			          "SMS faild, please try again.",
			          Toast.LENGTH_LONG).show();
			          e.printStackTrace();*/
			       }
		
		 
	}
	public void sendMessageToClients()
	{
		//emergencyMessage();
	String contactlist[]=getContacts();
	for(int i=0;i<5;i++)
	{
		sendSMS(contactlist[i],FinalMessag);
	}
		ConnectToServer cr=new ConnectToServer();
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		  uidd= sharedpreferences.getString(uid, "");
		cr.UpdateMessageHistory(uidd);
		
	}
	public String Settingss()
	{
		
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		mess=sharedpreferences.getString(messagesend, "");
		Log.d("Mesage",mess);
		return mess;
				
	}
	public String[] getSetting()
	{
	Log.d("in emergency Message","INNSIDEEEEEEE");
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
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
		
		return settings;
		
	}
	public String[] getContacts()
	{
	//	Toast.makeText(getActivity().getApplicationContext(),"haii", Toast.LENGTH_LONG).show();
		SharedPreferences sharedpreferences;
		sharedpreferences =getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
		 
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
			
			//	sendSMS(numbers[i],FinalMessag);
			
				Toast.makeText(getActivity().getApplicationContext(),
				          "Message Sent Sucessfully"+numbers[i],
				          Toast.LENGTH_LONG).show();
			
				
				
			}
		return numbers;
		
	}
	public void sendSMS(String num,String mess)
	{
		
		SmsManager smss=SmsManager.getDefault();
		//smss.sendTextMessage(num, null, mess,null,null);
		//smss.sendTextMessage("5556",null,FinalMessag,null, null);
		/*smss.sendTextMessage("5556",null,Message,null, null);
		smss.sendTextMessage("5556",null,link,null, null);
		smss.sendTextMessage("5556",null,address,null, null);*/
		smss.sendTextMessage("5556",null,"From Emergeny Service",null, null);
	}
	public void sendTestSMS(String num)
	{
		String Messge="Testing Message From Shadow App";
		SmsManager smss=SmsManager.getDefault();
		//smss.sendTextMessage(num, null, mess,null,null);
		//smss.sendTextMessage("5556",null,FinalMessag,null, null);
		smss.sendTextMessage("5556",null,Messge,null, null);
		//smss.sendTextMessage("5556",null,link,null, null);
		//smss.sendTextMessage("5556",null,address,null, null);
	}
	public String getMessageContent()
	{
		emergencyMessage();
		return FinalMessag;
	}
}
