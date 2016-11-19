package info.shadow.slidingmenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;

public class ConnectToServer {
	
	String filepath;
	  HttpPost httppost;
	  String resp;
	  
	  public String isAllowedUser(String uid)
	  {
		  HttpClient httpclient = new DefaultHttpClient();
		 httppost = new HttpPost("http://10.0.2.2/shadow/check_user.php");
		 // httppost = new HttpPost("http://sharinghearts.in/shadow/check_user.php");
	      Log.d("connected with php","############");
	    try {
	            // Add user name and password
	        
	       //  String username = uname.getText().toString();
	 
	     //  Log.d("uname", username);
	         //String pwd = password.getText().toString();
	       //  Log.d("password", pwd);
	          Log.d("storing values!!!",":)");
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	            nameValuePairs.add(new BasicNameValuePair("uid", uid));
	           
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
	            // Execute HTTP Post Request
	            Log.w("Sexecute", "Execute HTTP Post Request");
	            HttpResponse response = httpclient.execute(httppost);
	             
	          resp = inputStreamToString(response.getEntity().getContent()).toString();
	           // Log.w("", str);
	            Log.w("response from server!!",resp);
	             
	            
	        } catch (ClientProtocolException e) {
	         e.printStackTrace();
	        } catch (IOException e) {
	         e.printStackTrace();
	        }
	    if(resp==" yes")
	    {
	    	resp="1";
	    }
	    if(resp=="false")
	    {
	    	resp="2";
	    }
	   return resp;
		  
		  
	  }
	public String postLoginData(String username,String dateofbirth,String add,String pincodee,String sex,String imei,String filepath,String workplace,int value,String im)
	{
	String str = null;
		Log.d("in regfinal","sucessfullly callled :) :)");
	  // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
	
       httppost = new HttpPost("http://10.0.2.2/shadow/register_users.php");
       //httppost = new HttpPost("http://sharinghearts.in/shadow/register_users.php");
       
      Log.d("connected with php","############");
    try {
            // Add user name and password
        
       //  String username = uname.getText().toString();
 
     //  Log.d("uname", username);
         //String pwd = password.getText().toString();
       //  Log.d("password", pwd);
          Log.d("storing values!!!",":)");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("username", username));
            nameValuePairs.add(new BasicNameValuePair("dob", dateofbirth));
            nameValuePairs.add(new BasicNameValuePair("address", add));
            nameValuePairs.add(new BasicNameValuePair("pincode",pincodee));
            nameValuePairs.add(new BasicNameValuePair("sex", sex));
            nameValuePairs.add(new BasicNameValuePair("uid", imei));
            nameValuePairs.add(new BasicNameValuePair("imei", im));
			 nameValuePairs.add(new BasicNameValuePair("imagepath",filepath ));
            nameValuePairs.add(new BasicNameValuePair("workplace", workplace));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // Execute HTTP Post Request
            Log.w("Sexecute", "Execute HTTP Post Request");
            HttpResponse response = httpclient.execute(httppost);
             
            str = inputStreamToString(response.getEntity().getContent()).toString();
           // Log.w("", str);
            Log.w("response from server!!",str);
             
            
        } catch (ClientProtocolException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    return str;
    } 
	public String UpdateMessageHistory(String uidd)
	{
	String str = null;
		Log.d("in update ","messgae history!!!");
	  // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
	
       httppost = new HttpPost("http://10.0.2.2/shadow/UpdateMessageHistory.php");
       //httppost = new HttpPost("http://sharinghearts.in/shadow/register_users.php");
       
      Log.d("connected with php","############");
    try {
            // Add user name and password
        
       //  String username = uname.getText().toString();
 
     //  Log.d("uname", username);
         //String pwd = password.getText().toString();
       //  Log.d("password", pwd);
          Log.d("storing values!!!",":)");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("uid", uidd));
          
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // Execute HTTP Post Request
            Log.w("Sexecute", "Execute HTTP Post Request");
            HttpResponse response = httpclient.execute(httppost);
             
            str = inputStreamToString(response.getEntity().getContent()).toString();
           // Log.w("", str);
            Log.w("response from server!!",str);
             
            
        } catch (ClientProtocolException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    return str;
    } 
	public String getfbMessage(String uidd)
	{
	String str = null;
		Log.d("in update ","messgae history!!!");
	  // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
	
       httppost = new HttpPost("http://10.0.2.2/shadow/fbhistorydisplay.php");
       //httppost = new HttpPost("http://sharinghearts.in/shadow/register_users.php");
       
      Log.d("connected with php","############");
    try {
            // Add user name and password
        
       //  String username = uname.getText().toString();
 
     //  Log.d("uname", username);
         //String pwd = password.getText().toString();
       //  Log.d("password", pwd);
          Log.d("storing values!!!",":)");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("uid", uidd));
          
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // Execute HTTP Post Request
            Log.w("Sexecute", "Execute HTTP Post Request");
            HttpResponse response = httpclient.execute(httppost);
             
            str = inputStreamToString(response.getEntity().getContent()).toString();
           // Log.w("", str);
            Log.w("response from server!!",str);
             
            
        } catch (ClientProtocolException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    return str;
    } 
	

