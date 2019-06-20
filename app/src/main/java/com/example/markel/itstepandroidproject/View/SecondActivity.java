package com.example.markel.itstepandroidproject.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.example.markel.itstepandroidproject.Contracts.ISecondView;
import com.example.markel.itstepandroidproject.R;

public class SecondActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        ISecondView,
        RadioGroup.OnCheckedChangeListener {

    Switch mSwitchChangeVisibility;
    CheckBox mCheckBoxTextViewVisibility;
    RadioGroup mRadioGroupTextOption;
    TextView mTextViewTextPresentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        initListeners();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.switch_secondactivity_hideviews:
                startAnimation(isChecked);
                changeViewsVisibility(isChecked);
                break;
        }
    }

    @Override
    public void initViews() {
        mSwitchChangeVisibility = (Switch) findViewById(R.id.switch_secondactivity_hideviews);
        mCheckBoxTextViewVisibility = (CheckBox) findViewById(R.id.checkbox_secondactivity_denyhide);
        mRadioGroupTextOption = (RadioGroup) findViewById(R.id.radiogroup_secondactivity_textchooser);
        mTextViewTextPresentation = (TextView) findViewById(R.id.textview_secondactivity_presentationtext);
    }

    @Override
    public void initListeners() {
        mSwitchChangeVisibility.setOnCheckedChangeListener(this);
        mCheckBoxTextViewVisibility.setOnCheckedChangeListener(this);
        mRadioGroupTextOption.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radiobutton_secondactivity_happytext:
                mTextViewTextPresentation.setText(getString(R.string.secondactivity_happytext));
                break;
            case R.id.radiobutton_secondactivity_sadtext:
                mTextViewTextPresentation.setText(getString(R.string.secondactivity_sadtext));
                break;
            case R.id.radiobutton_secondactivity_glorytext:
                mTextViewTextPresentation.setText(getString(R.string.secondactivity_glorytext));
                break;
        }
    }

    @Override
    public Animation initAnimation(final boolean isChecked) {
        Animation goneAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_gone);
        goneAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changeViewsVisibility(isChecked);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return goneAnimation;
    }

    @Override
    public void startAnimation(boolean isChecked) {
        mRadioGroupTextOption.startAnimation(initAnimation(isChecked));
    }

    private void changeViewsVisibility(boolean isChecked){

        if (!isChecked) {
            if(mCheckBoxTextViewVisibility.isChecked()) return;
            mRadioGroupTextOption.setVisibility(View.VISIBLE);
            mCheckBoxTextViewVisibility.setVisibility(View.VISIBLE);
        } else {
            if(mCheckBoxTextViewVisibility.isChecked()) return;
            mRadioGroupTextOption.setVisibility(View.GONE);
            mCheckBoxTextViewVisibility.setVisibility(View.GONE);
        }
    }
}
