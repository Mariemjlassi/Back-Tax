package com.projet.app.dto;

import com.projet.app.models.Zone;

import lombok.Data;

@Data
public class ZoneRequest {
	private Long arrondissementId;
    private Zone zone;
}
