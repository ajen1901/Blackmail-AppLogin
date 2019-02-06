package com.examples.blackmailapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.UserService;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;

public class CalculateActivity extends Activity {

    private ImageView photograph2;
    private TextView insult;
    private TextView caloriesText;
    private Button returnMain;
    int calorie;
    BackendlessUser currentUser;
    String tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        calorie = (200+5*(int) Math.ceil(Math.random() * 100));
        tv = Integer.toString(calorie);
        changeCalorie(currentUser); //need to find a way to get this to know who the current user is.


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
    private void changeCalorie(BackendlessUser user){
        Object totalCalories = user.getProperty("calories");
        String strudel = String.valueOf(totalCalories);
        int strudelCalories = Integer.valueOf(strudel);

        strudelCalories += calorie;
        strudel = String.valueOf(strudelCalories);
        user.setProperty("calories", strudel);

        Backendless.Persistence.save(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Toast.makeText(CalculateActivity.this, "Worked well?", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(CalculateActivity.this, "Unsuccessful update", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
