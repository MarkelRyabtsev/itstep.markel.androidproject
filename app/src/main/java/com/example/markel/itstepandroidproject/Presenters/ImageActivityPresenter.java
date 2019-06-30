package com.example.markel.itstepandroidproject.Presenters;

import com.example.markel.itstepandroidproject.Contracts.IImageView;

import java.util.Random;

public class ImageActivityPresenter implements IPresenter {

    private IImageView view;

    public ImageActivityPresenter(IImageView view){
        this.view = view;
    }

    @Override
    public void initUI() {
        view.setImage(getRandomNumberForImage(1,10));
    }

    private Integer getRandomNumberForImage(Integer min, Integer max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void imageHandler(boolean changeFilter, boolean changeScaleType, boolean changeImage){
        if (changeFilter) {view.changeFilter(getRandomNumberForImage(1,5));} else {view.changeFilter(-1);}
        if (changeScaleType) { view.changeScaleType(getRandomNumberForImage(1,8));} else {view.changeScaleType(-1);}
        if (changeImage) { view.setImage(getRandomNumberForImage(1,10));}
    }
}
