package com.example.nait_slimene_amine_tp2.controller;

import com.example.nait_slimene_amine_tp2.model.Patient;

public class Controller {
    private Patient patient;
    public Controller(){};

    // Méthode pour initialiser le modèle par les propriétés d'un patient donné par l'utilisateur.
    public void createPatient(int age, float glucoseValue, boolean isFasting) {
        // Créez un nouvel objet Patient avec les informations fournies par l'utilisateur.
        this.patient = new Patient(glucoseValue, isFasting, age);
    }

    // Méthode pour retourner le résultat de l'analyse du niveau de glycémie.
    public String getResponse() {
        return this.patient.calculer();

    }
}