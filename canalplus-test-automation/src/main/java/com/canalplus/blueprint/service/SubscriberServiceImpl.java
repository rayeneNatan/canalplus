package com.canalplus.blueprint.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canalplus.blueprint.domain.Subscriber;
import com.canalplus.blueprint.dto.AddressDTO;
import com.canalplus.blueprint.dto.SubscriberDTO;
import com.canalplus.blueprint.exception.ResourceNotFoundException;
import com.canalplus.blueprint.mapper.AddressMapper;
import com.canalplus.blueprint.mapper.SubscriberMapper;
import com.canalplus.blueprint.repository.SubscriberRepository;

@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

    protected final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    SubscriberMapper subscriberMapper;

    @Autowired
    AddressMapper addressMapper;

    @Override
    public SubscriberDTO findById(Long id) {
	Optional<Subscriber> subscriber = subscriberRepository.findById(id);
	if (!subscriber.isPresent()) {
	    throw new ResourceNotFoundException("Subscriber", "id");
	}
	return subscriberMapper.toDto(subscriber.get());
    }

    @Override
    public SubscriberDTO saveOrUpdate(SubscriberDTO subscriberDTO) {
	if (null == subscriberDTO) {
	    logger.error("subscriberDTO {} is ", subscriberDTO);
	    throw new ResourceNotFoundException("saveOrUpdate", "subscriberDTO");
	}
	Optional<Subscriber> subscriber = subscriberRepository.saveOrUpdate(subscriberMapper.toModel(subscriberDTO));
	if (!subscriber.isPresent()) {
	    throw new ResourceNotFoundException("saveOrUpdate", "subscriber");
	}
	logger.info("Subscriber {} is successfully updated", subscriberDTO);
	return subscriberMapper.toDto(subscriber.get());
    }

    @Override
    public SubscriberDTO updateSubscriberAddress(long id, AddressDTO addressDTO) {
	if (null == addressDTO) {
	    throw new ResourceNotFoundException("updateSubscriberAddress", "addressDTO");
	}
	Optional<Subscriber> updatedSub = subscriberRepository.updateSubscriberAddress(id, addressMapper.toModel(addressDTO));
	logger.info("Subscriber's address {} is successfully updated", addressDTO);

	return subscriberMapper.toDto(updatedSub.get());
    }
   
}
