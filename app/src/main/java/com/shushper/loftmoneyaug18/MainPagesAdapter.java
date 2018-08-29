package com.shushper.loftmoneyaug18;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainPagesAdapter extends FragmentPagerAdapter {

    private final static int PAGE_INCOMES = 0;
    private final static int PAGE_EXPENSES = 1;

    private final static int PAGES_COUNT = 2;

    private String[] pagesTitles;

    MainPagesAdapter(FragmentManager fm, Context context) {
        super(fm);

        pagesTitles = context.getResources().getStringArray(R.array.main_tabs);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case PAGE_INCOMES:
                return ItemsFragment.newInstance(ItemsFragment.TYPE_INCOMES);

            case PAGE_EXPENSES:
                return ItemsFragment.newInstance(ItemsFragment.TYPE_EXPENSES);

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return PAGES_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pagesTitles[position];
    }
}
