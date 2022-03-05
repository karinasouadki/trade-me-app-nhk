package com.esgi.trademe.use_cases.agence.domain;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgenceRepository extends MongoRepository<Agence, String> {

    List<Agence> findAllByAdresse_Ville(String ville);
    Optional<Agence> findAllByLibelle(String libelle);
}
