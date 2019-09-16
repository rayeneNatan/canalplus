package com.canalplus.blueprint.repository;

import java.util.Optional;

import com.canalplus.blueprint.domain.Address;
import com.canalplus.blueprint.domain.Subscriber;

public interface SubscriberRepository {

    /**
     * 
     * @param subscriber
     * @return the saved subscriber, else empty optional
     */
    public Optional<Subscriber> saveOrUpdate(Subscriber subscriber);

    /**
     * 
     * @param id : the subscriber id
     * @return found subscriber in database, else empty optional
     */
    public Optional<Subscriber> findById(Long id);

    /**
     * 
     * @param id : the subscriber id
     * @param address: new address to update
     * @return subscriber with updated address
     */
    public Optional<Subscriber> updateSubscriberAddress(long id, Address address);

}
