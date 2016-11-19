package info.shadow.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Complaint extends Fragment{
public Complaint(){}
	EditText ime;
	ImageButton img;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.complaint, container, false);
         ime=(EditText)rootView.findViewById(R.id.editText1);
        
        img=(ImageButton)rootView.findViewById(R.id.imageButton1);
        img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ConnectToServer cs=new ConnectToServer();
				Log.d("Calling","serverFunction");
				final String imei= ime.getText().toString();
				Toast.makeText(getActivity().getApplicationContext(),"imei is:"+imei+"",Toast.LENGTH_LONG).show();
				cs.ComplaintUser(imei);
			}
		});
         
        return rootView;
    }

}
