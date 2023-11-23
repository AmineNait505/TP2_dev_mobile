package com.example.nait_slimene_amine_tp2.model;

public class Patient {
    private float edtxt;
    private boolean isFasting;
    private int sbAge;

    public Patient(float edtxt, boolean isFasting, int sbAge) {
        this.edtxt = edtxt;
        this.isFasting = isFasting;
        this.sbAge = sbAge;
    }

    public String calculer() {
        if (sbAge == 0 && edtxt == 0) {
            return "Age and valeur mesure invalide";
        } else if (sbAge == 0) {
            return "Age";
        } else if (edtxt == 0) {
            return "valeur mesure invalide";
        } else {
            if (isFasting) {
                if (sbAge > 13) {
                    if (edtxt >= 5.0 && edtxt <= 7.2) {
                        return "Niveau de glycémie est normale";
                    } else if (edtxt < 5.0) {
                        return "Niveau de glycémie est trop bas";
                    } else if (edtxt > 7.2) {
                        return "Niveau de glycémie est trop élevée";
                    }
                } else if (sbAge >= 6 && sbAge <= 12) {
                    if (edtxt >= 5.0 && edtxt <= 10.0) {
                        return "Niveau de glycémie est normale";
                    } else {
                        return "Niveau de glycémie est trop bas";
                    }
                } else if (sbAge < 6) {
                    if (edtxt >= 5.5 && edtxt <= 10.0) {
                        return "Niveau de glycémie est normale";
                    } else {
                        return "Niveau de glycémie est trop bas";
                    }
                }
            } else {
                if (edtxt < 10.5) {
                    return "Niveau de glycémie est normale";
                } else {
                    return "Niveau de glycémie est trop élevée";
                }
            }
        }
    return null;}

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
