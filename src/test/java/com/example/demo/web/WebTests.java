package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatistiqueImpl statistiqueImpl;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetStatistiquesSuccess() throws Exception {
        Echantillon echantillon = new Echantillon();
        // On suppose qu'Echantillon a une méthode pour ajouter une voiture ou un prix
        echantillon.ajouter(new Voiture("Renault", 10000));

        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(echantillon)));
    }

    @Test
    public void testGetStatistiquesFailure() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenThrow(ArithmeticException.class);

        mockMvc.perform(get("/statistique"))
                .andExpect(status().isBadRequest())
                .andExpect(status().reason("Pas de voiture pour calculer les statistiques"));
    }

    @Test
    public void testCreerVoiture() throws Exception {
        Voiture voiture = new Voiture("Peugeot", 15000);

        doNothing().when(statistiqueImpl).ajouter(voiture);

        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(voiture)))
                .andExpect(status().isOk());
    }
}
