package com.example.nait_slimene_amine_tp2.vue;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.nait_slimene_amine_tp2.R;


public class ConsultActivity extends AppCompatActivity {

    private Button btnReturn;
    private TextView tvReponse;
    private String reponse;

    private void init(){
        btnReturn = findViewById(R.id.btnreturn);
        tvReponse = findViewById(R.id.tvResponse);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();
        Intent intent = getIntent();
        reponse = intent.getStringExtra("reponse");
        tvReponse.setText(reponse);

        btnReturn.setOnClickListener(v -> {
            Intent intent1 = new Intent();
            if(reponse != null)
            {
                setResult(RESULT_OK, intent1);
            }
            else
            {
                setResult(RESULT_CANCELED, intent1);
            }
            finish();
        });
    }
}