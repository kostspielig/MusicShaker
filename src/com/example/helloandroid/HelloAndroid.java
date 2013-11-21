package com.example.helloandroid;

import java.io.InputStream;
import java.util.Timer;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.PixelFormat; 
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


public class HelloAndroid extends Activity implements SensorEventListener{
	private static final String TAG = "musicShaker";
	private static final String isPlaying = "Playing Music"; 
	private static final String notPlaying = "Stopped Playing Music"; 

	static MediaPlayer mp = new MediaPlayer();

	private SensorManager mSensorManager;
	public float pitch;  
	public int lastID;


	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.v(TAG, "onCreate: ===> ");
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFormat(PixelFormat.TRANSPARENT);
		setContentView(R.layout.main); // From xml Description of UI

		//deviceSensor = new DeviceSensor(); // Implemnt!

		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensorManager.registerListener(this, mSensorManager
				.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_FASTEST);


		Timer timerUI = new Timer();
		UpdateUITask updateValuesTask = new UpdateUITask(this); // Implemnt!
		timerUI.schedule(updateValuesTask, 1000, 1000);
		Log.d("TSS", "Before calling function");
		//InputStream is = this.getResources().openRawResource(R.raw.b);
		lastID = 3;
		playSound(4);
	}

	/**
	 * Called when the accuracy of a sensor has changed.
	 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		synchronized(this){
			Log.d("MusicShaker","onAccuracyChanged: " + sensor + ", accuracy: " + accuracy);
		}
	}

	/**
	 * Called when sensor values have changed.
	 * values : Azimuth, Pitch, and Roll 
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized(this){
			Log.d("MusicShaker", "onSensorChanged: " + event.sensor + ", x: " + 
					event.values[0] + ", y: " + event.values[1] + ", z: " + event.values[2]);
			pitch = event.values[1];
			//Toast.makeText(getBaseContext(),"Orientation X: "+event.values[0]+ "Orientation Y: "+ event.values[1]+"Orientation Z: "+ event.values[2], Toast.LENGTH_LONG).show();

		}
	}

	@Override
	public void onPause() {
		super.onPause();
		mp.pause();
		mSensorManager.unregisterListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION));
		//timerUI.cancel();
		Toast.makeText(this, notPlaying, Toast.LENGTH_LONG).show();
	}

	public void playSound(int nSong) {
		if (nSong == lastID){//&& nSong == lastID){
			return;
		}
		else{
			lastID = nSong;
			mp.stop();
			if(nSong == 4){
				mp = MediaPlayer.create(this, R.raw.e);
				//Toast.makeText(this, "Twist and Shout" , Toast.LENGTH_LONG).show();
			}
			else if(nSong == 3){
				mp = MediaPlayer.create(this, R.raw.a);
				//Toast.makeText(this, "I saw her standing there" , Toast.LENGTH_LONG).show();
			}else if(nSong == 2){
				mp = MediaPlayer.create(this, R.raw.b);
				//Toast.makeText(this, "Please Please Me" , Toast.LENGTH_LONG).show();
			}else if(nSong == 1){
				mp = MediaPlayer.create(this, R.raw.c);
				//Toast.makeText(this, "Love Me Do" , Toast.LENGTH_LONG).show();
			}else if(nSong == 0){
				mp = MediaPlayer.create(this, R.raw.d);
				//Toast.makeText(this, "Baby It's You" , Toast.LENGTH_LONG).show();
			}
		}
		mp.start();
		Log.d("EUO","Just before calling the difficult pointttt");
	}



/*try{

    		switch (nSong){
    		case 0:
                mp = MediaPlayer.create(this, R.raw.b);
    			break;
    		case 1:
                mp = MediaPlayer.create(this, R.raw.a);
    			break;
    		case 2:
                mp = MediaPlayer.create(this, R.raw.c);
    			break;
    		case 3:
                mp = MediaPlayer.create(this, R.raw.d);
    			break;
    		case 4:
                mp = MediaPlayer.create(this, R.raw.e);
    			break;
    		default:
                mp = MediaPlayer.create(this, R.raw.c);
    			break;
    		}
    	} catch (Exception ex){
    		Log.d("main thread ex", ex.getStackTrace()[0].toString() + "path " );
    	}

    	mp.start();


        Toast.makeText(this, isPlaying, Toast.LENGTH_LONG).show();*/

    


    public void playSound2(int nSong) {
    	String path = "/sdcard/music/";
    	if (mp.isPlaying() ){//&& nSong == lastID){
    		return;
    	}
    	lastID = nSong;
    	Log.d("EUO","Just before calling the difficult pointttt");
    	try{
    		mp.reset();
    		switch (nSong){
    		case 0:
    			path += "a.mp3";
    			break;
    		case 1:
    			path += "b.mp3";
    			break;
    		case 2:
    			path += "c.mp3";
    			break;
    		case 3:
    			path += "d.mp3";
    			break;
    		case 4:
    			path += "e.mp3";
    			break;
    		default:
    			mp = MediaPlayer.create(this, R.raw.a);
    			break;
    		}
    		mp.setDataSource(path);
    		mp.prepare();
    		mp.start();
    	} catch (Exception ex){
    		Log.d("main thread ex", ex.getStackTrace()[0].toString() + "path " );
    	}

    	mp.start();


    	Toast.makeText(this, isPlaying, Toast.LENGTH_LONG).show();

    }
    void stopPlay() {
    	if (mp != null) {
    		mp.stop();
    		mp.release();
    	} 
    }

}
