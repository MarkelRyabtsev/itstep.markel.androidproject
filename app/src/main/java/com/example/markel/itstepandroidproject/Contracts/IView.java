package com.example.markel.itstepandroidproject.Contracts;

public interface IView {
    void initViews();
    void initListeners();

    enum MyActivities{
        AuthorizationActivity,
        SecondActivity,
        ImageActivity
    }
}
