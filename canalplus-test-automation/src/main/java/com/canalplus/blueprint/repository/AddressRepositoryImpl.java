package com.canalplus.blueprint.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canalplus.blueprint.domain.Address;

@Repository
public class AddressRepositoryImpl implements AddressRepository {

    protected final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    protected Session getSession() {
	return (Session) entityManager.getDelegate();
    }

    @Override
    public Optional<Address> saveOrUpdate(Address address) {
	log.debug("[saveOrUpdate address]: {}", address);
	getSession().saveOrUpdate(address);
	entityManager.flush();
	return Optional.ofNullable(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
	log.debug("[find Address By Id]: {}", id);
	Address address = getSession().get(Address.class, id);
	return Optional.ofNullable(address);
    }

}
