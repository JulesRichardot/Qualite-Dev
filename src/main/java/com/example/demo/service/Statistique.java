package com.example.demo.service;

import com.example.demo.data.Voiture;

public interface Statistique {

    public void ajouter(Voiture voiture);

    public Echantillon prixMoyen() throws ArithmeticException;

}
