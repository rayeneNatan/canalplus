package com.canalplus.blueprint.mapper;

import org.mapstruct.Mapper;

import com.canalplus.blueprint.domain.Subscriber;
import com.canalplus.blueprint.dto.SubscriberDTO;

@Mapper(componentModel = "spring", uses = { AddressMapper.class, AdvisorMapper.class, MovementMapper.class })
public interface SubscriberMapper {

    SubscriberDTO toDto(Subscriber subscriber);

    Subscriber toModel(SubscriberDTO subscriberDTO);
}
