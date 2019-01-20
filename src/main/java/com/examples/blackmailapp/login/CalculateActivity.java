package com.examples.blackmailapp.login;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculateActivity extends Activity {

    private ImageView photograph2;
    private TextView insult;
    private TextView caloriesText;
    int calorie;
    String tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        calorie = (200+5*(int) Math.ceil(Math.random() * 100));
        tv = Integer.toString(calorie) + " Calories";



        initUI();

    }

    private void initUI(){
        photograph2 = (ImageView) findViewById(R.id.photographic);
        caloriesText = (TextView) findViewById(R.id.textViewCalories);
        insult = (TextView) findViewById(R.id.textViewInsult);

        photograph2.setImageURI(ImagePickerActivity.cabbage);
        insult.setText(CalorieCalculate());
        caloriesText.setText(tv);
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

}
