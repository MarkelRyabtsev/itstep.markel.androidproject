package com.example.markel.itstepandroidproject.View;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import com.example.markel.itstepandroidproject.Contracts.IImageView;
import com.example.markel.itstepandroidproject.Presenters.ImageActivityPresenter;
import com.example.markel.itstepandroidproject.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;

public class ImageActivity extends AppCompatActivity implements IImageView,
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener {

    private ImageActivityPresenter presenter;
    private CheckBox mCheckBoxChangeFilter;
    private CheckBox mCheckBoxChangeScaleType;
    private CheckBox mCheckBoxChangeImage;
    private Button mButtonConfirm;
    private ImageView mImageViewImage;

    private int[] myImageList = new int[]{R.drawable.tree_1, R.drawable.tree_2, R.drawable.tree_3,
            R.drawable.tree_4, R.drawable.tree_5, R.drawable.tree_6, R.drawable.tree_7, R.drawable.tree_8,
            R.drawable.tree_9, R.drawable.tree_10};
    private boolean changeFilter = false;
    private boolean changeScaleType = false;
    private boolean changeImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initViews();
        initListeners();
        presenter.initUI();
    }

    @Override
    public void initViews() {
        presenter = new ImageActivityPresenter(this);
        mCheckBoxChangeFilter = (CheckBox) findViewById(R.id.checkbox_imageactivity_changefilter);
        mCheckBoxChangeScaleType = (CheckBox) findViewById(R.id.checkbox_imageactivity_changescaletype);
        mCheckBoxChangeImage = (CheckBox) findViewById(R.id.checkbox_imageactivity_changeimage);
        mButtonConfirm = (Button) findViewById(R.id.button_imageactivity_confirm);
        mImageViewImage = (ImageView) findViewById(R.id.imageview_imageactivity_imagecontent);
    }

    @Override
    public void initListeners() {
        mCheckBoxChangeFilter.setOnCheckedChangeListener(this);
        mCheckBoxChangeScaleType.setOnCheckedChangeListener(this);
        mCheckBoxChangeImage.setOnCheckedChangeListener(this);
        mButtonConfirm.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkbox_imageactivity_changefilter:
                changeFilter = isChecked;
                break;
            case R.id.checkbox_imageactivity_changescaletype:
                changeScaleType = isChecked;
                break;
            case R.id.checkbox_imageactivity_changeimage:
                changeImage = isChecked;
                break;
        }
    }

    @Override
    public void onClick(View v) {
        presenter.imageHandler(changeFilter,changeScaleType,changeImage);
    }

    @Override
    public void setImage(Integer imageNumber){
        Picasso
                .get()
                .load(myImageList[imageNumber - 1])
                .into(mImageViewImage);
    }

    @Override
    public void changeFilter(Integer number) {
        switch (number){
            case 1:
                mImageViewImage.setColorFilter(R.color.color_blue_project, PorterDuff.Mode.ADD);
                break;
            case 2:
                mImageViewImage.setColorFilter(R.color.color_white_project, PorterDuff.Mode.ADD);
                break;
            case 3:
                mImageViewImage.setColorFilter(R.color.colorAccent, PorterDuff.Mode.ADD);
                break;
            case 4:
                mImageViewImage.setColorFilter(R.color.colorPrimary, PorterDuff.Mode.ADD);
                break;
            case 5:
                mImageViewImage.setColorFilter(R.color.colorPrimaryDark, PorterDuff.Mode.ADD);
                break;
            default:
                mImageViewImage.setColorFilter(null);
                break;
        }
    }

    @Override
    public void changeScaleType(Integer number) {
        switch (number){
            case 1:
                mImageViewImage.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case 2:
                mImageViewImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case 3:
                mImageViewImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case 4:
                mImageViewImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case 5:
                mImageViewImage.setScaleType(ImageView.ScaleType.FIT_END);
                break;
            case 6:
                mImageViewImage.setScaleType(ImageView.ScaleType.FIT_START);
                break;
            case 7:
                mImageViewImage.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case 8:
                mImageViewImage.setScaleType(ImageView.ScaleType.MATRIX);
                break;
            default:
                mImageViewImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
        }
    }
}
