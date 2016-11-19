package info.shadow.slidingmenu;

import android.R.color;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FbHistoryDisplay extends Fragment {
	String message;
	public FbHistoryDisplay(){}
	TextView t1,t2,t3,t4,t5;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_fbhistory, container, false);
         t1=(TextView)rootView.findViewById(R.id.textView1);
         t2=(TextView)rootView.findViewById(R.id.textView2);
         t3=(TextView)rootView.findViewById(R.id.textView3);
         t4=(TextView)rootView.findViewById(R.id.textView4);
         t5=(TextView)rootView.findViewById(R.id.textView5);
         
         ConnectToServer cs=new ConnectToServer();
      //   String messagecontent=cs.retrivefbhistory("uid");
         String uid="532f822d475c3";
         message=cs.getfbMessage(uid);
          message="1)Lattitude=28.649081:Longitude=77.19903440000007\nI am in Danger please help!!!!!\ni am at https://www.google.com/maps/search/police+station+near+28.649081,77.19903440000007 \ni am at address:Desh Bandhu Gupta Road, Block A, Karol Bagh, New Delhi, Delhi 110005,India ";
         t1.setText(message);
         message="2)Lattitude=28.649081:Longitude=77.19903440000007 \n I am in Danger please help\n i am at  https://www.google.com/maps/search/police+station+near+28.649081,77.19903440000007 \n i am at address:Desh Bandhu Gupta Road, Block A, Karol Bagh, New Delhi, Delhi 110005, India";
         t2.setText(message);
         t1.setVisibility(View.VISIBLE);
         t2.setVisibility(View.VISIBLE);
         t3.setVisibility(View.GONE);
         t4.setVisibility(View.GONE);
         t5.setVisibility(View.GONE);
         
         t1.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	Toast.makeText(getActivity(), "insidet1",Toast.LENGTH_SHORT).show();
				t1.setBackgroundColor(Color.BLACK);
				t1.setTextColor(Color.WHITE);
				t2.setBackgroundColor(Color.WHITE);
				t2.setTextColor(Color.BLACK);
			}
        	 
         });

         t2.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	Toast.makeText(getActivity(), "insidet2",Toast.LENGTH_SHORT).show();
				t2.setBackgroundColor(Color.BLACK);
				t2.setTextColor(Color.WHITE);
				t1.setBackgroundColor(Color.WHITE);
				t1.setTextColor(Color.BLACK);			}
        	 
         });
         
        return rootView;
    }
}
