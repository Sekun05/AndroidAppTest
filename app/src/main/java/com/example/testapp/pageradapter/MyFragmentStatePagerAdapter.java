package com.example.testapp.pageradapter;


import com.example.testapp.Fragment0;
import com.example.testapp.Fragment1;
import com.example.testapp.Fragment2;

// import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
// import android.support.v4.app.FragmentManager;
import androidx.fragment.app.FragmentManager;
//import android.support.v4.app.FragmentStatePagerAdapter;
import  androidx.fragment.app.FragmentStatePagerAdapter;

public class MyFragmentStatePagerAdapter
        extends FragmentStatePagerAdapter {

    public MyFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch(i){
            case 0:
                return new Fragment0();
            case 1:
                return new Fragment1();
            default:
                return new Fragment2();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}