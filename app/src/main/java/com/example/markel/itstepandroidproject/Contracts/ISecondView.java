package com.example.markel.itstepandroidproject.Contracts;

import android.view.animation.Animation;

public interface ISecondView extends IView {
    Animation initAnimation(boolean isChecked);
    void startAnimation(boolean isChecked);
}
