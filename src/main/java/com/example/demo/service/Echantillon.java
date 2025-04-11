package com.example.demo.service;

public class Echantillon {

    int nombreDeVoitures;
    int prixMoyen;

    public Echantillon(){}

    public Echantillon(int nombreDeVoitures, int prixMoyen) {
        this.nombreDeVoitures = nombreDeVoitures;
        this.prixMoyen = prixMoyen;
    }

    public int getNombreDeVoitures() {
        return nombreDeVoitures;
    }

    public void setNombreDeVoitures(int nombreDeVoitures) {
        this.nombreDeVoitures = nombreDeVoitures;
    }

    public int getPrixMoyen() {
        return prixMoyen;
    }

    public void setPrixMoyen(int prixMoyen) {
        this.prixMoyen = prixMoyen;
    }
}
