package info.shadow.slidingmenu;

import info.shadow.slidingmenu.R;
import info.shadow.slidingmenu.adapter.NavDrawerListAdapter;
import info.shadow.slidingmenu.model.NavDrawerItem;

import java.util.ArrayList;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Slider extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidingmain);

		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
		
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
		

		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons.getResourceId(7, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[8], navMenuIcons.getResourceId(8, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[9], navMenuIcons.getResourceId(9, -1)));
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[10], navMenuIcons.getResourceId(10, -1)));
		


		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
			if(position ==0)
			{
			displayView(position);
			}
			else
			{
				 	sharedpreferences =getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
					String Uid= sharedpreferences.getString(uid, "");
					//Toast.makeText(getApplicationContext(),Uid, Toast.LENGTH_LONG).show();
					if(Uid!="")
					{
						//Toast.makeText(getApplicationContext(),"Registered user", Toast.LENGTH_LONG).show();
						//isAllowedUser();
						ConnectToServer r=new ConnectToServer();
						//Toast.makeText(getApplicationContext(),"ur id:"+Uid, Toast.LENGTH_LONG).show();
						
						//Toast.makeText(getApplicationContext(),"response from regfinale"+r.isAllowedUser(Uid), Toast.LENGTH_LONG).show();
						String status=	r.isAllowedUser(Uid);
						status.replaceAll("\\s+","");
						//Toast.makeText(getApplicationContext(),"st:"+status, Toast.LENGTH_LONG).show();
						//status="1";
						String YES="yes";
						String NO="no";
						if(status.replaceAll("\\s+","").equalsIgnoreCase(YES.replaceAll("\\s+","")))
						{
						displayView(position);
						}
					
						if(status.replaceAll("\\s+","").equalsIgnoreCase(NO.replaceAll("\\s+","")))
						{
							AlertDialog alert;
							alert= new AlertDialog.Builder(Slider.this).create();
							alert.setTitle("USER BLOCKED!!");
							alert.setMessage("As u Have Done Some Illegal Activites using our App u r BLOCKED!!!!");
							alert.setButton("Ok", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								
								}
								});
							alert.show();
						}
				
						
						
						
						
					}
					else
					{
						AlertDialog alert;
						alert= new AlertDialog.Builder(Slider.this).create();
						alert.setTitle("Authorization Required!!");
						alert.setMessage("Register ur Detials In Our Application To Use Our APP");
						alert.setButton("Ok", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								
							}
						});
						alert.show();
						//Toast.makeText(getApplicationContext(),"Register to use our application", Toast.LENGTH_LONG).show();
					}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new UserDetails();
			break;
		case 1:
			fragment = new SelectContacts();
			break;
		case 2:
		//	startActivity(new Intent(this, maps_google.class));
		//	fragment = new Complaint();
		//	fragment=new FbHistoryDisplay();		
			fragment = new Emergencymessage();
			break;
		case 3:
			startActivity(new Intent(this, maps_google.class));
			//fragment = new CommunityFragment();
			//fragment = new Whereami();
			break;
		case 4:
		//	fragment = new Facebookapp();
			break;
		case 5:
			fragment = new ChooseMedia();
			break;
			
		case 6:
			fragment = new Facebookapp();
			break; 
			
		case 7:
			fragment = new FbHistoryDisplay();
	//		fragment = new test_now();
			break; 
		case 8:
			fragment = new test_now();
	//		fragment = new setting();
			break;
			
		case 9:
			fragment = new setting();
			break;
			
		case 10:
			fragment = new Complaint();
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
