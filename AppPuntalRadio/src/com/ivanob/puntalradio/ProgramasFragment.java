package com.ivanob.puntalradio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
		/* Create a new row to be added. */
		TableRow tr = new TableRow(getActivity());
		tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		/* Create a Button to be the row-content. */
		TextView textView = new TextView(getActivity());
		textView.setText(progManager.getProgram(0).getNombre());
		textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		tr.addView(textView);
		tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
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
