package com.canalplus.blueprint.mapper;

import org.mapstruct.Mapper;

import com.canalplus.blueprint.domain.Advisor;
import com.canalplus.blueprint.dto.AdvisorDTO;

@Mapper(componentModel = "spring")
public interface AdvisorMapper {

    AdvisorDTO toDto(Advisor advisor);

    Advisor toModel(AdvisorDTO advisorDTO);
}
