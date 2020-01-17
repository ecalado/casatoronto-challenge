package com.casatoronto.challenge.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.datatables.DataTablesRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.casatoronto.challenge.model.CasaTorontoModel;

@NoRepositoryBean
public interface CasaTorontoRepository<T extends CasaTorontoModel, ID extends Serializable>
		extends DataTablesRepository<T, ID> {

}
