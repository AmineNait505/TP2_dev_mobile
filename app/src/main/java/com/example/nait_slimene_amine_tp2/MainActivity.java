package com.example.nait_slimene_amine_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private EditText edtxt;
    private RadioButton no;
    private RadioButton yes;
    private Button btnConsulter;
    private SeekBar sbAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        edtxt = findViewById(R.id.edtxt);
        no = findViewById(R.id.no);
        yes = findViewById(R.id.yes);
        btnConsulter = findViewById(R.id.btnConsulter);
        sbAge = findViewById(R.id.sbAge);
        txt=findViewById(R.id.txt);
        sbAge.setOnSeekBarChangeListener(new
                                                   SeekBar.OnSeekBarChangeListener() {
                                                       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                                                           Log.i("Information", "onProgressChanged " + progress);
                                                           txt.setText("Votre Age:"+progress);
                                                       }
                                                       public void onStartTrackingTouch(SeekBar seekBar) {
                                                       }
                                                       public void onStopTrackingTouch(SeekBar seekBar) {
                                                       }

                                                   });
            btnConsulter.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int age=sbAge.getProgress();
                    System.out.println("age ="+age);
                    String valmesurestr=(edtxt.getText().toString());
                    if(age==0 && valmesurestr.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Age and valeur mesure invalide", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (age==0) {
                        Toast.makeText(getApplicationContext(), "age invalide", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if (valmesurestr.isEmpty() ) {
                        Toast.makeText(getApplicationContext(), " valeur mesure invalide", Toast.LENGTH_SHORT).show();
                        return;
                    }else {
                    float valmesure=Float.parseFloat(valmesurestr);

                    System.out.println("val ="+valmesure);
                    boolean isFasting=yes.isChecked();
                    TextView outputTextView = findViewById(R.id.outputText);
                    System.out.println("isFasting? ="+ isFasting);

                    if (isFasting) {
                        if (age > 13) {
                            if (valmesure >= 5.0 && valmesure <= 7.2) {
                                outputTextView.setText("Niveau de glycémie est normale");
                                System.out.println("Niveau de glycémie est normale");
                            } else if (valmesure < 5.0) {
                                outputTextView.setText("Niveau de glycémie est trop bas");

                                System.out.println("Niveau de glycémie est trop bas");
                            } else if (valmesure > 7.2) {
                                outputTextView.setText("Niveau de glycémie trop élevée");
                                System.out.println("Niveau de glycémie est trop élevée");
                            }
                        } else if (age >= 6 && age <= 12) {
                            if (valmesure >= 5.0 && valmesure <= 10.0) {
                                outputTextView.setText("Niveau de glycémie est normale");
                                System.out.println("Niveau de glycémie est normale");
                            } else {
                                outputTextView.setText("Niveau de glycémie est trop bas");
                                System.out.println("Niveau de glycémie est trop bas");
                            }
                        } else if (age < 6) {
                            if (valmesure >= 5.5 && valmesure <= 10.0) {
                                outputTextView.setText("Niveau de glycémie est normale");

                                System.out.println("Niveau de glycémie est normale");
                            } else {
                                outputTextView.setText("Niveau de glycémie est trop bas");
                                System.out.println("Niveau de glycémie est trop bas");
                            }
                        }
                    } else {
                        if (valmesure < 10.5) {
                            outputTextView.setText("Niveau de glycémie est normale");

                            System.out.println("Niveau de glycémie est normale");
                        } else {
                            outputTextView.setText("Niveau de glycémie est trop bas");
                            System.out.println("Niveau de glycémie est trop élevée");
                        }
                    }
                }}});
    }}










