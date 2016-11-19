package info.shadow.slidingmenu;
import com.google.android.gms.maps.SupportMapFragment;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle; 
import android.os.IBinder;
import android.app.Activity; 
import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu; 
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap; 
import com.google.android.gms.maps.MapFragment; 
import com.google.android.gms.maps.model.LatLng; 
import com.google.android.gms.maps.model.Marker; 
import com.google.android.gms.maps.model.MarkerOptions; 
public class maps_google extends FragmentActivity  {
	ImageView img;
	public maps_google(){}
	
	private GoogleMap mMap;     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapsgoogle);
		
		try {
            // Loading map
            initilizeMap();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public void initilizeMap() {
        if (mMap == null) {
        	mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();         
    		mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);         
    		final LatLng CIU = new LatLng(35.21843892856462, 33.41662287712097);         
    	
    		Marker ciu = mMap.addMarker(new MarkerOptions()                                   
    		.position(CIU).title("My Office"));     
        	//map1.setMapType(GoogleMap.MAP_TYPE_NORMAL);
 
            // check if map is created successfully or not
            if (mMap == null) {
                Toast.makeText(getApplicationContext(),  "Sorry! unable to create maps",Toast.LENGTH_LONG).show();
            }
        }
        /*switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) )
        {
          case ConnectionResult.SUCCESS:
              Toast.makeText(getApplicationContext(), "SUCCESS", Toast.LENGTH_SHORT).show();
              break;
          case ConnectionResult.SERVICE_MISSING: 
              Toast.makeText(getApplicationContext(), "SERVICE MISSING", Toast.LENGTH_SHORT).show();
              break;
          case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED: 
              Toast.makeText(getApplicationContext(), "UPDATE REQUIRED", Toast.LENGTH_SHORT).show();
              break;
          default: Toast.makeText(getApplicationContext(), GooglePlayServicesUtil.isGooglePlayServicesAvailable(this), Toast.LENGTH_SHORT).show();
        }*/
    }
/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}*/
	

}

