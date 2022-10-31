package com.example.pupsismobile.ui.main;

import android.content.Context;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pupsismobile.AccountsFragment;
import com.example.pupsismobile.EnrollmentFragment;
import com.example.pupsismobile.FormsFragment;
import com.example.pupsismobile.GradesFragment;
import com.example.pupsismobile.HomeFragment;
import com.example.pupsismobile.R;
import com.example.pupsismobile.ScheduleFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]
            {R.string.homeFragment, R.string.enrollmentFragment, R.string.accountsFragment,
            R.string.scheduleFragment, R.string.gradesFragment, R.string.formsFragment};

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new EnrollmentFragment();
                break;
            case 2:
                fragment = new AccountsFragment();
                break;
            case 3:
                fragment = new ScheduleFragment();
                break;
            case 4:
                fragment = new GradesFragment();
                break;
            case 5:
                fragment = new FormsFragment();
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 6;
    }
}