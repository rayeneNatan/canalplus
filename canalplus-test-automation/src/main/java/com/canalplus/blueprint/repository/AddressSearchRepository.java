package com.canalplus.blueprint.repository;

import java.util.List;

import com.canalplus.blueprint.domain.Address;

public interface AddressSearchRepository {

    /**
     * 
     * @param searchTerm
     * @return
     */
    List<Address> addressFuzzySearch(String searchTerm);

}
