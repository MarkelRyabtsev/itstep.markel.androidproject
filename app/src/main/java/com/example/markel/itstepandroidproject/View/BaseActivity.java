package com.example.markel.itstepandroidproject.View;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.example.markel.itstepandroidproject.R;

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbarBase;
    private TextView mTextViewToolbarTitle;

    public Toolbar getBaseToolbar(){
        return mToolbarBase;
    }

    public TextView getBaseTextViewTitle(){
        return mTextViewToolbarTitle;
    }

    public int getLayout(){
        return 0;//R.layout.activity_base;
    }

    public abstract BaseFragment onInitFragment();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){ getSupportFragmentManager().popBackStack(); }
        else{ finish(); }
    }

    public void initializeFragment(){
        if(getCurrentFragment() == null){
            displayFragment(onInitFragment());
        }
    }

    public void displayFragment(BaseFragment baseFragment){
        /*FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragmentManager.getBackStackEntryCount() > 0 && getCurrentFragment() != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if(fragmentManager.getBackStackEntryCount() > 0){
                fragmentTransaction.hide(getCurrentFragment());
            }

            fragmentTransaction.add(R.layout.base_fragment_container, baseFragment, baseFragment.getFragmentTag());
            fragmentTransaction.commit();
        }*/
    }

    private BaseFragment getCurrentFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        int entryCount = fragmentManager.getBackStackEntryCount();
        if(entryCount > 0){
            String fragmentTag = fragmentManager.getBackStackEntryAt(entryCount - 1).getName();
            return (BaseFragment) fragmentManager.findFragmentByTag(fragmentTag);
        }
        return null;
    }
}
