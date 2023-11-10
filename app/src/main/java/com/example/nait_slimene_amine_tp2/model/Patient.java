package com.example.nait_slimene_amine_tp2.model;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nait_slimene_amine_tp2.R;

import java.time.Clock;

public class Patient {
    private float edtxt;
    private boolean isFasting;
    private int sbAge;

public Patient (float edtxt, boolean isFasting,int sbAge) {
    this.edtxt=edtxt;
    this.isFasting=isFasting;

    this.sbAge=sbAge;
}

private void calculer(){
    if(sbAge==0 && edtxt==0){
        System.out.println("Age and valeur mesure invalide");
    }
    else if (sbAge==0) {
        System.out.println("Age ");

    }
    else if (edtxt==0) {
        System.out.println("valeur mesure invalide");
    }else {
        if (isFasting) {
            if (sbAge > 13) {
                if (edtxt >= 5.0 && edtxt <= 7.2) {

                    System.out.println("Niveau de glycémie est normale");
                } else if (edtxt < 5.0) {
                    System.out.println("Niveau de glycémie est trop bas");
                } else if (edtxt > 7.2) {

                    System.out.println("Niveau de glycémie est trop élevée");
                }
            } else if (sbAge >= 6 && sbAge <= 12) {
                if (edtxt >= 5.0 && edtxt <= 10.0) {
                    System.out.println("Niveau de glycémie est normale");
                } else {

                    System.out.println("Niveau de glycémie est trop bas");
                }
            } else if (sbAge < 6) {
                if (edtxt >= 5.5 && edtxt <= 10.0) {
                    System.out.println("Niveau de glycémie est normale");
                } else {
                    notify();
                    System.out.println("Niveau de glycémie est trop bas");
                }
            }
        } else {
            if (edtxt < 10.5) {
                System.out.println("Niveau de glycémie est normale");
            } else {
                System.out.println("Niveau de glycémie est trop élevée");
            }
        }
    }}
    public float getEdtxt() {
        return edtxt;
    }
    public boolean isFasting() {
        return isFasting;
    }
    public int getSbAge() {
        return sbAge;
    }
}


