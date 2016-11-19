package info.shadow.slidingmenu;



import java.io.IOException;

import info.shadow.slidingmenu.R;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ChooseMedia extends Fragment {
	TextView t1;
	ImageButton play;
	MediaPlayer objPlayer;
	MediaPlayer objPlayer1;
	public static final String audio = "audio key";
	 public static final String MyPREFERENCES = "MyPrefs" ;
	   SharedPreferences sharedpreferences;
	public ChooseMedia(){}
	int idimage=0;
	SeekBar songProgressBar;
	Handler mHandler = new Handler();
	Utilities utils=new Utilities();
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_media, container, false);
        final ListView songlist = (ListView) rootView.findViewById(R.id.listView1);
        t1=(TextView)rootView.findViewById(R.id.textView1);
        play=(ImageButton)rootView.findViewById(R.id.imageButton1);
        songProgressBar = (SeekBar) rootView.findViewById(R.id.songProgressBar);
    //    songProgressBar.setOnSeekBarChangeListener((OnSeekBarChangeListener)this); // Important
		objPlayer=new MediaPlayer();
        String[] songs = new String[] { "audio1", 
                "audio2",
                "audio3",
                "audio4",  
               };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_2, android.R.id.text1, songs);
        songlist.setAdapter(adapter); 
		songlist.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
				 String  itemValue    = (String) songlist.getItemAtPosition(position);
				 
				 t1.setText(itemValue);
				 sharedpreferences =getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

				   Editor editor = sharedpreferences.edit();
			       
			        editor.putString(audio,itemValue);
			        editor.commit(); 
			        Toast.makeText(getActivity().getApplicationContext(),sharedpreferences.getString(audio, ""), Toast.LENGTH_LONG).show();
				 
				 try{
					 if(itemValue=="audio1")
				 objPlayer = MediaPlayer.create(getActivity(),R.raw.audio1);
					 else if(itemValue=="audio2")
						 objPlayer = MediaPlayer.create(getActivity(),R.raw.audio2);
					 else if(itemValue=="audio3")
						 objPlayer = MediaPlayer.create(getActivity(),R.raw.audio3);
					 else if(itemValue=="audio4")
						 objPlayer = MediaPlayer.create(getActivity(),R.raw.audio4);
				 
				 objPlayer.start();
				 songProgressBar.setProgress(0);
					songProgressBar.setMax(100);
					updateProgressBar();
				    Log.d("LOGCAT", "Media Player started!");
				    if(objPlayer.isLooping() != true){
				        Log.d("LOGCAT", "Problem in Playing Audio");
				    }
				 play.setImageResource(R.drawable.pausebutton);
				 idimage=0;
				 Log.d("image", "changed");
					play.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							if (idimage==0)
							{
							 play.setImageResource(R.drawable.playbutton);
							 objPlayer.stop();
							 objPlayer.release();
							 idimage=1;
							 updateProgressBar();
							}
							else
							{
								play.setImageResource(R.drawable.pausebutton);
								objPlayer.start();
								idimage=0;
								updateProgressBar();
								
							}
							
						}
					});
				 }
				 catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} 

			}
		});
		         

		
        return rootView;
    }

		
	public void updateProgressBar() {
	    Log.d("updateprogressbar", "started");
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }	

	private Runnable mUpdateTimeTask = new Runnable() {
		   public void run() {
			    Log.d("run", "started");
			   long totalDuration = objPlayer.getDuration();
			   long currentDuration = objPlayer.getCurrentPosition();
			   // Updating progress bar
			   int progress;
			   progress=(utils.getProgressPercentage(currentDuration, totalDuration));
			   Log.d("progress",progress+"");
		//	   progress=50;
			   //Log.d("Progress", ""+progress);
			   songProgressBar.setProgress(progress);

			   // Running this thread after 100 milliseconds
		       mHandler.postDelayed(this, 100);
		   }
		};
		
		public void play(){
			//String song=t1.getText().toString();
		String 	song="audio3";
			objPlayer1=new MediaPlayer();
			if (song.equalsIgnoreCase("audio1")){
				objPlayer1 = MediaPlayer.create(getActivity(),R.raw.audio1);
			}
			else if (song.equalsIgnoreCase("audio2")){
				objPlayer1 = MediaPlayer.create(getActivity(),R.raw.audio2);
			}
			else if (song.equalsIgnoreCase("audio3")){
				objPlayer1 = MediaPlayer.create(getActivity(),R.raw.audio3);
			}
			else if (song.equalsIgnoreCase("audio4")){
				objPlayer1 = MediaPlayer.create(getActivity(),R.raw.audio4);
			}
			objPlayer1.start();
		}

//	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {

//	}

//	public void onStartTrackingTouch(SeekBar seekBar) {
		// remove message Handler from updating progress bar
//		mHandler.removeCallbacks(mUpdateTimeTask);
 //   }

/*	public void onStopTrackingTouch(SeekBar seekBar) {
		mHandler.removeCallbacks(mUpdateTimeTask);
		int totalDuration = objPlayer.getDuration();
		int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);

		// forward or backward to certain seconds
		objPlayer.seekTo(currentPosition);

		// update timer progress again
		updateProgressBar();
    }
    */


}

