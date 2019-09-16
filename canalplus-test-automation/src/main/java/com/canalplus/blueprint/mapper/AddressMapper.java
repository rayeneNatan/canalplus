package com.canalplus.blueprint.mapper;

import org.mapstruct.Mapper;

import com.canalplus.blueprint.domain.Address;
import com.canalplus.blueprint.dto.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDto(Address address);

    Address toModel(AddressDTO addressDTO);
}
