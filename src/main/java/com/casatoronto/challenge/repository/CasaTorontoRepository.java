package com.casatoronto.challenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casatoronto.challenge.model.CasaTorontoModel;

public interface CasaTorontoRepository<T extends CasaTorontoModel, ID> extends MongoRepository<T, ID>{

}
