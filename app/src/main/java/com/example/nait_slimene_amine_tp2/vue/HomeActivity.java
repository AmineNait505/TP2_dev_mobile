package com.example.nait_slimene_amine_tp2.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nait_slimene_amine_tp2.R;
import com.example.nait_slimene_amine_tp2.controller.LoginController;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsultation;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loginController = LoginController.getInstance();
        loginController.recapUser(this);
        btnConsultation = findViewById(R.id.btnConsultation);
        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
