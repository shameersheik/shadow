package info.shadow.slidingmenu;

import info.shadow.slidingmenu.R;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.StrictMode;
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

public class UserDetails extends Fragment {
	ImageButton register;
	ImageView propic;
	EditText dob,addres,pincode,name,workplace;
	private RadioGroup radioSexGroup;
	  private RadioButton radioSexButton,male,female;
	  String dateofbirth,pincodee,username,sex,add,wp;
	  String imei;
	  String uidd;
	  String status;
	  public static final String MyPREFERENCES = "MyPrefs" ;
	   public static final String Name = "nameKey"; 
	   public static final String Pincode = "pincode"; 
	   public static final String Workplace = "workplaceKey"; 
	   public static final String Address = "addresskey";
	   public static final String Sex = "SexKey"; 
	   public static final String Dateofbirth = "dobkey";
	   public static String uid = "uidkey";
	  
	   public static final String Imei = "imei key";

	   SharedPreferences sharedpreferences;
	public UserDetails(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
        final View rootView = inflater.inflate(R.layout.fragment_register, container, false);
Log.d("entered into layo ##########################################","entered into fragment home");
        
        register=(ImageButton) rootView.findViewById(R.id.imageButton1);
        male=(RadioButton) rootView.findViewById(R.id.radioButton1);
        female=(RadioButton) rootView.findViewById(R.id.radioButton2);
        
		propic=(ImageView)rootView.findViewById(R.id.imageView1);
		addres=(EditText)rootView.findViewById(R.id.editText3);
		pincode=(EditText)rootView.findViewById(R.id.editText4);
		name=(EditText)rootView.findViewById(R.id.editText1);
		workplace=(EditText)rootView.findViewById(R.id.editText5);	
		
		dob=(EditText)rootView.findViewById(R.id.editText2);
		//dob=(EditText)findViewById(R.id.dob);
		radioSexGroup = (RadioGroup) rootView.findViewById(R.id.radiosex);
		//imei=((reqdetails)getActivity()).getimei();
		/*radioSexGroup.setOnClickListener(new View.OnClickListener() {
			
            public void onClick(View v) {
            	int selectedId = radioSexGroup.getCheckedRadioButtonId();
                switch(selectedId){
                 case R.id.radioButton1:
                   sex = "male";

                  break;
                 case R.id.radioButton2:
                     sex = "female";

                 break;      
                

                }}});*/
		
		  /*dateofbirth=dob.getText().toString();
	        username=name.getText().toString();
	        sex=radioSexButton.getText().toString();
	        add=addres.getText().toString();
	        pincodee=pincode.getText().toString();
	        wp=workplace.getText().toString();
		 Log.d("Date",dateofbirth);
		 Log.d("username",username);
		 Log.d("sex",sex);
		 Log.d("address",add);

		 Log.d("pincode",pincodee);
		 Log.d("porkplace",wp);*/
		 
		 //if()
		
		sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

	      if (sharedpreferences.contains(Name))
	      {
	         name.setText(sharedpreferences.getString(Name, ""));
	         Log.d("name",sharedpreferences.getString(Name, ""));
	      }
	      if (sharedpreferences.contains(Pincode))
	      {
	         pincode.setText(sharedpreferences.getString(Pincode, ""));
	         Log.d("name",sharedpreferences.getString(Pincode, ""));
	      }
	      if (sharedpreferences.contains(Address))
	      {
	         addres.setText(sharedpreferences.getString(Address, ""));
	         Log.d("name",sharedpreferences.getString(Address, ""));
	      }
	      if (sharedpreferences.contains(Dateofbirth))
	      {
	         dob.setText(sharedpreferences.getString(Dateofbirth, ""));
	         Log.d("name",sharedpreferences.getString(Dateofbirth, ""));
	      }
	      if (sharedpreferences.contains(Workplace))
	      {
	         workplace.setText(sharedpreferences.getString(Workplace,""));
	         Log.d("name",sharedpreferences.getString(Workplace,""));
	      }

	      if (sharedpreferences.contains(uid))
	        {
	         uidd= sharedpreferences.getString(uid, "");
	         //Log.d("Unique id########################",uidd);

	        }
	        else
	        	uidd="0";
	      Log.d("Unique id########################",uidd);
		
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//int selectedId = radioSexGroup.getCheckedRadioButtonId();
				// find the radiobutton by returned id
		       // radioSexButton = (RadioButton) rootView.findViewById(selectedId);
		       // sex=radioSexButton.getText().toString(); 
				sex="male";
				
			        dateofbirth=dob.getText().toString();
			        username=name.getText().toString();
			       
			        
			        add=addres.getText().toString();
			        pincodee=pincode.getText().toString();
			        wp=workplace.getText().toString();
			        ConnectToServer r=new ConnectToServer();
			        TelephonyManager tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
					// get IMEI
					 imei = tm.getDeviceId();
			        Log.d("string getted",wp);
			        //store in android preference
			        Editor editor = sharedpreferences.edit();
			        editor.putString(Name, username);
			        editor.putString(Pincode, pincodee);
			        editor.putString(Address, add);
			        editor.putString(Dateofbirth, dateofbirth);
			        editor.putString(Workplace, wp);
			        editor.putString(Sex, sex);
			        editor.putString(Imei, imei);
			        editor.commit(); 
			       
			

			       
			    //uidd="0";   
			 //r.postLoginData(username,dateofbirth,add,pincodee,sex);
			      //  r.postLoginData(username, dateofbirth, add, pincodee, sex, imei, filepath, workplace, value)
			        if (uidd!="0")
				      {
			        	uidd=sharedpreferences.getString(uid, "");
			        	Log.d("already registered user!!!",":P :P");
			        	
			        	  status=r.postLoginData(username,dateofbirth,add,pincodee,sex,uidd,"/sdcard/demo",wp,2,imei);
			        	 
				      }
			        else
			        {
			        status=r.postLoginData(username,dateofbirth,add,pincodee,sex,uidd,"/sdcard/demo",wp,1,imei);
			        editor = sharedpreferences.edit();
		        	 editor.putString(uid,status);
		        	 editor.commit();
		        	 Log.d(uid,status);
		        	 Toast.makeText(getActivity().getApplicationContext(),status,Toast.LENGTH_LONG);
			        }
			        Log.d("server returned",status);
			        if(status=="failure")
			        {
			        	Toast.makeText(getActivity().getApplicationContext(),"Registration Failure",Toast.LENGTH_LONG);
			        }
			       // if(status!="two" )
			       // {
			        	 
			       // }
				
				
				
			}
		});
	
//(()getActivity()).yourPublicMethod();
         
        return rootView;
    }
	
}
