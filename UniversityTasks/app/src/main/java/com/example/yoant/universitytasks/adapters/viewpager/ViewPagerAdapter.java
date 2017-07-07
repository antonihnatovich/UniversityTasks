package com.example.yoant.universitytasks.adapters.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yoant.universitytasks.helper.Constant;
import com.example.yoant.universitytasks.view.fragments.CryptedFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final int pagesCount = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CryptedFragment.newInstance(Constant.algorithmFirstName);
            default:
                return CryptedFragment.newInstance(Constant.algorithmSecondName);
        }
    }

    @Override
    public int getCount() {
        return pagesCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return Constant.algorithmFirstName;
            default:
                return Constant.algorithmSecondName;
        }
    }
}
