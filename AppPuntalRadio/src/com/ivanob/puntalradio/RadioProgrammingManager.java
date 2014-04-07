package com.ivanob.puntalradio;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;

public class RadioProgrammingManager {

	private static RadioProgrammingManager instance = null;
	private LinkedList<RadioProgram> listPrograms;
	private Resources res;
	
	public int getNumPrograms(){
		return listPrograms.size();
	}
	
	public RadioProgram getProgram(int pos){
		return listPrograms.get(pos);
	}
	
	public static RadioProgrammingManager getInstance(Resources res) {
		if(instance == null) {
			instance = new RadioProgrammingManager(res);
		}
		return instance;
	}
	
	private RadioProgrammingManager(Resources res){
		this.res = res;
		listPrograms = new LinkedList<RadioProgram>();
		readXMLProgramming();
	}

	private void readXMLProgramming() {
		try {
			XmlResourceParser xpp=res.getXml(R.xml.programacion);
		    
		    parsePrograms(xpp);

	    } catch (Exception e) {
			e.printStackTrace();
	    }
	}

	private LinkedList<RadioProgram> parsePrograms(XmlResourceParser xpp) throws XmlPullParserException, IOException {
		int eventType = xpp.getEventType();
		String text=null;
		RadioProgram program = new RadioProgram();
		while(eventType != XmlPullParser.END_DOCUMENT){
			String tagname = xpp.getName();
			switch(eventType){	
				case XmlPullParser.START_TAG:
					if(tagname.equalsIgnoreCase("programa")){
						program = new RadioProgram();
						String progName=xpp.getAttributeValue(null, "nombre");
						program.setNombre(progName);
					}
					break;
				case XmlPullParser.TEXT:
                    text = xpp.getText();
                    break;
				case XmlPullParser.END_TAG:
					if (tagname.equalsIgnoreCase("programa")) {
                        // add employee object to list
                        //employees.add(employee);
						listPrograms.add(program);
                    }else if (tagname.equalsIgnoreCase("podcast")) {
                        String s = text;
                    	int a=3;
                    }else if (tagname.equalsIgnoreCase("facebook")) {
                        //employee.setName(text);
                    	String s = text;
                    	int a=3;
                    }  
					break;
					
			}
			eventType = xpp.next();
		}
		return null;
	}
	
	public RadioProgram getProgramDetails(String programName){
		return null;
	}
}
