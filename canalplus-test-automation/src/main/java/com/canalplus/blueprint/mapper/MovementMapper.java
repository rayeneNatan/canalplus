package com.canalplus.blueprint.mapper;

import org.mapstruct.Mapper;

import com.canalplus.blueprint.domain.Movement;
import com.canalplus.blueprint.dto.MovementDTO;

@Mapper(componentModel = "spring", uses = {AdvisorMapper.class})
public interface MovementMapper {

    MovementDTO toDto(Movement movement);

    Movement toModel(MovementDTO movementsDTO);
}
