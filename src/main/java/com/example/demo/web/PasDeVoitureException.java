package com.example.demo.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasDeVoitureException extends Exception {

    public PasDeVoitureException(){
        super("Pas de voiture pour calculer les statistiques");
    }

}
