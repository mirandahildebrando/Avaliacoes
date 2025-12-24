package com.brando_miranda.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brando_miranda.demo.model.Avaliacao;


@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {

    Optional<Avaliacao> findById(String id);
   



}
