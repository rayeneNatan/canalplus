package com.canalplus.blueprint.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.canalplus.blueprint.domain.Contract;
import com.canalplus.blueprint.dto.ContractDTO;

@Mapper(componentModel = "spring", uses = {SubscriberMapper.class})
public interface ContractMapper {

    ContractDTO toDto(Contract contract);

    Contract toModel(ContractDTO contractDTO);

    List<ContractDTO> toDto(List<Contract> contracts);

}
