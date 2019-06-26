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
        view.setImage(getRandomNumberForImage(1,10).toString());
    }

    private Integer getRandomNumberForImage(Integer min, Integer max){
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
