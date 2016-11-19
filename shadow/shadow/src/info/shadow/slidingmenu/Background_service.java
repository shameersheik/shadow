package info.shadow.slidingmenu;


import java.util.List;
import java.util.Locale;
import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Background_service extends Service implements SensorEventListener  {
	 boolean flag=false;
	    private long lastUpdate;
	    SensorManager sensorManager;
	            int count=0;
	            static int counter;
	            static long last;
	            long temp;
	      public  int shakecount=0;
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {

	    getAccelerometer(event);


	}
	protected void onResume() {
	    //super.onResume();
	    // register this class as a listener for the orientation and
	    // accelerometer sensors
	            sensorManager.registerListener(this,
	            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	            SensorManager.SENSOR_DELAY_NORMAL);
	}

	protected void onPause()
	{
	    // unregister listener
	    sensorManager.unregisterListener(this);

	}
	public void onStart(Intent intent, int startId)
	{
	    sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
	    sensorManager.registerListener(this,
	            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
	            SensorManager.SENSOR_DELAY_NORMAL);
	    lastUpdate = System.currentTimeMillis();
	}
	private void getAccelerometer(SensorEvent event) {
		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
		    float[] values = event.values;
		   
		    // Movement
		    float x = values[0];
		    float y = values[1];
		    float z = values[2];
		    double latitude=0;
		    double longitude=0;
		    String location_message;
		    GPSTracker gps;

		    float accelationSquareRoot = (x * x + y * y + z * z)
		        / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
		    long actualTime = System.currentTimeMillis();
		  
		    if (accelationSquareRoot >= 4) 
		    {
		    	{
		    	//	Toast.makeText(getApplicationContext(), "x:"+x+"y:"+y+"z:"+z, Toast.LENGTH_SHORT).show();
		  //  	 Toast.makeText(getApplicationContext(), "accelerationroot:"+accelationSquareRoot, Toast.LENGTH_SHORT).show();
		    	// accelationSquareRoot=(float) 0.0;
		    	 if ((temp=actualTime - lastUpdate) < 2000) {
		            count++;
			    	// Toast.makeText(getApplicationContext(), "squarevalue:"+accelationSquareRoot+"time"+temp, Toast.LENGTH_LONG).show();
		            if (count==4)
		            {
		           /* 	AlertDialog alert;
						alert= new AlertDialog.Builder(Background_service.this).create();
						alert.setTitle("Authorization Required!!");
						alert.setMessage("Need Help???");
						alert.setButton("Ok", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Toast.makeText(getApplicationContext(),"Sucessfullll", Toast.LENGTH_LONG).show();
								
							}
						});
						alert.show();*/
		            	count=0;
		            	 //Intent intent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setClassName("com.example.testservice","com.example.testservice.Dialog.class").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_FROM_BACKGROUND).setComponent(new ComponentName("com.example.testservice","com.example.testservice.Dialog.class"));
		            	 //getApplicationContext().startActivity(intent);
		            	//Intent i1=new Intent(Background_service.this,Dialog.class);
		            	//startActivity(i1);
		            	Intent i1=new Intent(getBaseContext(),Dialog.class);
		            	i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		            	getApplication().startActivity(i1);
		            }
		       // return;
		      }
	/*	      if(System.currentTimeMillis()-last<1000)
			    {
		    	  temp=System.currentTimeMillis()-last;
			    	counter++;
			    	Toast.makeText(getApplicationContext(), "counter:"+counter+"timedifference"+temp, Toast.LENGTH_LONG).show();
			    	last = System.currentTimeMillis();
			    }
			    else
			    {
			    	counter=0;
			    }*/
			   
		      //
		//    	 Toast.makeText(getApplicationContext(), "duration:"+(System.currentTimeMillis()-last)+"", Toast.LENGTH_LONG).show();
		    	 
		    	 if( (System.currentTimeMillis()-last>500) )
		      {
		    	  shakecount++;
		    	  last = System.currentTimeMillis();
		//    	  Toast.makeText(getApplicationContext(), "shakecount:"+shakecount, Toast.LENGTH_LONG).show();
		    	  
		      }
		     lastUpdate = actualTime;
		      if(shakecount>=2)
		      {
		          gps=new GPSTracker(Background_service.this);
		         // if((gps.canGetLocation())&&(counter>=2))
		          
		          {
		        	  
		            /*          count=0;    
		              latitude = gps.getLatitude();
		              longitude = gps.getLongitude();
		              Toast.makeText(getApplicationContext(), "Your Location is :lat :"+latitude +"longitude:"+longitude
                              , Toast.LENGTH_LONG).show();*/
		       // 	 Toast.makeText(getApplicationContext(), "shaked twice", Toast.LENGTH_LONG).show();
		        	  return;
		        //  \n is for new line
		        //  Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();    
		             // Geocoder gcd = new Geocoder(Background_service.this, Locale.getDefault());
		              
		          }
		         /* if(!(gps.canGetLocation())){
		        //  can't get location
		        //  GPS or Network is not enabled
		        // Ask user to enable GPS/network in settings
		        Toast.makeText(getApplicationContext(), "Switch on gps"
		                , Toast.LENGTH_LONG).show();
		      //  gps.showSettingsAlert();
		    }*/
		          }


		      /*Toast.makeText(this, "Device was shuffed", Toast.LENGTH_SHORT)
		          .show();
		      if (color) {
		        view.setBackgroundColor(Color.GREEN);

		      } else {
		        view.setBackgroundColor(Color.RED);
		      }*/

		    }}}
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public void onCreate()
	{
	    flag=true;
	    Log.d("haiii", "onCreate");
	    super.onCreate();

	}
	public void onDestroy() {

	    flag=false;
	    Log.d("hello", "onDestroy");
	    super.onDestroy();

	}
	public class GPSTracker extends Service implements LocationListener
	{
	    private final Context mContext;

	    //flag for GPS Status
	    boolean isGPSEnabled = false;

	    //flag for network status
	    boolean isNetworkEnabled = false;

	    boolean canGetLocation = false;

	    Location location;
	    double latitude;
	    double longitude;

	    //The minimum distance to change updates in metters
	    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; //10 metters

	    //The minimum time beetwen updates in milliseconds
	    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

	    //Declaring a Location Manager
	    protected LocationManager locationManager;

	    public GPSTracker(Context context) 
	    {
	        this.mContext = context;
	        getLocation();
	    }

	    public Location getLocation()
	    {
	        try
	        {
	            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

	            //getting GPS status
	            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

	            //getting network status
	            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

	            if (!isGPSEnabled && !isNetworkEnabled)
	            {
	                // no network provider is enabled
	            }
	            else
	            {
	                this.canGetLocation = true;

	                //First get location from Network Provider
	                if (isNetworkEnabled)
	                {
	                    locationManager.requestLocationUpdates(
	                            LocationManager.NETWORK_PROVIDER,
	                            MIN_TIME_BW_UPDATES,
	                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

	                    Log.d("Network", "Network");

	                    if (locationManager != null)
	                    {
	                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	                        updateGPSCoordinates();
	                    }
	                }

	                //if GPS Enabled get lat/long using GPS Services
	                if (isGPSEnabled)
	                {
	                    if (location == null)
	                    {
	                        locationManager.requestLocationUpdates(
	                                LocationManager.GPS_PROVIDER,
	                                MIN_TIME_BW_UPDATES,
	                                MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

	                        Log.d("GPS Enabled", "GPS Enabled");

	                        if (locationManager != null)
	                        {
	                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	                            updateGPSCoordinates();
	                        }
	                    }
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            //e.printStackTrace();
	            Log.e("Error : Location", "Impossible to connect to LocationManager", e);
	        }

	        return location;
	    }

	    public void updateGPSCoordinates()
	    {
	        if (location != null)
	        {
	            latitude = location.getLatitude();
	            longitude = location.getLongitude();
	        }
	    }

	    /**
	     * Stop using GPS listener
	     * Calling this function will stop using GPS in your app
	     */

	    public void stopUsingGPS()
	    {
	        if (locationManager != null)
	        {
	            locationManager.removeUpdates(GPSTracker.this);
	        }
	    }

	    /**
	     * Function to get latitude
	     */
	    public double getLatitude()
	    {
	        if (location != null)
	        {
	            latitude = location.getLatitude();
	        }

	        return latitude;
	    }

	    /**
	     * Function to get longitude
	     */
	    public double getLongitude()
	    {
	        if (location != null)
	        {
	            longitude = location.getLongitude();
	        }

	        return longitude;
	    }

	    /**
	     * Function to check GPS/wifi enabled
	     */
	    public boolean canGetLocation()
	    {
	        return this.canGetLocation;
	    }

	
	    @Override
	    public void onLocationChanged(Location location) 
	    {   
	    	updateGPSCoordinates();
	    }

	    @Override
	    public void onProviderDisabled(String provider) 
	    {   
	    }

	    @Override
	    public void onProviderEnabled(String provider) 
	    {   
	    }

	    @Override
	    public void onStatusChanged(String provider, int status, Bundle extras) 
	    {   
	    }

	    @Override
	    public IBinder onBind(Intent intent) 
	    {
	        return null;
	    }
	}
	
	

}
