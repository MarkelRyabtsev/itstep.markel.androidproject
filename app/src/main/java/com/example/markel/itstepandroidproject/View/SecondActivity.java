package com.example.markel.itstepandroidproject.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.example.markel.itstepandroidproject.Contracts.ISecondView;
import com.example.markel.itstepandroidproject.R;

public class SecondActivity extends AppCompatActivity implements ISecondView,
        CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener,
        View.OnClickListener{

    Switch mSwitchChangeEditTextInputType;
    EditText mEditTextСhangeableEditText;
    RadioGroup mRadioGroupEnterOptions;
    Button mButtonEnter;

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
        mSwitchChangeEditTextInputType = (Switch) findViewById(R.id.switchcompat_secondactivity_switchinputtypetext);
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
                // todo
                break;
            case R.id.radiobutton_secondactivity_gotoimageactivity:
                // todo
                break;
        }
    }

    private void changeInputType(boolean isChecked){

        if (!isChecked) {
            mEditTextСhangeableEditText.setText("");
            mEditTextСhangeableEditText.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            mEditTextСhangeableEditText.setText("");
            mEditTextСhangeableEditText.setInputType(InputType.TYPE_NUMBER_VARIATION_NORMAL);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_authorizationactivity_login:
                // todo
                break;
        }
    }
}
