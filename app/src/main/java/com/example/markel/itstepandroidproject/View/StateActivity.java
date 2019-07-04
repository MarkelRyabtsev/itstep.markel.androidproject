package com.example.markel.itstepandroidproject.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.markel.itstepandroidproject.Contracts.IStateView;
import com.example.markel.itstepandroidproject.R;

public class StateActivity extends AppCompatActivity implements IStateView {

    private TextView mTextViewContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_state);

        initViews();

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            mTextViewContent.setText(extras.getString("message"));
        }
    }

    @Override
    public void initViews() {
        mTextViewContent = (TextView) findViewById(R.id.textview_stateactivity_message);
    }

    @Override
    public void initListeners() {

    }
}
