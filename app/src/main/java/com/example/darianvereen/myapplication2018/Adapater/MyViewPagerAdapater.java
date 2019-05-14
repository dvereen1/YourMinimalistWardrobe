package com.example.darianvereen.myapplication2018.Adapater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.darianvereen.myapplication2018.Fragment.ClosetFragment;
import com.example.darianvereen.myapplication2018.Fragment.PantsFragment;
import com.example.darianvereen.myapplication2018.Fragment.ShirtsFragment;
import com.example.darianvereen.myapplication2018.Fragment.ShoesFragment;

public class MyViewPagerAdapater extends FragmentStatePagerAdapter{

    //Will eventually pass in data to the constructor
    public MyViewPagerAdapater(FragmentManager fm) {
        super(fm);
    }

    //GETS THE PAGE WE WANT TO DISPLAY in this case CLOSET FRAGMENT
    //We can display different Fragments by referenceing the position
    //we just need to return a different Fragment for each position
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        switch (position){
            case 0:
                return new ClosetFragment();
            case 1:
                return new ShirtsFragment();
            case 2:
                return new PantsFragment();
            case 3:
                return new ShoesFragment();
        }
        return new ClosetFragment();
    }

    //Number of pages we want to display
    @Override
    public int getCount() {
        return 4;
    }
}
