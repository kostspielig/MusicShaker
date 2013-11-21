package com.example.helloandroid;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.content.Context;

public class DeviceSensor implements SensorEventListener {

    TextView xView = null;
    TextView yView = null;
    TextView zView = null;
    

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
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		synchronized(this){
        Log.d("MusicShaker", "onSensorChanged: " + event.sensor + ", x: " + 
            event.values[0] + ", y: " + event.values[1] + ", z: " + event.values[2]);
        

		}
		
	}

}
