package com.ivanob.puntalradio;

import java.util.TimerTask;

public class TimerSleepMode extends TimerTask {

	MainActivity main;
	
	public TimerSleepMode(MainActivity m){
		main = m;
	}
	
	public void run() {
		main.closeApp();
	}

}
