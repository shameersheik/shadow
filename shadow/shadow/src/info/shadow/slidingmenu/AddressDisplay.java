package info.shadow.slidingmenu;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddressDisplay extends Activity {
	TextView t1,t2,locationbox;
	double lat,lng;
	Button getaddress,messagesend;
	String location_string;
	
	public void onCreate(Bundle save)
	{
		super.onCreate(save);
		//setContentView(R.layout.displayaddress);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		/*Bundle extras = getIntent().getExtras();
		final double latitude = extras.getDouble("lati");
		final double longitude = extras.getDouble("longi");*/
		
		/*t1=(TextView)findViewById(R.id.adlat);
		t2=(TextView)findViewById(R.id.adlong);
		getaddress=(Button)findViewById(R.id.getaddressss);
		messagesend=(Button)findViewById(R.id.messaging);
		locationbox=(TextView)findViewById(R.id.address);*/
	//Bundle b = getIntent().getExtras();
		//t1.setText(b.getCharSequence("lati"));
	//t2.setText(b.getCharSequence("longi"));
		
	//	t1.setText("latitude"+latitude+"");
		//t2.setText("longitude"+longitude+"");
		
		

		
		
}
	public String getADDRESS(double latitude,double longitude)
	{
		//lat=latitude;
		//lng=longitude;
		Log.d("Entered into getaddressfunction","");
		//lat=9.524678699999999000;
		//lng=77.855308899999950000;
		lat=28.649081;
		lng=77.19903440000007;
		

		
		 
		Log.d("getted latitude",lat+"");
		Log.d("getted longitude",lng+"");
		//String alert="Latituded in Json :"+lat+"longtitude in json connection"+lng+"";
		//Toast.makeText(getApplicationContext(), alert, Toast.LENGTH_SHORT).show();
	    HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lng+"&sensor=true");
	    HttpClient client = new DefaultHttpClient();
	    HttpResponse response;
	    StringBuilder stringBuilder = new StringBuilder();

	    try {
	        response = client.execute(httpGet);
	        HttpEntity entity = response.getEntity();
	        InputStream stream = entity.getContent();
	        int b;
	        while ((b = stream.read()) != -1) {
	            stringBuilder.append((char) b);
	        }
	       
	    } catch (ClientProtocolException e) {
	        } catch (IOException e) {
	    }

	    JSONObject jsonObject = new JSONObject();
	    try {
	    	
	        jsonObject = new JSONObject(stringBuilder.toString().substring(0, stringBuilder.toString().length()-1));
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
		 JSONObject ret = jsonObject; 
			JSONObject location;
			
			try {
			    location = ret.getJSONArray("results").getJSONObject(0);
			    location_string = location.getString("formatted_address");
			    Log.d("test", "formattted address:" + location_string);
			   // locationbox.setText(location_string);
			} catch (JSONException e1) {
			    e1.printStackTrace();

			}
			return  location_string;
	}

	public JSONObject getLocationInfo() {

		
		//lat=9.524678699999999000;
		// lng=77.855308899999950000;
		String alert="Latituded in Json :"+lat+"longtitude in json connection"+lng+"";
		//Toast.makeText(getApplicationContext(), alert, Toast.LENGTH_SHORT).show();
	    HttpGet httpGet = new HttpGet("http://maps.google.com/maps/api/geocode/json?latlng="+lat+","+lng+"&sensor=true");
	    HttpClient client = new DefaultHttpClient();
	    HttpResponse response;
	    StringBuilder stringBuilder = new StringBuilder();

	    try {
	        response = client.execute(httpGet);
	        HttpEntity entity = response.getEntity();
	        InputStream stream = entity.getContent();
	        int b;
	        while ((b = stream.read()) != -1) {
	            stringBuilder.append((char) b);
	        }
	       
	    } catch (ClientProtocolException e) {
	        } catch (IOException e) {
	    }

	    JSONObject jsonObject = new JSONObject();
	    try {
	    	
	        jsonObject = new JSONObject(stringBuilder.toString().substring(0, stringBuilder.toString().length()-1));
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	    return jsonObject;
	    //return new JSONObject(json.substring(json.indexOf("{"), json.lastIndexOf("}") + 1));
	}
}
