package com.ivanob.puntalradio;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.ivanob.puntalradio.model.RadioProgram;
import com.ivanob.puntalradio.model.RadioProgrammingManager;


public class ProgramasFragment extends Fragment{
	
	private RadioProgrammingManager progManager;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		progManager= RadioProgrammingManager.getInstance(this.getResources());
		return inflater.inflate(R.layout.programas_fragment, container, false);
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		/* Find Tablelayout defined in main.xml */
		TableLayout tl=(TableLayout)getActivity().findViewById(R.id.idTablaProgramas); 
		tl.setColumnStretchable(1, true); //Importante para hacer la separacion de columnas
		tl.setColumnStretchable(2, true);
		tl.setColumnStretchable(3, true);
		tl.setColumnStretchable(4, true);
		
		/* Create a Button to be the row-content. */
		for(int i=0; i<progManager.getNumPrograms(); i++){
			final RadioProgram prog = progManager.getProgram(i);
			TableRow tr = new TableRow(getActivity());
			tr.setPadding(10, 10, 10, 10);
			tr.setGravity(Gravity.CENTER_VERTICAL);
			
			//Add the label with the name of the program
			TextView nombreProg = new TextView(getActivity());
			nombreProg.setText(prog.getNombre());
			//textView.setTextSize(14);
			nombreProg.setTextAppearance(getActivity(), R.style.boldText);
			//nombreProg.setBackgroundResource(R.color.highlightedTextViewColor);
			tr.addView(nombreProg);
			
			final int j=i;
			nombreProg.setOnClickListener(new OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	RadioProgram prog = progManager.getProgram(j);
	            	try {
	            		//Load the extra info of the program
						progManager.loadProgramDetails(prog, getActivity());
					} catch (XmlPullParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	ProgramInfoDialog infoPanel = new ProgramInfoDialog(getActivity(), prog);
	            	infoPanel.setTitle(prog.getNombre());
	            	infoPanel.show();
	            }
	        });
			
			//LinearLayout botonera = new LinearLayout(getActivity());
			//botonera.setPadding(0,0,0,0);
			//Add the buttons of the media corresponding a program
			if(prog.getMediaURL("facebook")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.facebook_64x64);
		        b1.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View v) {
		            	String url = prog.getMediaURL("facebook"); 
		                Intent i = new Intent(Intent.ACTION_VIEW); 
		                i.setData(Uri.parse(url)); 
		                startActivity(i);
		            }
		        });
		        tr.addView(b1);
			}
			if(prog.getMediaURL("podcast")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.ivoox_64);
		        b1.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View v) {
		            	String url = prog.getMediaURL("podcast"); 
		                Intent i = new Intent(Intent.ACTION_VIEW); 
		                i.setData(Uri.parse(url)); 
		                startActivity(i);
		            }
		        });
		        tr.addView(b1);
			}
			if(prog.getMediaURL("blog")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.blogger_64);
		        b1.setOnClickListener(new View.OnClickListener() {
		            public void onClick(View v) {
		            	String url = prog.getMediaURL("blog"); 
		                Intent i = new Intent(Intent.ACTION_VIEW); 
		                i.setData(Uri.parse(url)); 
		                startActivity(i);
		            }
		        });
		        tr.addView(b1);
			}
			//botonera.setGravity(Gravity.CENTER_VERTICAL);
			//tr.addView(botonera);
			if(prog.getNumMediaURL()==0){ //Si no tiene accesos directos, le pongo un tamanio minimo
				tr.setMinimumHeight(65);
			}
			tl.addView(tr); //Add the row to the table
			
			if(i!=progManager.getNumPrograms()-1){
				tl.addView(createBlackSeparator());
			}
		}
		
		super.onActivityCreated(savedInstanceState);
	}
	
	private View createBlackSeparator(){
		View v = new View(getActivity());
		v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, 1));
		v.setBackgroundColor(Color.rgb(51, 51, 51));
		return v;
	}
	
}
