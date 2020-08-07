package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class mPagerAdapter extends FragmentStateAdapter {
    public mPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new PomodoroFragment();
//            case 1: return new ChartFragment();
            default: return new SettingsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
