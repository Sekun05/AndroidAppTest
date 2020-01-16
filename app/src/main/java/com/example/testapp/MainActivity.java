package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import com.example.testapp.pageradapter.MyFragmentStatePagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private final String preName = "MAIN_SETTING";
    private android.content.SharedPreferences sharedPreferences;
    private android.content.SharedPreferences.Editor edit;
    private android.widget.TextView text1;

    ViewPager viewPager;
    WormDotsIndicator wormDotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);  //superコールの前にスタイル設定 (LauncherScreenを入れたので)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 初回起動検知
        sharedPreferences = getSharedPreferences(preName, MODE_PRIVATE);
        edit = sharedPreferences.edit();
        Boolean isFirst = sharedPreferences.getBoolean("firstTime", true);
        // text1 = findViewById(R.id.textView3);
        if(!isFirst){
            wormDotsIndicator = findViewById(R.id.indicator);
            wormDotsIndicator.setVisibility(View.GONE);
        }
        if(isFirst) {
            wormDotsIndicator = findViewById(R.id.indicator);
            viewPager = findViewById(R.id.pager);
            viewPager.setAdapter(new MyFragmentStatePagerAdapter(getSupportFragmentManager()));
            wormDotsIndicator.setViewPager(viewPager);
        }
    }

    public void End_Tutorial () {
        edit.putBoolean("firstTime", false).apply();
        viewPager.setVisibility(View.GONE);
        wormDotsIndicator.setVisibility(View.GONE);
        return ;
    }
}