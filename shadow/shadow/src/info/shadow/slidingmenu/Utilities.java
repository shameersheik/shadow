package info.shadow.slidingmenu;

import android.util.Log;

public class Utilities {

	/**
	 * Function to convert milliseconds time to
	 * Timer Format
	 * Hours:Minutes:Seconds
	 * */
	public String milliSecondsToTimer(long milliseconds){
		String finalTimerString = "";
		String secondsString = "";

		// Convert total duration into time
		   int hours = (int)( milliseconds / (1000*60*60));
		   int minutes = (int)(milliseconds % (1000*60*60)) / (1000*60);
		   int seconds = (int) ((milliseconds % (1000*60*60)) % (1000*60) / 1000);
		   // Add hours if there
		   if(hours > 0){
			   finalTimerString = hours + ":";
		   }

		   // Prepending 0 to seconds if it is one digit
		   if(seconds < 10){
			   secondsString = "0" + seconds;
		   }else{
			   secondsString = "" + seconds;}

		   finalTimerString = finalTimerString + minutes + ":" + secondsString;

		// return timer string
		return finalTimerString;
	}

	/**
	 * Function to get Progress percentage
	 * @param currentDuration
	 * @param totalDuration
	 * */
	public int getProgressPercentage(long currentDuration, long totalDuration){
		Double percentage = (double) 0;
		Log.d("inside percentage",percentage+"");
		long currentSeconds = (int) (currentDuration / 1000);
		Log.d("inside current seconds",currentSeconds+"");
		
		long totalSeconds = (int) (totalDuration / 1000);
		Log.d("inside totalSeconds",totalSeconds+"");
		// calculating percentage
		percentage =(((double)currentSeconds)/totalSeconds)*100;
		Log.d("percentage",percentage+"");
		// return percentage
		return percentage.intValue();
	}

	public int progressToTimer(int progress, int totalDuration) {
		int currentDuration = 0;
		totalDuration = (int) (totalDuration / 1000);
		currentDuration = (int) ((((double)progress) / 100) * totalDuration);

		// return current duration in milliseconds
		return currentDuration * 1000;
	}
}