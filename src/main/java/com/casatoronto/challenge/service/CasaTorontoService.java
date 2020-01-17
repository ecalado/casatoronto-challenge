package com.casatoronto.challenge.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.datatables.DataTablesInput;
import org.springframework.data.mongodb.datatables.DataTablesOutput;

import com.casatoronto.challenge.exception.ResourceNotFoundException;
import com.casatoronto.challenge.model.CasaTorontoModel;
import com.casatoronto.challenge.payload.CasaTorontoRequest;
import com.casatoronto.challenge.repository.CasaTorontoRepository;

interface CasaTorontoService<T extends CasaTorontoModel, P extends CasaTorontoRequest, ID extends Serializable> {

	public T getInstanceOfEntityModel();

	public CasaTorontoRepository<T, ID> getRepository();

	default T create(P payloadRequest) {
		T t = getInstanceOfEntityModel();

		this.create(payloadRequest, t);

		return t;
	}

	default T create(P payloadRequest, T t) {
		BeanUtils.copyProperties(payloadRequest, t);

		return t;
	}

	default List<T> findAll() {
		return getRepository().findAll();
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findById(Object)
	 */
	default Optional<T> findById(ID id) {
		T t = getRepository().findById(id).orElseThrow(
				() -> new ResourceNotFoundException(getInstanceOfEntityModel().getClass().getSimpleName(), "id", id));
		return Optional.of(t);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#insert(Object)
	 */
	default Optional<T> insert(P payloadRequest) {
		T t = create(payloadRequest);

		return Optional.of(getRepository().insert(t));
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#save(Object)
	 */
	default Optional<T> update(ID id, P payloadRequest) {
		T t = findById(id).orElseThrow(
				() -> new ResourceNotFoundException(getInstanceOfEntityModel().getClass().getSimpleName(), "id", id));

		t = this.create(payloadRequest, t);

		return Optional.of(getRepository().save(t));
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#deleteById(Object)
	 */
	default void deleteById(ID id) {
		getRepository().deleteById(id);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(Pageable)
	 */
	default Page<T> findAll(Integer pageNo, Integer pageSize, String sortBy, String orderedBy) {
		Pageable paging = null;

		if (orderedBy.equals("asc")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		}

		return getRepository().findAll(paging);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(DataTablesInput)
	 */
	default DataTablesOutput<T> findAll(DataTablesInput input) {
		return getRepository().findAll(input);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(DataTablesInput,
	 *      Criteria)
	 */
	default DataTablesOutput<T> findAll(DataTablesInput input, Criteria additionalCriteria) {
		return getRepository().findAll(input, additionalCriteria);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(DataTablesInput,
	 *      Criteria, Criteria)
	 */
	default DataTablesOutput<T> findAll(DataTablesInput input, Criteria additionalCriteria,
			Criteria preFilteringCriteria) {
		return getRepository().findAll(input, additionalCriteria, preFilteringCriteria);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(DataTablesInput,
	 *      Function)
	 */
	default <R> DataTablesOutput<R> findAll(DataTablesInput input, Function<T, R> converter) {
		return getRepository().findAll(input, converter);
	}

	/**
	 * @see com.casatoronto.challenge.repository.CasaTorontoRepository#findAll(DataTablesInput,
	 *      Criteria, Criteria, Function)
	 */
	default <R> DataTablesOutput<R> findAll(DataTablesInput input, Criteria additionalCriteria,
			Criteria preFilteringCriteria, Function<T, R> converter) {
		return getRepository().findAll(input, additionalCriteria, preFilteringCriteria, converter);
	}

}
