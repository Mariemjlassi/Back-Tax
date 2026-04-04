package com.projet.app.services;

import com.projet.app.models.Proprietaire;
import com.projet.app.repository.ProprietaireRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProprietaireServiceTest {

    @Mock
    private ProprietaireRepository proprietaireRepository;

    @InjectMocks
    private ProprietaireService proprietaireService;

    @Test
    @DisplayName("Devrait créer un nouveau propriétaire quand le CIN n'existe pas")
    void createNewProprietaireTest() {
        // GIVEN
        Proprietaire input = new Proprietaire("Jlassi", "Mariem", "12345678", "Tunis", "mariem@test.com", "22113344");
        
        // On simule que la recherche par CIN ne trouve rien
        when(proprietaireRepository.findByCin("12345678")).thenReturn(null);
        // On simule la sauvegarde
        when(proprietaireRepository.save(any(Proprietaire.class))).thenReturn(input);

        // WHEN
        Proprietaire result = proprietaireService.create(input);

        // THEN
        assertNotNull(result);
        assertEquals("12345678", result.getCin());
        // On vérifie que le repository a bien été appelé une fois pour find et une fois pour save
        verify(proprietaireRepository, times(1)).findByCin("12345678");
        verify(proprietaireRepository, times(1)).save(input);
    }

    @Test
    @DisplayName("Devrait mettre à jour le propriétaire existant si le CIN est déjà présent")
    void updateExistingProprietaireByCinTest() {
        // GIVEN
        Proprietaire existing = new Proprietaire("AncienNom", "AncienPrenom", "12345678", "AncienneAdresse", "old@test.com", "000");
        existing.setId(1L);

        Proprietaire input = new Proprietaire("Jlassi", "Mariem", "12345678", "Tunis", "mariem@test.com", "22113344");

        // On simule que findByCin trouve le propriétaire existant
        when(proprietaireRepository.findByCin("12345678")).thenReturn(existing);
        // On simule le save de l'objet modifié
        when(proprietaireRepository.save(any(Proprietaire.class))).thenReturn(existing);

        // WHEN
        Proprietaire result = proprietaireService.create(input);

        // THEN
        assertNotNull(result);
        assertEquals("Jlassi", result.getNom()); // Le nom doit avoir été mis à jour
        assertEquals(1L, result.getId()); // L'ID doit rester le même (celui de l'ancien)
        
        verify(proprietaireRepository, times(1)).save(existing);
    }

    @Test
    @DisplayName("Devrait retourner un propriétaire par son ID")
    void readByIdTest() {
        // GIVEN
        Proprietaire p = new Proprietaire();
        p.setId(10L);
        when(proprietaireRepository.findById(10L)).thenReturn(Optional.of(p));

        // WHEN
        Proprietaire result = proprietaireService.readById(10L);

        // THEN
        assertNotNull(result);
        assertEquals(10L, result.getId());
    }

    @Test
    @DisplayName("Devrait retourner null si le propriétaire n'existe pas")
    void readByIdNotFoundTest() {
        // GIVEN
        when(proprietaireRepository.findById(99L)).thenReturn(Optional.empty());

        // WHEN
        Proprietaire result = proprietaireService.readById(99L);

        // THEN
        assertNull(result);
    }
}