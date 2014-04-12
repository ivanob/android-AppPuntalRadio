package com.ivanob.puntalradio;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;


public class ProgramasFragment extends Fragment{
	
	private RadioProgrammingManager progManager;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		progManager= RadioProgrammingManager.getInstance(this.getResources());
		return inflater.inflate(R.layout.programas_fragment, container, false);
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		/* Find Tablelayout defined in main.xml */
		TableLayout tl = (TableLayout) getView().findViewById(R.id.idTablaProgramas);
		
		/* Create a Button to be the row-content. */
		for(int i=0; i<progManager.getNumPrograms(); i++){
			RadioProgram prog = progManager.getProgram(i);
			/* Create a new row to be added. */
			/*TableRow tr = new TableRow(getActivity());
			TableLayout.LayoutParams tableRowParams=
					  new TableLayout.LayoutParams
					  (TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
			tableRowParams.setMargins(5, 5, 5, 5);
			tr.setLayoutParams(tableRowParams);
			TextView textView = new TextView(getActivity());
			textView.setText(prog.getNombre());
			//textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
			tr.addView(textView);
			if(prog.getMediaURL("facebook")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.facebook_64x64);
		        tr.addView(b1);
			}
			tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
		*/
			TableRow tr=new TableRow(getActivity());
			
			tr.setPadding(10, 10, 10, 10);
			TextView textView = new TextView(getActivity());
			textView.setText(prog.getNombre());
			textView.setTextSize(14);
			textView.setGravity(Gravity.CENTER_VERTICAL);
			tr.addView(textView);
			LinearLayout botonera = new LinearLayout(getActivity());
			if(prog.getMediaURL("facebook")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.facebook_64x64);
		        botonera.addView(b1);
			}
			if(prog.getMediaURL("podcast")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.blogger_64);
		        botonera.addView(b1);
			}
			if(prog.getMediaURL("blog")!=null){
				ImageButton b1 = new ImageButton(getActivity());
		        b1.setId(100 + i);
		        b1.setBackgroundColor(Color.TRANSPARENT);
		        b1.setImageResource(R.drawable.blogger_64);
		        botonera.addView(b1);
			}
			botonera.setPadding(0, 0, 0, 0);
			botonera.setGravity(Gravity.RIGHT);
			tr.addView(botonera);
			tl.addView(tr);
		}
//		Button b = new Button(getActivity());
//		b.setText("Dynamic Button");
//		b.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//		/* Add Button to row. */
//		tr.addView(b);
//		/* Add row to TableLayout. */
//		//tr.setBackgroundResource(R.drawable.sf_gradient_03);
//		tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
		super.onActivityCreated(savedInstanceState);
	}
}
