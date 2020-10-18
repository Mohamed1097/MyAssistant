package com.example.myassistant.ui.main;

import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myassistant.NoteFragment;
import com.example.myassistant.PedometerFragment;
import com.example.myassistant.R;
import com.example.myassistant.SleepTrackerFragment;
import com.example.myassistant.TaskFragment;
import com.example.myassistant.WorkoutFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position)
        {
            case 0:
                return fragment=new NoteFragment();

            case 1:
                return fragment=new TaskFragment();
            case 2:
                return fragment=new SleepTrackerFragment();
            case 3:
                return fragment=new WorkoutFragment();
            case 4:
                return fragment=new PedometerFragment();

            default:
                return fragment;


        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}