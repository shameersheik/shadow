
package info.shadow.slidingmenu;

import info.shadow.slidingmenu.R;
import java.lang.*;

import java.util.ArrayList;



import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SelectContacts extends Fragment {
	ArrayList<String> mylist = new ArrayList<String>();	
	RelativeLayout r1;
public TextView outputText;
ImageButton save;
AutoCompleteTextView contact1;
AutoCompleteTextView contact2;
AutoCompleteTextView contact3;
AutoCompleteTextView contact4;
AutoCompleteTextView contact5;
SharedPreferences sharedpreferences;
Editor editor;
public static final String emergency = "emergencyKey"; 
public static final String fbupdate = "updatekey"; 
public static final String messagesend = "message"; 
public static final String shakeenable = "shakekey";
public static final String soundenable = "soundKey"; 
 
public static final String MyPREFERENCES = "MyPrefs" ;
public static final String uid = "uidkey";

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
public String mess,emer,power,sound,shake,fb;
	public SelectContacts(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
		fetchContacts(rootView);
        return rootView;
    }
	
public void fetchContacts(View rootView) {
		
		String phoneNumber = null;
		String email = null;
		String name1=null;
	
		save=(ImageButton)rootView.findViewById(R.id.savecontacts);


		Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
		String _ID = ContactsContract.Contacts._ID;
		String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
		String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

		Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
		String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
	

		Log.d("fetchcontacts","inside");
		Uri EmailCONTENT_URI =  ContactsContract.CommonDataKinds.Email.CONTENT_URI;
		String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
		String DATA = ContactsContract.CommonDataKinds.Email.DATA;

		StringBuffer output = new StringBuffer();

		ContentResolver contentResolver = getActivity().getContentResolver();

		Cursor cursor = contentResolver.query(CONTENT_URI, null,null, null, null);	
		int N = cursor.getCount(); 
		TextView[] myTextViews = new TextView[N];
		int i=0;
	
		if (cursor.getCount() > 0) {
			Log.d("cursor.getcount","inside");
	//		final TextView rowTextView = new TextView(this);
			while (cursor.moveToNext()) {
				Log.d("cursor.moveToNext","inside");
				String contact_id = cursor.getString(cursor.getColumnIndex( _ID ));
				String name = cursor.getString(cursor.getColumnIndex( DISPLAY_NAME ));
				int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex( HAS_PHONE_NUMBER )));

				if (hasPhoneNumber > 0) {
					output.delete(0, output.length());
	//				final TextView rowview = new TextView(this);
					output.append(name + "\n");
					Log.d("hasPhoneNUmber","inside");

					// Query and loop for every phone number of the contact
					Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contact_id }, null);

					while (phoneCursor.moveToNext()) {
						phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
						output.append(phoneNumber);
						

					}
					
					
					phoneCursor.close();

					// Query and loop for every email of the contact
					Cursor emailCursor = contentResolver.query(EmailCONTENT_URI,	null, EmailCONTACT_ID+ " = ?", new String[] { contact_id }, null);

					while (emailCursor.moveToNext()) {

						email = emailCursor.getString(emailCursor.getColumnIndex(DATA));



					}

					emailCursor.close();
					name1=output.toString();
					mylist.add(name1);
					
				}


				
				
				

				
			}
			Log.d("mylist",mylist.toString());
//			rowTextView.setText(output);
//			rowTextView.setClickable(true);
//			rowTextView.setOnClickListener(new OnClickListener() {

//				@Override
//				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					rowTextView.setBackgroundColor(0xfff00000);
					
//				}
//	        });
			Log.d("relativelayout","finished");
			
//			r1=(RelativeLayout)getView().findViewById(R.id.rellaycontact);
			Log.d("relativelayout","finished");
