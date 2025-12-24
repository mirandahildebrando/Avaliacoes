package com.brando_miranda.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brando_miranda.demo.model.Avaliacao;
import com.mongodb.client.MongoDatabase;

@Repository
public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {

}
