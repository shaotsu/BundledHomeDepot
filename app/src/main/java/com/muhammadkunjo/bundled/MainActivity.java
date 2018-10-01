package com.muhammadkunjo.bundled;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.muhammadkunjo.bundled.Adapters.ViewPagerAdapter;
import com.muhammadkunjo.bundled.Fragments.HomeFragment;
import com.muhammadkunjo.bundled.Fragments.NotificationsFragment;
import com.muhammadkunjo.bundled.Fragments.ProfileFragment;
import com.muhammadkunjo.bundled.Fragments.SearchFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager_title)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager vp;

    private int[] tabIcons = {
            R.drawable.ic_home,
            R.drawable.ic_search,
            R.drawable.ic_notification,
            R.drawable.ic_profile
    };

    private List<Pair<String, Fragment>> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentList.add(new Pair<String, Fragment>("Home", new HomeFragment()));
        fragmentList.add(new Pair<String, Fragment>("Search", new SearchFragment()));
        fragmentList.add(new Pair<String, Fragment>("Activity", new NotificationsFragment()));
        fragmentList.add(new Pair<String, Fragment>("Profile", new ProfileFragment()));


        ViewPagerAdapter adapter =
                new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);

        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);
        setupTabIcons();
    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
}
