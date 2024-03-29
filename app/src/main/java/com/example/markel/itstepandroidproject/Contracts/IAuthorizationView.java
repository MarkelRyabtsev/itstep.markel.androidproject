package com.example.markel.itstepandroidproject.Contracts;

public interface IAuthorizationView extends IView {
    void setButtonEnterVisibility(boolean visibility);
    void showLoginMessageToast(AuthorizationResult result);
    void transitionSecondActivity();
    void shareAction();
    void imageCaptureAction();

    enum AuthorizationResult{
        NoError,
        WrongLogin,
        WrongPassword
    }
}