//			myTextViews[i]=rowTextView;
		

			Log.d("addingadapter","inside");				
			contact1=(AutoCompleteTextView)rootView.findViewById(R.id.contact1);
			contact2=(AutoCompleteTextView)rootView.findViewById(R.id.contact2);
			contact3=(AutoCompleteTextView)rootView.findViewById(R.id.contact3);
			contact4=(AutoCompleteTextView)rootView.findViewById(R.id.contact4);
			contact5=(AutoCompleteTextView)rootView.findViewById(R.id.contact5);
			Log.d("adapter","inside");
			ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, mylist);
			Log.d("afteradapter","inside");
			contact1.setAdapter(autoCompleteAdapter);
			contact2.setAdapter(autoCompleteAdapter);
			contact3.setAdapter(autoCompleteAdapter);
			contact4.setAdapter(autoCompleteAdapter);
			contact5.setAdapter(autoCompleteAdapter);
			Log.d("afteradapter","inside");
			sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
			editor = sharedpreferences.edit();
			
			if (sharedpreferences.contains(Contact1))
		      {
		         contact1.setText(sharedpreferences.getString(Contact1, ""));
		         
		      }
		      if (sharedpreferences.contains(Contact2))
		      {
		         contact2.setText(sharedpreferences.getString(Contact2, ""));
		         
		      }
		      if (sharedpreferences.contains(Contact3))
		      {
		         contact3.setText(sharedpreferences.getString(Contact3, ""));
		        
		      }
		      if (sharedpreferences.contains(Contact4))
		      {
		         contact4.setText(sharedpreferences.getString(Contact4, ""));
		        
		      }
		      if (sharedpreferences.contains(Contact5))
		      {
		         contact5.setText(sharedpreferences.getString(Contact5,""));
		         
		      }  
			
		}
save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("Entered into onclick listener",":)");
				String tot1,tot2,tot3,tot4,tot5;
				String[] total,num,name;
				String uidd = null;
				total=new String[5];
				num=new String[5];
				name=new String[5];
				
				String num1,num2,num3,num4,num5;
				String name1,name2,name3,name4,name5;
				total[0]=contact1.getText().toString();
				total[1]=contact2.getText().toString();
				total[2]=contact3.getText().toString();
				total[3]=contact4.getText().toString();
				total[4]=contact5.getText().toString();
				
			       
			        
			
				 
				if (sharedpreferences.contains(uid))
			        {
			         uidd= sharedpreferences.getString(uid, "");
			         Toast.makeText(getActivity().getApplicationContext(),"ur registration id -"+uidd,Toast.LENGTH_LONG).show();
			         //Log.d("Unique id########################",uidd);

			        }
			        else
			        {
			        	Toast.makeText(getActivity().getApplicationContext(),"Register to store contacts!!!",Toast.LENGTH_LONG).show();
			        	//uidd="";
			        }
			 
				for(int i=0;i<5;i++)
				{
					Log.d("in the for loop",":) :)");
					String[] str_array = total[i].split("\n");
					num[i] = str_array[0]; 
					name[i] = str_array[1];
					Log.d("number",num[i]);
					Log.d("name",name[i]);				
				}

		        editor.putString(Number1,num[0] );
		        editor.putString(Number2, num[1]);
		        editor.putString(Number3, num[2]);
		        editor.putString(Number4,num[3]);
		        editor.putString(Number5 ,num[4]);
		        editor.commit();
				
				ConnectToServer reg=new ConnectToServer();
				 editor.putString(Contact1,total[0] );
			        editor.putString(Contact2, total[1]);
			        editor.putString(Contact3, total[2]);
			        editor.putString(Contact4, total[3]);
			        editor.putString(Contact5 ,total[4]);
			        

			        editor.commit();
			        Log.d("uid",uidd);
				String status=reg.add_contacts(uidd,name, num);
				Toast.makeText(getActivity().getApplicationContext(),status,Toast.LENGTH_LONG).show();
				if(status=="sucess")
				{
					Log.d("Status","sucess");
					Toast.makeText(getActivity().getApplicationContext(), "sucessfully saved!!!",Toast.LENGTH_LONG).show();
				}
				else
				{
					Log.d("Status","failure");
					Toast.makeText(getActivity().getApplicationContext(), "Save not Sucessull!!",Toast.LENGTH_LONG).show();
				}
				/*String[] str_array = num1.split("\n");
				String stringa = str_array[0]; 
				String stringb = str_array[1];
				Log.d("name",stringa);
				Log.d("number",stringb);
				Log.d("Entered Number",num1);*/
			}
		});
	}


}
