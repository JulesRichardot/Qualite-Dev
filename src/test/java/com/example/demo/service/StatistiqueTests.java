package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StatistiqueTests {

    @Test
    void statistiqueVoiture() {
        StatistiqueImpl statistique = new StatistiqueImpl();

        Voiture ferrari = mock(Voiture.class);
        when(ferrari.getPrix()).thenReturn(1000);

        statistique.ajouter(ferrari);

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(echantillon.getNombreDeVoitures(), 1);
        assertEquals(echantillon.getPrixMoyen(), 1000);
    }

}