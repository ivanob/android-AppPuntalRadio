package com.ivanob.puntalradio;


import com.actionbarsherlock.app.SherlockFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class PortadaFragment extends Fragment {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		return inflater.inflate(R.layout.portada_fragment, container, false);
	}
	
	public void onActivityCreated(Bundle savedInstanceState) {
		//Establezco los action para los botones social media
		//Listener del boton twitter
		ImageButton btnTwitter = (ImageButton) getView().findViewById(R.id.btnTwitter);
		btnTwitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String url = "https://twitter.com/PuntalRadio"; 
                Intent i = new Intent(Intent.ACTION_VIEW); 
                i.setData(Uri.parse(url)); 
                startActivity(i);
            }
        });
		//Listener del boton twitter
		ImageButton btnFacebook = (ImageButton) getView().findViewById(R.id.btnFacebook);
		btnFacebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String url = "https://www.facebook.com/puntalradio.puntal"; 
                Intent i = new Intent(Intent.ACTION_VIEW); 
                i.setData(Uri.parse(url)); 
                startActivity(i);
            }
        });
		//Listener del boton twitter
		ImageButton btnBlogger = (ImageButton) getView().findViewById(R.id.btnBlogger);
		btnBlogger.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String url = "http://puntalradio.blogspot.com.es/"; 
                Intent i = new Intent(Intent.ACTION_VIEW); 
                i.setData(Uri.parse(url)); 
                startActivity(i);
            }
        });
		//Listener del boton correo
		ImageButton btnCorreo = (ImageButton) getView().findViewById(R.id.btnEmail);
		btnCorreo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(Intent.ACTION_SEND);
            	i.setType("message/rfc822");
            	i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"puntalradio@puntalradio.com"});
            	//i.putExtra(Intent.EXTRA_SUBJECT, "titulo");
            	//i.putExtra(Intent.EXTRA_TEXT   , "mensaje");
            	try {
            	    startActivity(Intent.createChooser(i, "Enviando correo..."));
            	} catch (android.content.ActivityNotFoundException ex) {
            	    Toast.makeText(getActivity(), "No hay ningún cliente de correo instalado.", Toast.LENGTH_SHORT).show();
            	}
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
		
}
