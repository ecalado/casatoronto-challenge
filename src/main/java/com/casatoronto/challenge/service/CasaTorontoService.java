package com.casatoronto.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.casatoronto.challenge.exception.ResourceNotFoundException;
import com.casatoronto.challenge.model.CasaTorontoModel;
import com.casatoronto.challenge.payload.CasaTorontoRequest;
import com.casatoronto.challenge.repository.CasaTorontoRepository;

interface CasaTorontoService<T extends CasaTorontoModel, P extends CasaTorontoRequest, ID> {

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

	default Page<T> findAll(Integer pageNo, Integer pageSize, String sortBy, String orderedBy) {
		Pageable paging = null;

		if (orderedBy.equals("asc")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
		}

		return getRepository().findAll(paging);
	}

	default Optional<T> findById(ID id) {
		T t = getRepository().findById(id).orElseThrow(
				() -> new ResourceNotFoundException(getInstanceOfEntityModel().getClass().getSimpleName(), "id", id));
		return Optional.of(t);
	}

	default Optional<T> insert(P payloadRequest) {
		T t = create(payloadRequest);

		return Optional.of(getRepository().insert(t));
	}

	default Optional<T> update(ID id, P payloadRequest) {
		T t = findById(id).orElseThrow(
				() -> new ResourceNotFoundException(getInstanceOfEntityModel().getClass().getSimpleName(), "id", id));

		t = this.create(payloadRequest, t);

		return Optional.of(getRepository().save(t));
	}

	default void deleteById(ID id) {
		getRepository().deleteById(id);
	}
}
