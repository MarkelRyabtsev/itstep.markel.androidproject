package com.example.markel.itstepandroidproject.Presenters;

import com.example.markel.itstepandroidproject.Contracts.ISecondView;
import com.example.markel.itstepandroidproject.Contracts.IView;
import com.example.markel.itstepandroidproject.View.*;

public class SecondActivityPresenter implements IPresenter {

    private ISecondView view;

    public SecondActivityPresenter(ISecondView view){
        this.view = view;
    }

    @Override
    public void initUI() {

    }

    public void transitionActivityHandler(IView.MyActivities choosedActivity) {

        if (view == null) return;
        Class activityClass = null;

        switch (choosedActivity) {
            case AuthorizationActivity:
                activityClass = AuthorizationActivity.class;
                break;
            case SecondActivity:
                activityClass = SecondActivity.class;
                break;
            case ImageActivity:
                activityClass = ImageActivity.class;
                break;
            default:
                break;
        }
        view.transitionActivityAction(activityClass);
    }
}
