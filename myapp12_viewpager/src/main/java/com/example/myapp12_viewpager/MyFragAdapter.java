package com.example.myapp12_viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyFragAdapter extends FragmentStateAdapter {
    private int mCount;
    public MyFragAdapter(@NonNull FragmentActivity fragmentActivity,int count) {
        super(fragmentActivity);
        mCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index == 0) return new OneFragment();
        else if(index == 1) return new TwoFragment();
        else if(index==2)return  new ThreeFragment();
        else return new fourFragment();
    }

    @Override
    public int getItemCount() {
        return 200;
    }

    public int getRealPosition(int position){
        return position % mCount;
    }
}
