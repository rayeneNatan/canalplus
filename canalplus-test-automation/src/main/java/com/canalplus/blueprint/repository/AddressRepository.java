package com.canalplus.blueprint.repository;

import java.util.Optional;

import com.canalplus.blueprint.domain.Address;

public interface AddressRepository {

    /**
     * 
     * @param address
     * @return the saved address, else empty optional
     */
    public Optional<Address> saveOrUpdate(Address address);

    /**
     * 
     * @param id : the address id
     * @return found address in database, else empty optional
     */
    public Optional<Address> findById(Long id);
}
