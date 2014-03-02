package com.ivanob.puntalradio;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	
	public MenuItem playMenu;
	private boolean isPlaying;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// setup action bar for tabs
	    ActionBar actionBar = getSupportActionBar();
	    actionBar.setSubtitle("tu emisora online");
	    actionBar.setTitle("Puntal Radio"); 
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);

	    Tab tab = actionBar.newTab()
	                       .setText(R.string.portada_tab)
	                       .setTabListener(new TabListener<PortadaFragment>(
	                               this, "portada", PortadaFragment.class));
	    actionBar.addTab(tab);

	    tab = actionBar.newTab()
                .setText(R.string.parrilla_tab)
                .setTabListener(new TabListener<ParrillaFragment>(
                        this, "parrilla", ParrillaFragment.class));
	    actionBar.addTab(tab);
 
	    tab = actionBar.newTab()
	                   .setText(R.string.programas_tab)
	                   .setTabListener(new TabListener<ProgramasFragment>(
	                           this, "programas", ProgramasFragment.class));
	    actionBar.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    playMenu = menu.findItem(R.id.action_playstop);
	    isPlaying=true;
	    return super.onCreateOptionsMenu(menu);
	}
	
	private void switchPlaystopButton(){
		if(isPlaying){ //It is playing
			playMenu.setIcon(R.drawable.ic_action_pause_over_video);
			isPlaying=false;
		}else{ //It is stopped
			playMenu.setIcon(R.drawable.ic_action_play_over_video);
			isPlaying=true;
		}
	}
	
	//To handle the action buttons
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_playstop:
	        	switchPlaystopButton();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
