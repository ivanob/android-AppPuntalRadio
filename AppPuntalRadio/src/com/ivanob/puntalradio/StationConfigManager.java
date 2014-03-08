package com.ivanob.puntalradio;

public class StationConfigManager {
	
	private static StationConfigManager instance = null;
	
	public static StationConfigManager getInstance() {
		if(instance == null) {
			instance = new StationConfigManager();
		}
		return instance;
	}
	
	public String getStationURL(){
		return "http://5.39.76.68:8036/";
	}

}
