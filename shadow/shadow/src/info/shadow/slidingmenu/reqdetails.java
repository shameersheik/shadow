package info.shadow.slidingmenu;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings.Secure;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class reqdetails extends Activity {

	Button b1;
	TextView t1;
		protected static final int RESULT_LOAD_IMAGE = 1;
	String picturePath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	
	}
	
				// TODO Auto-generated method stub
				  
				
			
		
	
	   @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        super.onActivityResult(requestCode, resultCode, data);
	         
	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data)
	        {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	 
	            Cursor cursor = getContentResolver().query(selectedImage,
	                    filePathColumn, null, null, null);
	            cursor.moveToFirst();
	 
	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            picturePath = cursor.getString(columnIndex);
	            cursor.close();
	            
	            Log.d("path of the file ",picturePath);
	        }
	            //imageView = (ImageView) findViewById(R.id.imageView1);
	          //  imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	         
	           //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
	          
	         //  Toast.makeText(getApplication(),picturePath, Toast.LENGTH_LONG);
	        
	       
	   }
	public String connecttogallery()
	{
	Intent i = new Intent(
	                        Intent.ACTION_PICK,
	                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
	                 
	                startActivityForResult(i, RESULT_LOAD_IMAGE);
					Log.d("image file getted","imagefile");
					Log.d("returning file path",picturePath);
					return picturePath;
					
		
	}
	public String getfilepath()
	{
		return picturePath;
	}
	public String getimei()
	{
		final TelephonyManager  tm;
	tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		String deviceID=tm.getDeviceId().toString();
		return deviceID;
	}

	
	

}
