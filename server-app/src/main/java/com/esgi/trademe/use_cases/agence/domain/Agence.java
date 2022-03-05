package com.esgi.trademe.use_cases.agence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Objet agence des ressources
 */

@Document(collection = "Agences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Agence {

	@Id
	private String id;
	private String cost;
	private String libelle;
	@DBRef
	private Address adresse;

}
