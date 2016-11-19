package info.shadow.slidingmenu;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class sendMessage extends Activity {
	TextView MessageToSend;
	EditText num;
	Button send_message;
	public String  sendMess(String Message,String number)
	{
		String status="";
		try
	{
		
		SmsManager sms=SmsManager.getDefault();
		//String mess=MessageToSend.getText().toString();
	sms.sendTextMessage(number, null,Message , null, null);
	 Toast.makeText(getApplicationContext(),
	          "Message Sent Sucessfully",
	          Toast.LENGTH_LONG).show();
	 status="true";
	      }
	      catch (Exception e) {
	    	  status="false";
	    	  Toast.makeText(getApplicationContext(),
	          "SMS faild, please try again.",
	          Toast.LENGTH_LONG).show();
	          e.printStackTrace();
	          
	       }
		return status;
	}
	public void onCreate(Bundle save)
	{
		super.onCreate(save);
		
		/*setContentView(R.layout.mesagesend);
		MessageToSend =(TextView)findViewById(R.id.messagesend);
		num=(EditText)findViewById(R.id.phonenum);
		send_message=(Button)findViewById(R.id.send);*/
		Bundle extras = getIntent().getExtras();
		//extras.getString("address");
		MessageToSend.setText(extras.getString("address"));
		send_message.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String phoneNo = num.getText().toString();
			      String message = MessageToSend.getText().toString();
			      try {
				SmsManager sms=SmsManager.getDefault();
				//String mess=MessageToSend.getText().toString();
			sms.sendTextMessage(phoneNo, null,message , null, null);
			 Toast.makeText(getApplicationContext(),
			          "Message Sent Sucessfully",
			          Toast.LENGTH_LONG).show();
			      }
			      catch (Exception e) {
			          Toast.makeText(getApplicationContext(),
			          "SMS faild, please try again.",
			          Toast.LENGTH_LONG).show();
			          e.printStackTrace();
			       }
				
				
			}
		});
		
	}
}
