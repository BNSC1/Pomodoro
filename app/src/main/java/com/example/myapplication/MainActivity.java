package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2=findViewById(R.id.viewPager);
        viewPager2.setAdapter(new mPagerAdapter(this));
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(
                tabLayout,viewPager2,new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){

                switch(position){
                    case 0: {tab.setText("Pomodoro"); tab.setIcon(R.drawable.ic_pomodoro); break;}
                    case 1: {tab.setText("Chart"); tab.setIcon(R.drawable.ic_chart);
                        BadgeDrawable badgeDrawable=tab.getOrCreateBadge();
                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
                        badgeDrawable.setVisible(true); badgeDrawable.setNumber(100); badgeDrawable.setMaxCharacterCount(3);
                        break;}
                    case 2: {tab.setText("Settings"); tab.setIcon(R.drawable.ic_settings); break;}
                }
            }
        });
        tabLayoutMediator.attach();
    }
}
