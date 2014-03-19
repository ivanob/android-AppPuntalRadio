package com.ivanob.puntalradio;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.Toast;

public class RadioManager {
	
	private StationConfigManager stationManager = StationConfigManager.getInstance();
	private static RadioManager instance = null;
	private MediaPlayer mp;
	private Context context;
	
	public static RadioManager getInstance(Context context) {
		if(instance == null) {
			instance = new RadioManager(context);
		}
		return instance;
	}
	

	private RadioManager(Context context){
		this.context=context;
		mp = new MediaPlayer();
		try {
        	mp.setDataSource(stationManager.getStationURL());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		mp.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                //playSeekBar.setSecondaryProgress(percent);
                //Log.i("Buffering", "" + percent);
            }
        });
        mp.prepareAsync();

        mp.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
            	resumePlayer();
            }
        });
	}
	
	public void pausePlayer(){
    	mp.pause();
    }
	
	public void resumePlayer(){
		mp.start();
		Toast.makeText(context, 
				context.getResources().getString(R.string.connected_msg),
				Toast.LENGTH_SHORT).show();
	}
	
	public void stopPlayer(){
		mp.stop();
		mp.release();
	}
}
