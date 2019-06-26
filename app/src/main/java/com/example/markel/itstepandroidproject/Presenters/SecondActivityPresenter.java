package com.example.markel.itstepandroidproject.Presenters;

import com.example.markel.itstepandroidproject.Contracts.ISecondView;
import com.example.markel.itstepandroidproject.Contracts.IView;
import com.example.markel.itstepandroidproject.View.AuthorizationActivity;

public class SecondActivityPresenter implements IPresenter {

    private ISecondView view;

    public SecondActivityPresenter(ISecondView view){
        this.view = view;
    }

    @Override
    public void initUI() {

    }

    public void transitionActivityHandler(IView.MyActivities choosedActivity) {

        try {

            if (view != null) view.transitionActivityAction(Class.forName(choosedActivity.name()));
            else view.transitionActivityAction(AuthorizationActivity.class);

        }
        catch (ClassNotFoundException e){
            //todo log
        }
    }
}
