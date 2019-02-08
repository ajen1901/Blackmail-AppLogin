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
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;


public class ImagePickerActivity extends Activity {

    private static final int PICK_IMAGE = 100;
    private ImageView imageView;
    private Button pickImageButton;
    private static Button calculateButton;
    public static Uri cabbage;
    public static int orange = 0;

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
                orange = 1;
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orange == 1){
                    OnCalculatorStart();
                }else{
                    showAlertDialog();
                }
            }
        });
    }

    private void openGallery() {
        Intent gallery =
                new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
        orange = 1;
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
        Intent intent = new Intent(this, CalculateActivity.class);
        intent.putExtra("objectId", getIntent().getStringExtra("objectId"));
        intent.putExtra("user", getIntent().getStringExtra("user"));
        startActivity(intent);
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Photo Selected");
            builder.setCancelable(false);
            builder.setMessage("Please Select a photo to calculate calories.");
            builder.setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(ImagePickerActivity.this, "Please Select a photo to calculate calories.", Toast.LENGTH_SHORT).show();
                    dialogInterface.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
    }

}