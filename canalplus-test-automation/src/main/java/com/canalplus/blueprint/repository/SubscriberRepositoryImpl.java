package com.canalplus.blueprint.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canalplus.blueprint.domain.Address;
import com.canalplus.blueprint.domain.Subscriber;
import com.canalplus.blueprint.exception.ResourceNotFoundException;

/**
 * 
 * @author Rayene
 * @param <T>
 *
 */
@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository {

    protected final Logger log = LogManager.getLogger(getClass());

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    protected Session getSession() {
	return (Session) entityManager.getDelegate();
    }

    @Override
    public Optional<Subscriber> saveOrUpdate(Subscriber subscriber) {
	log.debug("[saveOrUpdate Subscriber]: {}", subscriber);
	getSession().saveOrUpdate(subscriber);
	entityManager.flush();
	log.debug("Subscriber {} is successfully saveOrUpdate", subscriber);
	return Optional.ofNullable(subscriber);
    }

    @Override
    public Optional<Subscriber> findById(Long id) {
	log.debug("[find Subscriber By Id]: {}", id);
	Subscriber subscriber = getSession().get(Subscriber.class, id);
	log.debug("Subscriber {} is fetched", subscriber);
	return Optional.ofNullable(subscriber);
    }

    @Override
    public Optional<Subscriber> updateSubscriberAddress(long id, Address address) {
	log.debug("[updateSubscriberAddress]: Subscriber id {}, and address {}", id, address);
	Subscriber subscriber = getSubscriber(id);

	if (null != address.getAddressID()) {
	    log.debug("get address with {} from database", address.getAddressID());
	    Address newAddress = getAddress(address);
	    subscriber.setAddress(newAddress);
	} else {
	    log.debug("create new active address {} ", address);
	    address.setActive(Boolean.TRUE);
	    subscriber.setAddress(address);
	}
	return saveOrUpdate(subscriber);
    }

    /**
     * 
     * @param address: given address with id not null
     * @return address entity if exist, else throw ResourceNotFoundException
     */
    private Address getAddress(Address address) {
	return addressRepository.findById(address.getAddressID()).map(u -> {
	    u.setActive(Boolean.TRUE);
	    return u;
	}).orElseThrow(() -> new ResourceNotFoundException("address not found", address.getAddressID().toString()));
    }

    /**
     * 
     * @param id: the id of subscriber
     * @return the entity Subscriber if exists
     */
    private Subscriber getSubscriber(long id) {
	Optional<Subscriber> optSubscriber = findById(id);
	if (!optSubscriber.isPresent()) {
	    throw new ResourceNotFoundException("updateSubscriberAddress", Long.toString(id));
	}
	return optSubscriber.get();
    }

}
