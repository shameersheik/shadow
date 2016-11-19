package info.shadow.slidingmenu;


import android.app.Activity;
import android.app.Service;
import android.content.Context;
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

public class LocationGetter  extends Activity {
	Button b2,add;
	TextView lo,la;
	double lat,lng;
	GPSTracker gps;
	public LocationGetter()
	{
	getlatlng();	
	}
	public void onCreate(Bundle save)
	{
		super.onCreate(save);
		/*setContentView(R.layout.locationdisplayer);
		lo=(TextView)findViewById(R.id.longti);
		
		la=(TextView)findViewById(R.id.lati);
		final GPSTracker gps=new GPSTracker(this);
		b2=(Button)findViewById(R.id.getloc);
		add=(Button)findViewById(R.id.getadd);
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 if (gps.canGetLocation())
				  {
					  lat=gps.getLatitude();
					  lng=gps.getLongitude();
					  lo.setText("longitude"+lng+"");
					  la.setText("latitude"+lat+"");
				  }
				
			}
		});
		if (gps.canGetLocation())
		  {
			  lat=gps.getLatitude();
			  lng=gps.getLongitude();
			  lo.setText("longitude"+lng+"");
			  la.setText("latitude"+lat+"");
		  }
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent openNewActivity = new Intent(getApplicationContext(), AddressDisplay.class);
				//openNewActivity.putExtra("lattiii",lat);
				Bundle b = new Bundle();
				//b.putString("lati", lat+"");
				//b.putString("longi",lng+"" );
				openNewActivity.putExtra("lati",lat);
				openNewActivity.putExtra("longi",lng);
			//openNewActivity.putExtra("lonti",lng);
				startActivity(openNewActivity);
			    
			}
		});*/
	
		
		
	}
	public void getlatlng()
	{
		gps=new GPSTracker(this);
		if (gps.canGetLocation())
		  {
			  lat=gps.getLatitude();
			  lng=gps.getLongitude();
			  
		  }
	}
	public double getLAT()
	{
		lat=9.524678699999999000;
		String latitude="";
		latitude=lat+"";
		
	return lat;	
	}
	public double getLONG()
	{
		lng=77.855308899999950000;
		String longitude="";
		longitude=lng+"";
		
		return lng;
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
