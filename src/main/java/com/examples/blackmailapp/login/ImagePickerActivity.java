package com.examples.blackmailapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.net.Uri;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.EditText;
import com.backendless.Backendless;


public class ImagePickerActivity extends Activity {

    private static final int PICK_IMAGE = 100;
    private ImageView imageView;
    private Button pickImageButton;
    private Button calculateButton;
    public static Uri cabbage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_picker);

        initUI();

    }
    private void initUI(){
        imageView = (ImageView) findViewById(R.id.image_view);
        pickImageButton = (Button) findViewById(R.id.pick_image_button);
        calculateButton = (Button) findViewById(R.id.buttonCalculator);

        pickImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnCalculatorStart();
            }
        });
    }

    private void openGallery() {
        Intent gallery =
                new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            cabbage = imageUri;
            imageView.setImageURI(cabbage);

        }
    }
    private void OnCalculatorStart(){
        startActivity( new Intent(this, CalculateActivity.class));
    }

}