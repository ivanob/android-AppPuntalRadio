package com.ivanob.puntalradio;


import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PortadaFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		return inflater.inflate(R.layout.portada_fragment, container, false);
	}
}
