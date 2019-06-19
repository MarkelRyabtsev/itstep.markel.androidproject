package com.example.markel.itstepandroidproject.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.markel.itstepandroidproject.Contracts.IAuthorizationView;
import com.example.markel.itstepandroidproject.Contracts.IView;
import com.example.markel.itstepandroidproject.Presenters.AuthorizationActivityPresenter;
import com.example.markel.itstepandroidproject.R;

import static com.example.markel.itstepandroidproject.Contracts.IAuthorizationView.AuthorizationResult.NoError;

public class AuthorizationActivity extends AppCompatActivity implements IAuthorizationView, View.OnClickListener {

    private AuthorizationActivityPresenter presenter;
    private EditText mEditTextLogin;
    private EditText mEditTextPassword;
    private Button mButtonEnter;
    private Button mButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        initViews();
        initListeners();

        presenter.initUI();
    }

    @Override
    public void initViews() {
        presenter = new AuthorizationActivityPresenter(this);
        mEditTextLogin = (EditText) findViewById(R.id.edittext_authorizationactivity_login);
        mEditTextPassword = (EditText) findViewById(R.id.edittext_authorizationactivity_password);
        mButtonEnter = (Button) findViewById(R.id.button_authorizationactivity_login);
        mButtonShare = (Button) findViewById(R.id.button_authorizationactivity_share);
    }

    @Override
    public void initListeners(){
        mEditTextLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setButtonEnterVisibility(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.setButtonEnterVisibility(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
            }
        });

        mEditTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.setButtonEnterVisibility(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.setButtonEnterVisibility(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
            }
        });

        mButtonEnter.setOnClickListener(this);
        mButtonShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_authorizationactivity_login:
                presenter.attemptLogin(mEditTextLogin.getText().toString(), mEditTextPassword.getText().toString());
                break;
            case R.id.button_authorizationactivity_share:
                shareAction();
                break;
        }
    }

    public void setButtonEnterVisibility(boolean visibility){
        mButtonEnter.setEnabled(visibility);
    }

    @Override
    public void showLoginMessageToast(AuthorizationResult result) {
        switch (result) {
            case NoError:
                Toast.makeText(this, R.string.authorizationactivity_success, Toast.LENGTH_LONG).show();
                transitionSecondActivity();
                break;
            case WrongLogin:
                Toast.makeText(this, R.string.authorizationactivity_wronglogin, Toast.LENGTH_LONG).show();
                break;
            case WrongPassword:
                Toast.makeText(this, R.string.authorizationactivity_wrongpassword, Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void transitionSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void shareAction(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "TITLE");
        intent.putExtra(Intent.EXTRA_TEXT, "Message");
        startActivity(Intent.createChooser(intent, "Поделиться"));
    }
}
