package com.canalplus.blueprint.repository;

import java.util.List;
import java.util.Optional;

import com.canalplus.blueprint.domain.Contract;

public interface ContractRepository {

    /**
     * 
     * @param contract
     * @return the saved contract, else empty optional
     */
    public Optional<Contract> saveOrUpdate(Contract contract);

    /**
     * 
     * @param id : the contract id
     * @return found contract in database, else empty optional
     */
    public Optional<Contract> findById(Long id);
    
    /**
     * 
     * @param id : the subscriber id
     * @return list of contract  of the given subscriber id
     */
    public List<Contract> findBySubscriberId(Long id);
}
