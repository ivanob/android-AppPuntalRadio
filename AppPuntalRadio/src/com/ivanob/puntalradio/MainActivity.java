package com.ivanob.puntalradio;

import java.io.IOException;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.MenuInflater;

public class MainActivity extends SherlockFragmentActivity implements TabListener {
	
	public MenuItem playMenu;
	private boolean isPlaying;
	private AppSectionsPagerAdapter mAppSectionsPagerAdapter;
	private ViewPager mViewPager;
	private StationConfigManager stationManager = StationConfigManager.getInstance();
	private MediaPlayer mp;
	
	private void configMediaPlayer(){
		mp = new MediaPlayer();
		try {
        	mp.setDataSource(stationManager.getStationURL());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		mp.setOnBufferingUpdateListener(new OnBufferingUpdateListener() {

            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                //playSeekBar.setSecondaryProgress(percent);
                //Log.i("Buffering", "" + percent);
            }
        });
        mp.prepareAsync();

        mp.setOnPreparedListener(new OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
            	resumePlayer();
            }
        });
	}
	
	private void stopPlayer(){
    	mp.pause();
    	//mp.release();
    }
	
	private void resumePlayer(){
		mp.start();
		Toast.makeText(getApplicationContext(), "Conectado a Puntal Radio", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		configMediaPlayer();
		
		// setup action bar for tabs
	    final ActionBar actionBar = getSupportActionBar();
	    actionBar.setSubtitle("tu emisora online");
	    actionBar.setTitle("Puntal Radio"); 
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    actionBar.setDisplayShowTitleEnabled(true);

	    mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager(), this.getApplicationContext());
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
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, (com.actionbarsherlock.view.Menu) menu);
	    playMenu = menu.findItem(R.id.action_playstop);
	    isPlaying=true;
	    return super.onCreateOptionsMenu(menu);
	}
	
	private void switchPlaystopButton(){
		if(isPlaying){ //It is playing, so I have to stop it
			playMenu.setIcon(R.drawable.ic_action_play_over_video);
			isPlaying=false;
			stopPlayer();
		}else{ //It is stopped, so I have to play it
			playMenu.setIcon(R.drawable.ic_action_pause_over_video);
			isPlaying=true;
			resumePlayer();
		}
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mViewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
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
