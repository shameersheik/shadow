package info.shadow.slidingmenu;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Facebookapp extends Fragment {
	String Appid;
	ImageButton login;
	Facebook fb;
	SharedPreferences sp;
	TextView hi;
	ImageView info;
	ImageButton delete;
	TextView username;
	String response; 
	String postid;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String uid = "uidkey";
	SharedPreferences sharedpreferences;
	Emergencymessage pf=new Emergencymessage();
	public Facebookapp(){}
	
	
	@SuppressWarnings("deprecation")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.facebook, container, false);
        Appid=getString(R.string.App_id);
        login=(ImageButton)rootView.findViewById(R.id.imageButton1);
        delete=(ImageButton)rootView.findViewById(R.id.imageButton2);
        hi=(TextView)rootView.findViewById(R.id.hi);
        username=(TextView)rootView.findViewById(R.id.welcometext);
        info=(ImageView)rootView.findViewById(R.id.infotext);
        fb=new Facebook(Appid);
        sp=getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        try {
			response= fb.request("me");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String access_token=sp.getString("access_token", null);
        Long expires=sp.getLong("access_expires", 0);
        if(access_token != null){
        	fb.setAccessToken(access_token);
        }
        if(expires!=0){
        	fb.setAccessExpires(expires);
        }
        updatebutton();
        login.setOnClickListener(new View.OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				if(fb.isSessionValid()){
				
					try {
						fb.logout(getActivity());
						updatebutton();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					
					fb.authorize(getActivity(),new String[]{"status_update"},new DialogListener(){
						@Override
						public void onCancel() {
							// TODO Auto-generated method stub
							Toast.makeText(getActivity(), "onCancel",Toast.LENGTH_SHORT ).show();
						}

						@Override
						public void onComplete(Bundle arg0) {
							// TODO Auto-generated method stub
							Toast.makeText(getActivity(), "onComplete",Toast.LENGTH_SHORT ).show();
							Editor editor=sp.edit();
							editor.putString("access_token", fb.getAccessToken());
							editor.putLong("access_expires", fb.getAccessExpires());
							editor.commit();
							updatebutton();
						}

						@Override
						public void onError(DialogError arg0) {
							// TODO Auto-generated method stub
							Toast.makeText(getActivity(), "onError",Toast.LENGTH_SHORT ).show();
						}

						@Override
						public void onFacebookError(FacebookError arg0) {
							// TODO Auto-generated method stub
							Toast.makeText(getActivity(), "onFacebookError",Toast.LENGTH_SHORT ).show();
						}
						
					});
				}
					
				}
				
			});
        
        delete.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				JSONObject obj=null;
				String jsonUser;
				try {
					jsonUser = fb.request("me");
					obj=Util.parseJson(jsonUser);
					Bundle params1=new Bundle();
					params1.putString("id", response);
					response=fb.request("me/delete",params1, "POST");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FacebookError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String id=obj.optString("id");
				String name=obj.optString("name");
				try {
					String response= fb.request("me");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
        	
        });
         
        return rootView;
    }

	@SuppressWarnings("deprecation")
	public void updatebutton(){
		if(fb.isSessionValid()){
			login.setImageResource(R.drawable.bluebuttonlogout);
			
			JSONObject obj=null;
			try {
				String jsonUser=fb.request("me");
				obj=Util.parseJson(jsonUser);
				String id=obj.optString("id");
				String name=obj.optString("name");
				String response= fb.request("me");
				Bundle params=new Bundle();
		//		String msg="accessing fb through my project";
				String msg=pf.getMessageContent();
				Log.d("msg",""+msg);
				params.putString("message", "Lattitude=28.649081:Longitude=77.19903440000007 \n I am in Danger please help!!!!!\n i am at  https://www.google.com/maps/search/police+station+near+28.649081,77.19903440000007 \n\n i am at address:Desh Bandhu Gupta Road, Block A, Karol Bagh, New Delhi, Delhi 110005, India");
				params.putString("description", "hello");
				response = fb.request("me/feed", params,"POST");
				Log.d("Tests", "got response: " + response);
				ConnectToServer cs=new ConnectToServer();
				sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
				String  uidd= sharedpreferences.getString(uid, "");
				cs.fbPostHistory(response,uidd,msg);
				hi.setVisibility(View.VISIBLE);
				username.setText(name);
				delete.setVisibility(View.VISIBLE);
		//		String response= fb.request("me");
		//		Bundle params=new Bundle();
		//		String msg="accessing fb through my project";
		//		params.putString("message", msg);
		//		params.putString("description", "hello");
		//		response = fb.request("me/feed", params,"POST");
				Log.d("Tests", "got response: " + response);
/*				fb.dialog(getActivity(), "feed", params,new DialogListener(){

					@Override
					public void onCancel() {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onComplete(Bundle arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onError(DialogError arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onFacebookError(FacebookError arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
	*/			
				info.setVisibility(View.VISIBLE);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FacebookError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			login.setImageResource(R.drawable.bluebuttonlogin);
			hi.setVisibility(View.GONE);
			username.setVisibility(View.GONE);
			info.setVisibility(View.GONE);
			delete.setVisibility(View.GONE);
			
		}
	}
	
	public void onActivityResult(int requestCode,int resultCode,Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		fb.authorizeCallback(requestCode, resultCode, data);
				
	}
	
}
