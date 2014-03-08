package com.ivanob.puntalradio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

    public AppSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PortadaFragment();
                    
            case 1:
                return new ParrillaFragment();

            default:
                return new ProgramasFragment();
        }
    }


    public int getCount() {
        return 3;
    }


    public CharSequence getPageTitle(int position) {
        return "Tab " + (position + 1);
    }
}
