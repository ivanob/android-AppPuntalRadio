package com.ivanob.puntalradio;

import java.util.HashMap;
import java.util.Map;

public class RadioProgram {
	private String nombre;
	private String ficheroDesc;
	private Map <String, String> media = new HashMap<String, String>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFicheroDesc() {
		return ficheroDesc;
	}

	public void setFicheroDesc(String ficheroDesc) {
		this.ficheroDesc = ficheroDesc;
	}
	
	public String getMediaURL(String service){
		return media.get(service);
	}
	
	public void addMediaURL(String service, String url){
		media.put(service,url);
	}
	
}
