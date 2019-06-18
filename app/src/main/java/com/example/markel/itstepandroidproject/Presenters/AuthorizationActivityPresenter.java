package com.example.markel.itstepandroidproject.Presenters;

import com.example.markel.itstepandroidproject.Contracts.IAuthorizationView;

public class AuthorizationActivityPresenter implements IPresenter {

    private IAuthorizationView view;
    private final String LOGIN = "admin";
    private final String PASSWORD = "admin";

    public AuthorizationActivityPresenter(IAuthorizationView view){
        this.view = view;
    }

    @Override
    public void initUI() {
        view.setButtonEnterVisibility(false);
    }

    public void setButtonEnterVisibility(String login, String password){
        if(!login.isEmpty() && !password.isEmpty())
            view.setButtonEnterVisibility(true);
        else
            view.setButtonEnterVisibility(false);
    }

    public void attemptLogin(String login, String password){

        if (login.equals(LOGIN) && password.equals(PASSWORD))
            view.showLoginMessageToast(IAuthorizationView.AuthorizationResult.NoError);
        else if (login.equals(LOGIN) && !password.equals(PASSWORD))
            view.showLoginMessageToast(IAuthorizationView.AuthorizationResult.WrongPassword);
        else
            view.showLoginMessageToast(IAuthorizationView.AuthorizationResult.WrongLogin);
    }
}
