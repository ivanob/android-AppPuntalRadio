package com.ivanob.puntalradio;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

	private int[] tabNames = {R.string.portada_tab,
			R.string.parrilla_tab,
			R.string.programas_tab
		};
	private Context context;
	
    public AppSectionsPagerAdapter(FragmentManager fm, Context nContext) {
        super(fm);
        context = nContext;
    }

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PortadaFragment();
            case 1:
                return new ParrillaFragment();
            case 2:
            	return new ProgramasFragment();
            default:
            	return new PortadaFragment();
        }
    }


    public int getCount() {
        return 3;
    }


    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(tabNames[position]);
    }
}
