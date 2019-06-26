package com.example.markel.itstepandroidproject.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.example.markel.itstepandroidproject.Contracts.ISecondView;
import com.example.markel.itstepandroidproject.Presenters.SecondActivityPresenter;
import com.example.markel.itstepandroidproject.R;

public class SecondActivity extends AppCompatActivity implements ISecondView,
        CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener,
        View.OnClickListener{

    private SecondActivityPresenter presenter;
    private SwitchCompat mSwitchChangeEditTextInputType;
    private EditText mEditTextСhangeableEditText;
    private RadioGroup mRadioGroupEnterOptions;
    private Button mButtonEnter;

    private MyActivities choosedActivity = null;

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
            case R.id.switchcompat_secondactivity_switchinputtypetext:
                changeInputType(isChecked);
                break;
        }
    }

    @Override
    public void initViews() {
        presenter = new SecondActivityPresenter(this);
        mSwitchChangeEditTextInputType = (SwitchCompat) findViewById(R.id.switchcompat_secondactivity_switchinputtypetext);
        mEditTextСhangeableEditText = (EditText) findViewById(R.id.edittext_secondactivity_edittextwithinputtype);
        mRadioGroupEnterOptions = (RadioGroup) findViewById(R.id.radiogroup_secondactivity_activitychooser);
        mButtonEnter = (Button) findViewById(R.id.button_secondnactivity_enter);
    }

    @Override
    public void initListeners() {
        mSwitchChangeEditTextInputType.setOnCheckedChangeListener(this);
        mRadioGroupEnterOptions.setOnCheckedChangeListener(this);
        mButtonEnter.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.radiobutton_secondactivity_gotoauthorizationactivity:
                choosedActivity = MyActivities.AuthorizationActivity;
                break;
            case R.id.radiobutton_secondactivity_gotoimageactivity:
                choosedActivity = MyActivities.ImageActivity;
                break;
        }
    }

    private void changeInputType(boolean isChecked){

        if (!isChecked) {
            mEditTextСhangeableEditText.setText("");
            mEditTextСhangeableEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            mEditTextСhangeableEditText.setText("");
            mEditTextСhangeableEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_secondnactivity_enter:
                //presenter.transitionActivityHandler(choosedActivity);
                Intent intent = new Intent(this, AuthorizationActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void transitionActivityAction(Class activity) {
        Intent intent = new Intent(this, activity.getClass());
        startActivity(intent);
    }
}
