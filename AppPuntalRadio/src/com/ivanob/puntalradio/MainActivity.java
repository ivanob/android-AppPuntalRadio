package com.ivanob.puntalradio;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;

public class MainActivity extends SherlockFragmentActivity implements TabListener {
	
	public MenuItem playMenu;
	private boolean isPlaying;
	AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	ViewPager mViewPager;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// setup action bar for tabs
	    final ActionBar actionBar = getSupportActionBar();
	    actionBar.setSubtitle("tu emisora online");
	    actionBar.setTitle("Puntal Radio"); 
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);

	    mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
	    mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.
                actionBar.setSelectedNavigationItem(position);
            }
        });
        
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
	    
	    /*
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
	    actionBar.addTab(tab);*/
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    playMenu = menu.findItem(R.id.action_playstop);
	    isPlaying=true;
	    return super.onCreateOptionsMenu(menu);
	}*/
	
	private void switchPlaystopButton(){
		if(isPlaying){ //It is playing
			playMenu.setIcon(R.drawable.ic_action_pause_over_video);
			isPlaying=false;
		}else{ //It is stopped
			playMenu.setIcon(R.drawable.ic_action_play_over_video);
			isPlaying=true;
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	/*//To handle the action buttons
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_playstop:
	        	switchPlaystopButton();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}*/

}
