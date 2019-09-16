package com.canalplus.blueprint.service;

import com.canalplus.blueprint.dto.AddressDTO;
import com.canalplus.blueprint.dto.SubscriberDTO;

/**
 * 
 * @author Rayene
 *
 */
public interface SubscriberService {

    /**
     * 
     * @param id: the id of subscriber
     * @return SubscriberDTO found in database
     */
    public SubscriberDTO findById(Long id);

    /**
     * 
     * @param user
     * @return
     */
    public SubscriberDTO saveOrUpdate(SubscriberDTO user);

    /**
     * 
     * @param id
     * @param address
     * @return
     */
    public SubscriberDTO updateSubscriberAddress(long id, AddressDTO address);
    

}
