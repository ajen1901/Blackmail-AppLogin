package com.examples.blackmailapp.login;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class CalculateActivity extends Activity {

    private ImageView photograph2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);



        initUI();

    }

    private void initUI(){
        photograph2 = (ImageView) findViewById(R.id.photographic);

        photograph2.setImageURI(ImagePickerActivity.cabbage);
    }

}
