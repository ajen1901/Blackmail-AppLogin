package com.examples.blackmailapp.login;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculateActivity extends Activity {

    private ImageView photograph2;
    private TextView insult;
    private TextView caloriesText;
    private Button returnMain;
    int calorie;
    String tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        calorie = (200+5*(int) Math.ceil(Math.random() * 100));
        tv = Integer.toString(calorie);

        initUI();
        initUIBehavior();

    }

    private void initUI(){
        photograph2 = (ImageView) findViewById(R.id.photographic);
        caloriesText = (TextView) findViewById(R.id.textViewCalories);
        insult = (TextView) findViewById(R.id.textViewInsult);
        returnMain = (Button) findViewById(R.id.buttonreturn);


        photograph2.setImageURI(ImagePickerActivity.cabbage);
        insult.setText(CalorieCalculate());
        caloriesText.setText(tv + " Calories");
    }
    private void initUIBehavior(){
       returnMain.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               mainReturn();
           }
       });
    }
    private String CalorieCalculate(){

        String actualInsult = "";
        if (calorie > 500) {
            actualInsult =("If you eat this your life expectancy will decrease by "+ calorie/70 +" days");
        }
        else if (calorie > 350) {
            actualInsult =("That's a bit much. Make sure you eat plenty of broccoli!");
        }
        else if (calorie >200) {
            actualInsult =("Excellent choice! Make sure to microwave for the best possible experience");
        }
        return actualInsult;
    }
    private void mainReturn(){
        startActivity(new Intent(this, LoginResult.class));
        ImagePickerActivity.orange = 0;
    }

}
