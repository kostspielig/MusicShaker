package com.example.helloandroid;

import java.util.TimerTask;

import android.util.Log;

public class UpdateUITask extends TimerTask {

	HelloAndroid task;
	int id;
	public UpdateUITask(HelloAndroid hello)
	{
		task = hello;
	}

	//The task to run
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//task.onSensorChanged();
		Log.d("updateUITask","wowowowowoooo");
		float pitch = task.pitch;
		if(pitch<0 && pitch > -45){
			task.playSound(4);
		}
		if(pitch <= -45){
			task.playSound(3);
		}
		if(pitch>0 && pitch < 45){
			task.playSound(2);
		}
		if(pitch >= 45 && pitch < 70){
			task.playSound(1);
		}
		if(pitch > 70){
			task.playSound(0);
		}
		
		
		Log.d("Change sound", "pitch= " + pitch);
	/*	if (pitch <= 45 && pitch >= 0) {
			// mostly vertical
				
			task.playSound(4);
			Log.d("Change sound", "new sound 000; " + pitch);
		}else if (pitch <= 0 &&pitch >= -45){
			//task.playSound(3);
			//task.mp.stop();
			task.mp.reset();
			//task.playSound(3);
			Log.d("Change sound", "new sound 333; " + pitch);
		} else if (pitch < -45) {
			// mostly right side up
			//task.playSound(1);
			task.mp.reset();
			//task.playSound(1);
			//task.mp.pause();
			Log.d("Change sound", "new sound 111");
		} else if (pitch > 45) {
			// mostly left side up
			//task.playSound(2);
			//task.mp.pause();
			Log.d("Change sound", "new sound 222");
		}
		*/
	}
}
