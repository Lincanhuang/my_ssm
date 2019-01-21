package common.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import framework.entity.AbstractEntity;


public abstract class CommonSerivce<T extends AbstractEntity>{
	
	@Autowired
	private SimpleJpaRepository<T, Long> repository;
	
	@Transactional(readOnly = false)
	public T save(T t) {
		t = repository.save(t);
		return t;
	}
	
	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	@Transactional(readOnly = false)
	public void delete(T t) {
		repository.delete(t);
	}
	
	@Transactional(readOnly = false)
	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}
	
}