	public String fbPostHistory(String postid,String uidd,String message)
	{
	String str = null;
		Log.d("in update ","messgae history!!!");
	  // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
	
       httppost = new HttpPost("http://10.0.2.2/shadow/fbHistory.php");
       //httppost = new HttpPost("http://sharinghearts.in/shadow/register_users.php");
       
      Log.d("connected with php","############");
    try {
            // Add user name and password
        
       //  String username = uname.getText().toString();
 
     //  Log.d("uname", username);
         //String pwd = password.getText().toString();
       //  Log.d("password", pwd);
          Log.d("storing values!!!",":)");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("uid", uidd));
            nameValuePairs.add(new BasicNameValuePair("postid",postid ));
            nameValuePairs.add(new BasicNameValuePair("message",message ));
          
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // Execute HTTP Post Request
            Log.w("Sexecute", "Execute HTTP Post Request");
            HttpResponse response = httpclient.execute(httppost);
             
            str = inputStreamToString(response.getEntity().getContent()).toString();
           // Log.w("", str);
            Log.w("response from server!!",str);
             
            
        } catch (ClientProtocolException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    return str;
    } 
	public String ComplaintUser(String imei)
	{
	String str = null;
		Log.d("in update ","messgae history!!!");
	  // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
	
       httppost = new HttpPost("http://10.0.2.2/shadow/takeaction.php");
       //httppost = new HttpPost("http://sharinghearts.in/shadow/register_users.php");
       
      Log.d("connected with php","############");
    try {
            // Add user name and password
        
       //  String username = uname.getText().toString();
 
     //  Log.d("uname", username);
         //String pwd = password.getText().toString();
       //  Log.d("password", pwd);
          Log.d("storing values!!!",":)");
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("imei", imei));
            //nameValuePairs.add(new BasicNameValuePair("postid",postid ));
            
          
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
            // Execute HTTP Post Request
            Log.w("Sexecute", "Execute HTTP Post Request");
            HttpResponse response = httpclient.execute(httppost);
             
            str = inputStreamToString(response.getEntity().getContent()).toString();
           // Log.w("", str);
            Log.w("response from server!!",str);
             
            
        } catch (ClientProtocolException e) {
         e.printStackTrace();
        } catch (IOException e) {
         e.printStackTrace();
        }
    return str;
    } 

	public String add_contacts(String uidd,String[] name,String[] num)
	{
		String str="";
		Log.d("entered into add conytacts function",":):)");
		for(int i=0;i<5;i++)
		{
		Log.d("name",name[i]);
		Log.d("number",num[i]);
		}
		
		Log.d("in regfinal","sucessfullly callled :) :)");
		  // Create a new HttpClient and Post Header
	        HttpClient httpclient = new DefaultHttpClient();
			
	   
	   
	    	httppost = new HttpPost("http://10.0.2.2/shadow/usercontacts.php");
	    	//httppost = new HttpPost("http://sharinghearts.in/shadow/usercontacts.php");
	        
	
	    
		 
	     
	       
	 
	 
	        try {
	            // Add user name and password
	        
	       //  String username = uname.getText().toString();
	 
	     //  Log.d("uname", username);
	         //String pwd = password.getText().toString();
	       //  Log.d("password", pwd);
	          
	            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	            nameValuePairs.add(new BasicNameValuePair("name0", name[0]));
	            nameValuePairs.add(new BasicNameValuePair("name1", name[1]));
	            nameValuePairs.add(new BasicNameValuePair("name2", name[2]));
	            nameValuePairs.add(new BasicNameValuePair("name3",name[3]));
	            nameValuePairs.add(new BasicNameValuePair("name4", name[4]));
	            nameValuePairs.add(new BasicNameValuePair("uidd", uidd));
	            Log.d("in serverconnection!!",uidd);
	            
				 nameValuePairs.add(new BasicNameValuePair("num0",num[0] ));
				 nameValuePairs.add(new BasicNameValuePair("num1", num[1]));
		            nameValuePairs.add(new BasicNameValuePair("num2",num[2]));
					 nameValuePairs.add(new BasicNameValuePair("num3",num[3] ));
	            nameValuePairs.add(new BasicNameValuePair("num4", num[4]));
	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
	            // Execute HTTP Post Request
	            Log.w("Sexecute", "Execute HTTP Post Request");
	            HttpResponse response = httpclient.execute(httppost);
	             
	            str = inputStreamToString(response.getEntity().getContent()).toString();
	           // Log.w("", str);
	            Log.w("response from server!!",str);
	            
	            str="sucess";
	        } catch (ClientProtocolException e) {
	         e.printStackTrace();
	        } catch (IOException e) {
	         e.printStackTrace();
	        }
	        return str; 
	}
   
    private StringBuilder inputStreamToString(InputStream is) {
     String line = "";
     StringBuilder total = new StringBuilder();
     // Wrap a BufferedReader around the InputStream
     BufferedReader rd = new BufferedReader(new InputStreamReader(is));
     // Read response until the end
     try {
      while ((line = rd.readLine()) != null) { 
        total.append(line); 
      }
     } catch (IOException e) {
      e.printStackTrace();
     }
     // Return full string
     return total;
     
    }

	public String getfilepath() {
		// TODO Auto-generated method stub
		
		
		
		return filepath;
	}
	

}
