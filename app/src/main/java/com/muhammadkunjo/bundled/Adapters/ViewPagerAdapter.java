package com.muhammadkunjo.bundled.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Pair;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    private List<Pair<String, Fragment>> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<Pair<String, Fragment>> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position).second;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return fragmentList.get(position).first;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
