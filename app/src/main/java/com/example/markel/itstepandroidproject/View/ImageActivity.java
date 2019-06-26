package com.example.markel.itstepandroidproject.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        initViews();
        initListeners();
    }

    @Override
    public void initViews() {
        presenter = new ImageActivityPresenter(this);
        mCheckBoxChangeFilter = (CheckBox) findViewById(R.id.checkbox_imageactivity_changefilter);
        mCheckBoxChangeScaleType = (CheckBox) findViewById(R.id.checkbox_imageactivity_changescaletype);
        mCheckBoxChangeImage = (CheckBox) findViewById(R.id.checkbox_imageactivity_changescaletype);
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
                break;
            case R.id.checkbox_imageactivity_changescaletype:
                break;
            case R.id.checkbox_imageactivity_changeimage:
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void setImage(String imageName){
        Picasso
                .get()
                .load(getId(imageName, R.drawable.class))
                .into(mImageViewImage);
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}
